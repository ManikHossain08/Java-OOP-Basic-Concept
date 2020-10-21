// *******************************************************************
// FileIO12.java By: Aiman Hanna (C) 1993 - 2020
// This program introduction "binary" files. Binary files
// store data in a format that is understood by the computer
// memory, rather by a human being. Text files, which can be 
// read by a human being need to be transformed first into binary
// format for computers to understand them. So, in cases where there
// is no need to access/read a file using a text editor, it is much 
// more efficient to directly write your data into binary files instead. 
// Beside saving the transformation time, binary files are also portable; 
// that is, they can be moved from any computer to another and still be 
// successfully read by Java (but only by Java) on that machine.
// 
// Key Points:
// 1) Binary Files.
// 2) Writing to Binary Files Using the ObjectOutputStream Class. 
// *******************************************************************

package File_IO_Binary;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class File_IO_Binary01_Write {
	
	public static void main(String[] args) 
	{
		
		// This program will store student registration information of some course.
		// The registration information will be entered by the user and stored in 
		// binary file. 
		
		long id;
		String fileName, courseName, firstName, lastName;
		
		
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Please enter the course name for which you wish to add student registration: ");
		courseName = kb.next();
		
		// Construct file name based on the course name
		fileName = courseName + "_registeration.dat";
		System.out.println("The registration information will be stored in a \"binary\" file called: " + 
								fileName);

		ObjectOutputStream oos = null;
		try
		{
			// Create an ObjectOutputStream to write into the binary file 
			oos = new ObjectOutputStream(new FileOutputStream(fileName));
			
			// If this point is reached, then the stream was created successfully. 
			// Place a string at the beginning of the file indicating the course number, then
			// ask the user to enter the registration information 
			
			oos.writeUTF("This file includes the registration of " + courseName + ".");
			
			System.out.print("Please enter the student ID you wish to register in " +
									"the course or -1 to terminate: ");
			id = kb.nextLong();
			while(id != -1)
			{
				
				//jk = kb.nextLine();		// Clear the rest of the line
				System.out.print("Please enter first name and last name of the student: ");
				firstName = kb.next();
				lastName = kb.next();
				
				oos.writeLong(id);
				oos.writeChar('\t');	// Add two tabs
				oos.writeChar('\t');
				oos.writeUTF(firstName);
				oos.writeChar(' ');		// Add one space to separate the names
				oos.writeUTF(lastName);
				
				System.out.println("One student info was added to the file.");
				System.out.print("\nPlease enter the following student ID you wish " +
									"to register in the course, or -1 to terminate: ");
				id = kb.nextLong();
			}
			
			System.out.println("Registration completed.");
			oos.close();		// Close the file
			kb.close();
		}
		catch(IOException e)
		{
			System.out.println("Problem writing to output file " + fileName);
			System.out.println("Program will terminate.");
			System.exit(0);		
		}
	}

}
