package Exam_2_Practice;

import java.util.Scanner;

public class recursive_Mar {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[][] array = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < array[i].length; j++) {

				array[i][j] = input.nextInt();
			}
		}
		int s = 0;
		int e = n - 1;
		System.out.println("reverse array by recursion");
		reverseArray(array, s, e);
		System.out.println();

		System.out.println("power number by recursion");
		int x = input.nextInt();
		int pow = input.nextInt();
		System.out.println(power(x, pow));

		System.out.println("binary sum by recursion");
		int n1 = input.nextInt();
		int[] sum = new int[n1];

		for (int i = 0; i < n1; i++) {
			sum[i] = input.nextInt();
		}

		int i = input.nextInt();
		System.out.println(binarysum(sum, i, n1));

		System.out.println("fibonachi binary recursion");
		int k = input.nextInt();
		binaryFibo(k);
		input.close();

	}

	public static int[] binaryFibo(int k) {

		int[] A = new int[2];
		int i = 0;
		int j = 0;

		if (k == 0) {
			i = k;
			j = 0;

			A[0] = i;
			A[1] = j;
			System.out.print((i + j) + " ");
			return (A);
		}

		else if (k == 1) {
			i = k;
			j = 0;

			A[0] = i;
			A[1] = j;
			System.out.print(j + " " + i + " ");
			return (A);
		}

		else {

			A = binaryFibo(k - 1);
			i = A[0];
			j = A[1];
			System.out.print((i + j) + " ");
			A[0] = i + j;
			A[1] = i;
			return (A);
		}

	}

	public static double binarysum(int[] sum, double i, double n1) {

		if (n1 == 1) {
			return sum[(int) i];
		}

		else
			return binarysum(sum, i, Math.ceil(n1 / 2)) + binarysum(sum, i + Math.ceil(n1 / 2), Math.floor(n1 / 2));

	}

	public static int power(int x, int pow) {

		int y;
		if (pow == 0) {

			return 1;
		}

		else if (pow % 2 != 0) {

			y = power(x, (pow - 1) / 2);
			return x * y * y;

		}

		else

			y = power(x, pow / 2);
		return y * y;

	}

	public static void reverseArray(int[][] array, int s, int e) {

		if (s < e) {

			int temp[] = array[s];
			array[s] = array[e];
			array[e] = temp;
			reverseArray(array, s + 1, e - 1);

			for (int i = 0; i < array.length; i++) {
				for (int j = 0; j < array[i].length; j++) {
					System.out.print(array[i][j] + "");

					if (j != array[i].length - 1)
						System.out.print(" ");
				}
				if (i != array.length - 1)
					System.out.println();
			}

		}
	}
}