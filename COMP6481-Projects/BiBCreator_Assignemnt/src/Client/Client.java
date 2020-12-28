package Client;

import java.util.List;
import java.util.Scanner;

import BibFileProperty.BibAttributes;
import BibFileProperty.ProcessBibFiles;
import FileManagement.GenerateOutputFiles;
import FileManagement.ManageOutputFiles;
import FileManagement.ScannerManagement;
import Messaging.SystemMessage;
import RefferenceFormatGenerator.RefferenceFormatFactory;
import ReviewOutputFiles.ReviewJournalFiles;

/**
* 
* <h1> BibCreator! </h1>
* 
* <p>
* COMP6481 – Fall 2020
* Programming and Problem Solving
* Assignment # 2
* Due Date: November 6, 2020 by 11:59PM
*
* Bibliography Creator Application using Java Programming.
*
* @author  Md Manik Hossain
* @version 1.0
* @since   2020-October-20 
*/

public class Client {

	private static int noOfInvalidFile = 0;
	private static Scanner scanner = null;

	
	/**
	 * @param args unused
	 */
	public static void main(String[] args) {

		SystemMessage.welcomeMessgae();
		ManageOutputFiles.deleteFilesFromDirectory();
		GenerateOutputFiles.generateAllTypesOfJournalFiles();
		processFilesForValidation();
		reviewOutputFile();
	}

	private static void processFilesForValidation() {

		Scanner[] opennedBibScanner = GenerateOutputFiles.bibScanner;

		for (int i = 0; i < opennedBibScanner.length; i++) {
			int fileNo = i + 1;
			List<BibAttributes> atricles = ProcessBibFiles.checkValidity(opennedBibScanner[i], fileNo);
			if (atricles != null) {
				RefferenceFormatFactory.IEEEFormat(atricles, fileNo);
				RefferenceFormatFactory.ACMFormat(atricles, fileNo);
				RefferenceFormatFactory.NJFormat(atricles, fileNo);

			} else {
				noOfInvalidFile++;
			}
		}

		ScannerManagement.closeAllScanner();
		SystemMessage.countInvalidFileMessage(noOfInvalidFile);
	}


	private static void reviewOutputFile() {
		SystemMessage.reviewFileMsg();
		scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		ReviewJournalFiles.reviewRequestedFile(fileName, scanner);
		scanner.close();
	}

}
