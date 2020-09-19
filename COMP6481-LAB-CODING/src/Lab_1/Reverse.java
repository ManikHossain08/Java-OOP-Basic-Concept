package Lab_1;

import java.util.Scanner;

public class Reverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[][] darray = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				darray[i][j] = sc.nextInt();
			}
		}

		darray = reverseColumn(darray, size);
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (j != size - 1)
					System.out.print(darray[i][j] + " ");
				else
					System.out.print(darray[i][j]);
			}

			if (i != size - 1) {
				System.out.print("\n");
			}
		}

		sc.close();
	}

	private static int[][] reverseColumn(int[][] darray, int size) {
		int[][] temp = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp[i][j] = darray[i][j];
			}
		}

		for (int i = 0; i < size; i++) {
			int[] row = new int[size];
			row = darray[i];
			temp[size - 1 - i] = row;
			// break;
		}
		return temp;
	}
}
