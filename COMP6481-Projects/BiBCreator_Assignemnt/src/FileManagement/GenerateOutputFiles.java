package FileManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import Messaging.SystemMessage;

/**
 * @author manikhossain
 *
 */
public class GenerateOutputFiles {

	//public static final String inputPath = "./";
	//public static final String outputPath = "./";
	public static final Scanner[] bibScanner = new Scanner[10];

	/**
	 * 
	 */
	public static void generateAllTypesOfJournalFiles() {
		
		for (int fileIndex = 0; fileIndex < 10; fileIndex++) {
			
			String fileName = "Latex" + (fileIndex + 1) + ".bib";
			try {
				bibScanner[fileIndex] = new Scanner(new FileInputStream(fileName));
				fileCreations(fileIndex + 1);

			} catch (FileNotFoundException e) {
				SystemMessage.coundNotOpenFile(fileName);
				ManageOutputFiles.deleteFilesFromDirectory();
				ScannerManagement.closeAllScanner();
				System.exit(0);
			}

		}
	}

	/**
	 * @param fileIndex
	 * @throws FileNotFoundException
	 */
	public static void fileCreations(int fileIndex) throws FileNotFoundException {

		try {
			File ieee = new File("IEEE" + fileIndex + ".json");
			File acm = new File("ACM" + fileIndex + ".json");
			File nj = new File("NJ" + fileIndex + ".json");
			ieee.createNewFile();
			acm.createNewFile();
			nj.createNewFile();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			//e.printStackTrace();
		}

	}
}
