package Exam_2_Practice;

public class Strings_Of_K_Length {
	//Java program to print all 
	//possible strings of length k 

	//The method that prints all 
	//possible strings of length k. 
	//It is mainly a wrapper over 
	//recursive function printAllKLengthRec() 
	public static void printAllKLength(char[] set, int k) {
		int n = set.length;
		printAllKLengthRec(set, "", n, k);
	}

	//The main recursive method 
	//to print all possible 
	//strings of length k 
	public static void printAllKLengthRec(char[] set, String prefix, int n, int k) {

		// Base case: k is 0,
		// print prefix
		if (k == 0) {
			System.out.println(prefix);
			return;
		}

		// One by one add all characters
		// from set and recursively
		// call for k equals to k-1
		for (int i = 0; i < n; ++i) {

			// Next character of input added
			String newPrefix = prefix + set[i];

			// k is decreased, because
			// we have added a new character
			printAllKLengthRec(set, newPrefix, n, k - 1);
		}
	}

	//Driver Code 
	public static void main(String[] args) {
		System.out.println("First Test");
		char[] set1 = { 'a', 'b', 'c' };
		int k = 3;
		printAllKLength(set1, k);

		System.out.println("\nSecond Test");
		char[] set2 = { 'a', 'b', 'c', 'd' };
		k = 1;
		printAllKLength(set2, k);
	}
}


/*
 * 
Input: 
set[] = {'a', 'b'}, k = 3

Output:
aaa
aab
aba
abb
baa
bab
bba
bbb

*/
