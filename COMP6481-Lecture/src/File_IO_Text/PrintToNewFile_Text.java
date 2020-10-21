package File_IO_Text;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class PrintToNewFile_Text {
	
	public static void main(String[] args) {
		PrintWriter pw = null;
		Scanner sc = null;
		
		try {
			printToNewFile(pw, sc);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}

	private static void printToNewFile(PrintWriter pw, Scanner sc) throws FileNotFoundException {
		sc = new Scanner(System.in);
		pw = new PrintWriter(new FileOutputStream("test.txt", true));
		System.out.print("We need to store your information; Please enter your First and Last Name:");
		
		pw.println("Name: " + sc.nextLine());	// Write this info to the file
	
		System.out.print("\nPlease enter your Address: ");
		pw.println("Address: " + sc.nextLine());	// Write this info to the file
	
		System.out.print("\nPlease enter your School Name: ");	
		pw.println("School Name: " + sc.nextLine());	// Write this info to the file
	
		pw.close();		// Close the file
		sc.close();
	
		System.out.println("Thank you for filling your information."); 
		System.out.println("Your information has been stored in a file called \"Info.txt\".");	

	}

}
