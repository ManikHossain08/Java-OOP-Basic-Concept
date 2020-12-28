package FileManagement;

import java.io.File;

public class ManageOutputFiles {

	/**
	 * @param directoryToBeDeleted
	 * @return
	 */
	public static boolean deleteFilesFromDirectory() {

		for (int i = 1; i <= 10; i++) {
			File ieee = new File("IEEE" + i + ".json");
			File acm = new File("ACM" + i + ".json");
			File nj = new File("NJ" + i + ".json");

			deleteSpecificFilesFromDirectory(ieee);
			deleteSpecificFilesFromDirectory(acm);
			deleteSpecificFilesFromDirectory(nj);
		}

		return true;
	}

	public static boolean deleteSpecificFilesFromDirectory(File file) {

		if (file.exists()) {
			file.delete();
		}

		return true;
	}

	/**
	 * @param fileIndex
	 * @return
	 */
	public static boolean deleteInvalidOutputFiles(int fileIndex) {

		File ieee = new File("IEEE" + fileIndex + ".json");
		File acm = new File("ACM" + fileIndex + ".json");
		File nj = new File("NJ" + fileIndex + ".json");

		if (ieee.exists()) {
			ieee.delete();
		}

		if (acm.exists()) {
			acm.delete();
		}

		if (nj.exists()) {
			nj.delete();
		}

		return true;
	}

}
