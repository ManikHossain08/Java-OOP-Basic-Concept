package ReviewOutputFiles;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import Messaging.SystemMessage;

public class ReviewJournalFiles {
	private static BufferedReader buffer = null;
	private static String refference;

	/**
	 * @param fileName
	 * @param scanner
	 */
	public static void reviewRequestedFile(String fileName, Scanner scanner) {

		try {

			buffer = new BufferedReader(new FileReader(fileName));
			reviewFile(buffer, fileName);

		} catch (FileNotFoundException notFound) {

			SystemMessage.fileNotFoundMsg();
			SystemMessage.secondChanceReviewFileMsg();
			SystemMessage.reviewFileMsg();
			fileName = scanner.nextLine();

			try {
				buffer = new BufferedReader(new FileReader(fileName));
				reviewFile(buffer, fileName);

			} catch (FileNotFoundException e) {
				SystemMessage.fileNotFoundAgainMsg();
				System.exit(0);

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @param bReader
	 * @param fileName
	 * @throws IOException
	 */
	public static void reviewFile(BufferedReader bReader, String fileName) throws IOException {
		SystemMessage.successReviewFileMsg(fileName);
		refference = bReader.readLine();
		while (refference != null) {
			System.out.println(refference);
			refference = bReader.readLine();
		}
		bReader.close();

	}
}
