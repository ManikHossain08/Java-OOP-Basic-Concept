package ExceptionHandling_lec5;

// *******************************************************************
// ExceptionHandling1.java By: Aiman Hanna (C) 1993 - 2020
// This program introduces exception handling. 
// Notice that this program is a "TRIVIAL" example for illustrating
// how a try-throw-catch statements would look like and work together. 
// Do NOT take this trivial example as a typical use of exception handling.  
//
// Key Points:
// 1) try-throw-catch.
// 2) The "Exception" Class.
// 3) The "getMessage()" Method of the Exception Class.
// *******************************************************************
import java.util.Scanner;

public class ExceptionHandling1 {

	// A method that takes two double value and return the result of their division
	public static double divide_1(double x, double y) {
		// This method simply does not do/handle anything about exceptions
		double result = x / y;
		System.out.println("\nExecuting divide_1() ...");
		System.out.println("The result of dividing " + x + " by " + y + " is: " + result);
		return result;
	}

	// A method that takes two double value and return the result of their division
	public static double divide_2(double x, double y) {
		// This method actually handles special cases without exception handling
		// techniques.
		double result;
		System.out.println("\nExecuting divide_2() ...");

		if (y != 0) {
			result = x / y;
			System.out.println("The result of dividing " + x + " by " + y + " is: " + result);
			return result;
		} else {
			System.out.println("Cannot perform division by 0. Will return \"-0\" as an indication of error. ");
			return -0;
		}
	}

	// A method that takes two double value and return the result of their division
	public static double divide_3(double x, double y) {
		// This method use exception handling techniques to catch and handle
		// potential errors/exceptions
		double result;
		System.out.println("\nExecuting divide_3() ...");
		try {
			if (y == 0)
				throw new Exception("Cannot Divide by 0. Will return \"-0\" as an indication of error.");
			else {
				result = x / y;
				System.out.println("The result of dividing " + x + " by " + y + " is: " + result);
				return result;
			}
		} catch (Exception e) {
			String s = e.getMessage();
			System.out.println(s);
			return -0;
		}

	}

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		double d1, d2;

		System.out.print("Please enter two values to perform a division: ");
		d1 = kb.nextDouble();
		d2 = kb.nextDouble();

		// Call divide_1() to perform the division
		divide_1(d1, d2);

		// Call divide_2() to perform the division
		divide_2(d1, d2);

		// Call divide_3() to perform the division
		divide_3(d1, d2);
		kb.close();

	}

}
