package File_IO_Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromExistingFile_Text {
	
	public static void main(String[] args) {
		Scanner sc = null;
		
		try {
			readFromExistingFile(sc);
		} catch (FileNotFoundException e) {
			System.out.println("Could not open input file for reading."
					+ " Please check if file exists.");	
			System.out.print("Program will terminate.");
			System.exit(0);
		}
		
	}
	
	private static void readFromExistingFile(Scanner sc) throws FileNotFoundException {
		sc = new Scanner(new FileInputStream("StudentInfo.txt"));
		
		int i = 0;
		String s = sc.nextLine();	// read the entire first line from the file then display it	
		System.out.println(s);	

		while(sc.hasNextLine() && i < 7)
		{
			Long id = sc.nextLong();
			//String abc = sc.nextLine();		// just read the rest of the line so we can go to the next line
			sc.nextLine();
			System.out.println(id);
			i++;
		}
				
		if (i < 7)
			System.out.println("\nPlease note that the course has only " + i + " registrations.");
		
		sc.close();

	}

}
