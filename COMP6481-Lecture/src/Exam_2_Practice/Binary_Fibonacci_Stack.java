package Exam_2_Practice;

import java.util.Scanner;

public class Binary_Fibonacci_Stack {

	public static int binaryFib(int k) {
		int fibVal;

		if (k == 0 || k == 1) {
			fibVal = k;
		} else {
			fibVal = binaryFib(k - 1) + binaryFib(k - 2);
		}

		return fibVal;
	}

	public static int[] linearFibo(int k) {

		int[] A = new int[2];
		int i = 0, j = 0;

		if (k == 1) {
			A[0] = 1;
			A[1] = 0;
			System.out.print(0 + " " + 1 + " ");

			return A;
		} else {

			A = linearFibo(k - 1);
			i = A[0];
			j = A[1];
			System.out.print((i + j) + " ");
			A[0] = i + j;
			A[1] = i;
			return A;
		}

	}

	public static void main(String[] args) {
		int n;
		Scanner kb = new Scanner(System.in);

		System.out.print("Please enter the a non-negative value to find its Fibonacci" + "sequence: ");
		n = kb.nextInt();

		int fibVal = binaryFib(n);
		System.out.println("\nThe Fibonacci value for n=" + n + " is:" + fibVal + ".");

		linearFibo(n);

		kb.close();
	}

}
