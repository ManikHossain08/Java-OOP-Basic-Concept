package File_IO_Text;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/*
 * You can't use delimiter with BufferedReader, however, you can use Scanner and call useDelimiter() method, e.g.:

	Scanner scanner = new Scanner(new FileInputStream("<file>"));
	scanner.useDelimiter("\b");
 */

// http://www.c-jump.com/bcc/c257c/Week10/W10_0110_bufferedreader_readi.htm
public class FileIO_BufferedReader {

	public static void main(String[] args) {

		PrintWriter pw = null;
		Scanner kb = new Scanner(System.in);

		BufferedReader br = null; // Create a BufferedReader object to read from input files

		System.out.println("Please enter the name of the file you need to copy"
				+ " as well as the name of the file to be created: ");
		String s1 = kb.next();
		String s2 = kb.next();
		kb.close();
		
		try {
			br = new BufferedReader(new FileReader(s1));
			pw = new PrintWriter(new FileOutputStream(s2));
			// At this moment, both streams exist, so call the method to copy the file
			// However, possible IOException may still occur while reading the input file
			fileCopy(br, pw);
		} catch (IOException e) {
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);

		}

		System.out.println("File has been copied ");

		// At that moment the files have been copied and we wish to display their
		// contents
		// on the screen; however by now they have already been closed, so we must
		// re-open them

		// Try to re-open the original file
		try {
			br = new BufferedReader(new FileReader(s1));
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);
		}

		// Now try to display the contents of the original file
		System.out.println("\nHere are the contents of file " + s1 + ":");
		System.out.println("======================================================");

		try {
			displayFileContentsCharByChar(br);
			br = new BufferedReader(new FileReader(s1));
			displayFileContentsCharByChar(br); // read char by char

			br = new BufferedReader(new FileReader(s1));
			displayFileContentsLineByLine(br); // read char by char
		

		} catch (IOException e) {
			System.out.println("Error: An error has occurred while reading from the " + s1 + " file. ");
			System.out.println("Program will terminate.");
			System.exit(0);
		}

	}

	

	private static void fileCopy(BufferedReader b, PrintWriter p) throws IOException {

		// Read line by line from input file and copy it to output file
		String s;

		s = b.readLine();
		while (s != null) // The readLine() method returns null when it is EOF
		{
			p.println(s);
			s = b.readLine();
		}
		// Must close the files to flush the buffers
		b.close();
		p.close();

	}

	private static void displayFileContentsCharByChar(BufferedReader b) throws IOException {

		// Read line by line from input file and display it (on the monitor)
		// The method actually uses the read() method (instead of readLine(), which we
		// could have surely used here without a problem). The read() method reads
		// character by character, but each character is read as type int, so casting is
		// needed
		// so that we can display character and not their integer values

		int x;

		x = b.read();
		while (x != -1) {
			//System.out.print((char) x); // MUST CAST; otherwise all what is read will be shown as integers
			x = b.read();
		}
		// Must close the file
		b.close();

	}

	private static void displayFileContentsLineByLine(BufferedReader br) throws IOException {
		int countLine = 1;
		String thisLine = null;
		while ((thisLine = br.readLine()) != null) {
			
			//String[] moreFormat = thisLine.split("\t");
			
			System.out.println(thisLine);
			countLine++;
		}
		
		System.out.println(countLine);
		
		br.close();

	}

}
