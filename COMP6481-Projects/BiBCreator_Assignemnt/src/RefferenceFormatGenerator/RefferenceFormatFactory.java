package RefferenceFormatGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import BibFileProperty.BibAttributes;

public class RefferenceFormatFactory {
	private static String fileName;

	/**
	 * @param atricles
	 * @param fileIndex
	 */
	public static void IEEEFormat(List<BibAttributes> atricles, int fileIndex) {

		fileName =  "IEEE" + fileIndex + ".json";
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileOutputStream(fileName));
			String formatedStr = OrganizeRefferencesInString.organizeInIEEFormat(atricles);
			putGereneratedRefferenceOnOutputFile(pw, formatedStr);
		} catch (IOException e) {
			System.out.println("Error: An error has occurred while reading from the " + fileName + " file. ");
		}

	}

	public static void ACMFormat(List<BibAttributes> atricles, int fileIndex) {

		fileName = "ACM" + fileIndex + ".json";
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileOutputStream(fileName));
			String formatedStr = OrganizeRefferencesInString.organizeInACMFormat(atricles);
			putGereneratedRefferenceOnOutputFile(pw, formatedStr);
		} catch (IOException e) {
			System.out.println("Error: An error has occurred while reading from the " + fileName + " file. ");
		}

	}

	public static void NJFormat(List<BibAttributes> atricles, int fileIndex) {

		fileName = "NJ" + fileIndex + ".json";
		PrintWriter pw = null;

		try {
			pw = new PrintWriter(new FileOutputStream(fileName));
			String formatedStr = OrganizeRefferencesInString.organizeInNJFormat(atricles);
			putGereneratedRefferenceOnOutputFile(pw, formatedStr);
		} catch (IOException e) {
			System.out.println("Error: An error has occurred while reading from the " + fileName + " file. ");
		}

	}

	/**
	 * @param printer
	 * @param allFormatedReffences
	 * @throws IOException
	 */
	private static void putGereneratedRefferenceOnOutputFile(PrintWriter printer, String allFormatedReffences)
			throws IOException {

		printer.println(allFormatedReffences);
		printer.close();
	}

}
