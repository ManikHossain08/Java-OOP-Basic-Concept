package Lab_4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lab4_Part2 {

	public static void main(String[] args) {
		PrintWriter pw = null;
		Scanner sc = null;

		try {
			correct_Inventory(pw, sc);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = null;
		try {
			Display_Good_Inventory(br);
		} catch (IOException e) {
			System.out.println("Could not open input file for reading." + " Please check if file exists.");
			System.out.print("Program will terminate.");
			System.exit(0);
		}

	}

	private static void Display_Good_Inventory(BufferedReader br) throws IOException {
		br =  new BufferedReader(new FileReader("Good_Inventory.txt")); 
		System.out.println("Displaying corrected information.");
		String thisLine = null;
		while ((thisLine = br.readLine()) != null) {
			System.out.println(thisLine);
		}
		br.close();
	}

	private static void correct_Inventory(PrintWriter pw, Scanner sc) throws FileNotFoundException {
		sc = new Scanner(new FileInputStream("Inventory.txt"));
		pw = new PrintWriter(new FileOutputStream("Good_Inventory.txt"));

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			line = parseTabbedTextLine(line);
			if (!line.contentEquals("No"))
				pw.println(line);
		}
		System.out.println("File Corrected Succesfully.");
		pw.close(); // Must close the files to flush the buffers
		sc.close(); // Must close the files to flush the buffers
	}

	private static String parseTabbedTextLine(String str) {
		String[] a = str.split("\t");
		String result;
		String item = a[0], id = a[2], price = a[4];
		if (id.substring(9).contentEquals("33")) {
			result = "No";
		} else if (id.substring(9).contentEquals("99")) {
			id = id.substring(0, 9) + "88";
			result = item + "\t\t" + id + "\t\t" + price;
		} else {
			result = item + "\t\t" + id + "\t\t" + price;
		}
		return result;
	}

}
