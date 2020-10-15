package File_IO_Text_Binary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadDelimitedText {

	public static void main(String[] args) {
		BufferedReader br = null;
		BufferedReader br1 = null;
		try {

			br = new BufferedReader(new FileReader("delimitedText.txt"));
			br1 = new BufferedReader(new FileReader("pipe.txt"));

			try {
				readDelimitedFileContents(br);
				readDelimitedPipeText(br1);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Problem opening files. Cannot proceed to copy.");
			System.out.println("Program will terminate.");
			System.exit(0);
		}

	}

	private static void readDelimitedPipeText(BufferedReader br1) throws IOException {
		String thisLine = null;
		while ((thisLine = br1.readLine()) != null) {
			parsePipeTextLine(thisLine);
		}
		br1.close();
	}

	private static void parsePipeTextLine(String str) {

		Scanner read = new Scanner(str);
		read.useDelimiter("[|]");
		String book, author, price;

		while (read.hasNext()) {
			book = read.next();
			   author = read.next();
			   price = read.next();
			   System.out.println("Book - " + book + " Author - " + author + 
			     " Price - " + price);  
		}

		read.close();

	}

	private static void readDelimitedFileContents(BufferedReader br) throws IOException {
		String thisLine = null;
		while ((thisLine = br.readLine()) != null) {
			readDelimitedText_ByParseLine(thisLine);
		}
		br.close();
	}

	private static void readDelimitedText_ByParseLine(String str) {

		Scanner read = new Scanner(str);
		read.useDelimiter(",");
		String title, category, runningTime, year, price;

		while (read.hasNext()) {
			title = read.next();
			category = read.next();
			runningTime = read.next();
			year = read.next();
			price = read.next();
			System.out.println(title + " " + category + " " + runningTime + " " + year + " " + price + "\n"); // just
																												// for																								// debugging
		}

		read.close();

	}

}
