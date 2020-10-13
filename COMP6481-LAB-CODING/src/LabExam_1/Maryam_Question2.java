package LabExam_1;

import java.util.Scanner;

public class Maryam_Question2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int[][] array = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < array[i].length; j++) {

				array[i][j] = input.nextInt();
			}
		}

		hourseglass(array, n);
		input.close();

	}

	public static void hourseglass(int[][] array, int n) {

		int max1 = 0;
		for (int i = 0; i < n - 2; i++) {

			for (int j = 0; j < n - 2; j++) {

				int sum = (array[i][j] + array[i][j + 1] + array[i][j + 2]) 
						+ (array[i + 1][j + 1])
						+ (array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2]);

				max1 = Math.max(max1, sum);
			}

		}

		System.out.println(max1);

	}
}

/*
8 6 3 2 8 9 
1 3 80 20 40 4
4 2 6 50 2 3 
2 5 30 60 70 2 
2 5 8 3 5 7 
4 7 1 2 3 8
 */