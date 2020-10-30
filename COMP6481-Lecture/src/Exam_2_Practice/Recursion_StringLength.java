package Exam_2_Practice;

public class Recursion_StringLength {
	// java program to calculate length of 
	// a string using recursion 

		/* Function to calculate length */
		private static int recLen(String str) 
		{ 

			// if we reach at the end of the string 
			if (str.equals("")) 
				return 0; 
			else
				return recLen(str.substring(1)) + 1; 
		} 

		/* Driver program to test above function */
		public static void main(String[] args) 
		{ 

			
			String str ="GeeksforGeeks"; 
			System.out.println(recLen(str)); 
		} 
	} 



