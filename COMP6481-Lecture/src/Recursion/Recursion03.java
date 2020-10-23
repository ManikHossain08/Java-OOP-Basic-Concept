package Recursion;

import java.util.Scanner;

public class Recursion03 {
	public static int power(int x, int n) // Would return x^n
	{

		// Here is how x^n is calculated:
		// if n is 0, then the value is x^0, which is 1 (This is the stopping condition)
		// if n > 0, then power(x, n) is the same as x * x^(n-1), that is
		// x * power(x, n-1), which is the recursive step

		if (n < 0) {
			System.out.println("Illegal argument, of -ve value, to power."
					+ " Calculations cannot be made and program will terminate.");
			System.exit(0);
			// return 0;
		}

		// Basic Step (Stopping Condition)
		if (n == 0) {
			return 1; // Anything to the power of 0 is 1
		} else // Recursive Step
		{
			return (x * power(x, n - 1));
		}
	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int i, j, result;

		System.out.print("Please enter the two integers you wish to calculate their power value: ");
		i = kb.nextInt();
		j = kb.nextInt();

		// Call the recursive method to calculate the summation of the numbers
		result = power(i, j);

		System.out.println("\nThe power of " + i + "^" + j + " is: " + result);
		kb.close();
	}

}
