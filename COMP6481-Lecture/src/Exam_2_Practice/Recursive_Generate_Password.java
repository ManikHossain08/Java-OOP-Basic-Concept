package Exam_2_Practice;

public class Recursive_Generate_Password {
	// Java program to generate all passwords for given characters

	// int cnt;
	// Recursive helper function, adds/removes characters
	// until len is reached
	static void generate(char[] arr, int i, String s, int len) {
		// base case
		if (i == 0) // when len has been reached
		{
			// print it out
			System.out.println(s);

			// cnt++;
			return;
		}

		// iterate through the array
		for (int j = 0; j < len; j++) {

			// Create new string with next character
			// Call generate again until string has
			// reached its len
			String appended = s + arr[j];
			generate(arr, i - 1, appended, len);
		}

		return;
	}

	// function to generate all possible passwords
	static void crack(char[] arr, int len) {
		// call for all required lengths
		for (int i = 1; i <= len; i++) {
			generate(arr, i, "", len);
		}
	}

	// Driver code
	public static void main(String[] args) {
		char arr[] = { 'a', 'b', 'c' };
		int len = arr.length;
		crack(arr, len);
	}

}
