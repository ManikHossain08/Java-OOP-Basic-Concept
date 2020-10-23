package Recursion;

import java.util.Scanner;

public class Recursion02 {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int i, result;

		System.out.print("Please enter an integer > 0 to display all integers from 1 to that number: ");
		i = kb.nextInt();

		// Call the recursive method to calculate the summation of the numbers
		result = sumNumbers(i);

		if (result != 0) // Calculations were made
			System.out.println("\nThe summation of all numbers from 1 to " + i + " is: " + result);
		kb.close();
	}

	public static int sumNumbers(int n) {
		if (n <= 0) {
			System.out.println("You must enter an integer larger than 0."
					+ " Method will return \"0\" as an indication of no calculations.");
			return 0;
		}

		int total = 0;
		// Simple Case (Basic Step)
		if (n == 1) {
			total += 1;
			return total;
		} else {
			// Call myself (that same method) to calculate the total for up to n-1 then add
			// n
			total = n + sumNumbers(n - 1);
			return total;
		}
	}

}
