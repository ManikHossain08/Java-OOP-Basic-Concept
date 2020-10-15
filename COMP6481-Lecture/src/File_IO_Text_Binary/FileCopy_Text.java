package File_IO_Text_Binary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileCopy_Text {

	public static void main(String[] args) {
		PrintWriter pw = null;
		Scanner sc = null;

		try {
			fileCopy(pw, sc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	private static void fileCopy(PrintWriter pw, Scanner sc) throws FileNotFoundException {
		System.out.println("Please enter the name of the file you need to copy"
				+ " as well as the name of the file to be created: ");

		Scanner kb = new Scanner(System.in);
		String s1 = kb.next();
		String s2 = kb.next();
		kb.close();

		pw = new PrintWriter(new FileOutputStream(s2));
		sc = new Scanner(new FileInputStream(s1));

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			pw.println(line);
		}
		System.out.println("File has been copied ");
		pw.close(); // Must close the files to flush the buffers
		sc.close(); // Must close the files to flush the buffers
	}

}
