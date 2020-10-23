package Recursion;

import java.util.Scanner;

public class Recursion01 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int i;

		System.out.print("Please enter an integer > 0 to display all integers from 1 to that number: ");
		i = kb.nextInt();

		// Call the recursive method to display the numbers
		displayNumbers(i);

		System.out.println("\nThanks for using our recursive method. ");
		kb.close();

	}

	public static void displayNumbers(int n) {
		if (n <= 0) {
			System.out.println("You must enter an integer larger than 0." + " Method will return.");
			return;
		}

		// Simple Case (Basic Step)
		if (n == 1) {
			System.out.print(" " + n + " ");
			return;
		} else {
			// Call myself (that same method) to display the numbers up to n-1
			displayNumbers(n - 1);
			// Then display n
			System.out.print(" " + n + " ");
		}
	}

}
