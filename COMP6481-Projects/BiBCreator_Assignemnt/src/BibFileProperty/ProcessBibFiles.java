package BibFileProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ExceptionsGenerator.FileInvalidException;
import FileManagement.ManageOutputFiles;
import Messaging.SystemMessage;

public class ProcessBibFiles {

	private static List<BibAttributes> atricles = null;
	private static BibAttributes newAtricle = null;
	private static String emptyFields = "";
	private static int noOfArticle = 0;
	private static int bibFileNo = 0;

	/**
	 * @param scanner
	 * @param fileNo
	 * @return
	 */
	public static List<BibAttributes> checkValidity(Scanner scanner, int fileNo) {
		noOfArticle = 0;
		emptyFields = "";
		bibFileNo = fileNo;
		atricles = new ArrayList<BibAttributes>();

		while (scanner.hasNextLine()) {
			String eachLine = scanner.nextLine();

			if (!checkValidityAndfindAttribues(eachLine))
				return atricles;
		}
		atricles.add(newAtricle);
		return atricles;
	}

	/**
	 * @param line
	 * @return
	 */
	public static boolean checkValidityAndfindAttribues(String line) {
		if (line.startsWith("@ARTICLE")) {

			if (noOfArticle != 0) {
				atricles.add(newAtricle);
			}
			newAtricle = new BibAttributes();
			noOfArticle++;
			return true;
		}
		String[] attribute = line.split("=");
		if (attribute.length == 0 || attribute.length == 1)
			return true;
		else if (attribute.length == 2) {
			try {
				if (!isValidArticle(attribute)) {
					return false;
				}
			} catch (FileInvalidException e) {
				atricles = null;
				ManageOutputFiles.deleteInvalidOutputFiles(bibFileNo);
				return false;
			}
		}
		setAllAttribute(attribute);

		return true;
	}

	/**
	 * @param attr
	 * @return
	 * @throws FileInvalidException
	 */
	private static boolean isValidArticle(String[] attr) throws FileInvalidException {
		String[] isEmpty = attr[1].substring(1).split("}");
		if (isEmpty[0].isBlank() || isEmpty[0].isEmpty() || isEmpty[0].contentEquals("")) {
			emptyFields = attr[0];
			String errMsg = SystemMessage.invalidFileMessage(bibFileNo + "", emptyFields);
			throw new FileInvalidException(errMsg);

		}
		return true;
	}

	/**
	 * @param attribute
	 */
	private static void setAllAttribute(String[] attribute) {

		String value = attribute[1].strip().substring(1);
		String splitedValue = value.split("}")[0];

		switch (attribute[0]) {
		case "author":
			List<Authors> authors = handleAuthorName(value);
			newAtricle.setAuthor(authors);
			break;

		case "journal":
			newAtricle.setJournal(splitedValue);
			break;

		case "title":
			newAtricle.setTitle(splitedValue);
			break;

		case "year":
			int year = Integer.parseInt(splitedValue);
			newAtricle.setYear(year);
			break;

		case "volume":
			newAtricle.setVolume(splitedValue);
			break;

		case "number":
			int number = Integer.parseInt(splitedValue);
			newAtricle.setNumber(number);
			break;

		case "pages":
			newAtricle.setPages(splitedValue);
			break;

		case "doi":
			newAtricle.setDoi(splitedValue);
			break;

		case "ISSN":
			newAtricle.setIssn(splitedValue);
			break;

		case "month":
			newAtricle.setMonth(splitedValue);
			break;

		default:
			break;
		}

	}

	/**
	 * @param names
	 * @return
	 */
	private static List<Authors> handleAuthorName(String names) {

		List<Authors> authors = new ArrayList<>();
		names = names.split("}")[0];
		String[] nameList = names.split("and");

		for (int i = 0; i < nameList.length; i++) {
			authors.add(new Authors(nameList[i].strip()));
		}

		return authors;
	}

}
