package Exam_2_Practice;

import java.util.Scanner;

public class Recursive_Factorial {

	public static int fact(int n) {
		if (n == 0)
			return 1;
		return n * fact(n - 1);
	}

	public static int tailFactorial(int n) {

		return tfact(n, 1); // no recursion here
	}

	public static int tfact(int n, int res) {
		if (n == 0)
			return res;
		return tfact(n - 1, res * n); // this is where recursion occurs
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n;
		System.out.print("Please enter the value that you wish to calculate its" + "factorial: ");
		n = kb.nextInt();

		System.out.print("The value of " + n + "! using fact(" + n + ") is: " + fact(n));
		System.out.print("\n\n");
		System.out.print("The value of " + n + "! using tailFactorial(" + n + ") is: " + tailFactorial(n));
		kb.close();
	}
}
