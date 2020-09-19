package ASSIGNMENT;

import java.util.Scanner;

public class QUESTIONS_1 {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// int size = sc.nextInt();
		int[] arr = { 20, 52, 400, 3, 30, 70, 72, 47, 28, 38, 41, 53, 20 };
		//int[] arr = {0, 1, 2, 3, 4, 5, 6, 7};
		reversseArrElements(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] +" ");
		}
	}

	private static int[] reversseArrElements(int[] arr) {
		int leftUpto = -1;
		int rightStart = -1;
		int arrLength = arr.length;

		if (arrLength % 2 == 1) {
			leftUpto = (arrLength / 2);
			rightStart = leftUpto + 1;

		} else {
			leftUpto = arrLength / 2;
			if (leftUpto % 2 == 1) {
				leftUpto = leftUpto + 1;
			}
			rightStart = leftUpto;
		}
		// left
		for (int i = 0; i < leftUpto; i = i + 2) {
				int temp = arr[i + 1];
				arr[i + 1] = arr[i];
				arr[i] = temp;
		}
		// right
		for (int i = rightStart; i < arrLength - 1; i = i + 2) {
				arr[i + 1] = arr[i] + arr[i + 1];
		}
		
		return arr;
	}
}

// 1 0 3 2 4 5 11 7 15 