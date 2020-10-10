package LabExam_1;

import java.util.Scanner;

public class Questions2 {

	public static int dx[] = { -1, -1, -1, 1, 1, 1 };
	public static int dy[] = { -1, 0, 1, 1, 0, -1 };
	public static int size = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		//int size = sc.nextInt();
		size = 6;
		int[][] array = new int[size][size];
	
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = sc.nextInt();
			}
		}

		System.out.print(findLargestGlassHour(array));

		sc.close();
	}

	private static String findLargestGlassHour(int[][] array) {
		int maxSum = Integer.MIN_VALUE;
		String message = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				int glasssum = countSumFromGlassNeighbours(array, i, j);
				if (maxSum < glasssum) {
					maxSum = Math.max(maxSum, glasssum);
					message = "The largest hourglass is " + glasssum + " starting at [" + (i-1) + "][" + (j-1) + "]";
				}

			}
		}

		return message;
	}

	private static int countSumFromGlassNeighbours(int[][] array, int x, int y) {
		int sum = array[x][y];
		for (int i = 0; i < dx.length; ++i) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if (xx >= 0 && yy >= 0 && xx < size && yy < size) {
				sum += array[xx][yy];
			}

		}
		return sum;
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
