package FileManagement;

import java.util.Scanner;

public class ScannerManagement {
	private static Scanner[] opennedScanner = GenerateOutputFiles.bibScanner;

	public static void closeAllScanner() {
		for (int i = 0; i < opennedScanner.length; i++) {
			if (opennedScanner[i] != null)
				opennedScanner[i].close();
		}
	}

	public static void closeSingleScanner(Scanner scanner) {
		scanner.close();
	}
}
