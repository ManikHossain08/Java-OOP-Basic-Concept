package LabExam_1;

import java.util.Scanner;

class InvalidValueException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidValueException() {
		super("Error. Invalid value exception.");
	}

	public InvalidValueException(String s) {
		super(s);
	}

	public String getMessage() {
		return super.getMessage();
	}
}

public class Question3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}
		int shift = sc.nextInt();

		try {
			rightRotate(nums, shift);
		} catch (InvalidValueException e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}

	}

	public static void rightRotate(int[] A, int shift) throws InvalidValueException {
		if (A.length < shift)
			throw new InvalidValueException();
		else {
			int[] temp = new int[A.length];
			temp[shift] = A[0];
			int rightCnt = 1;
			for (int i = shift + 1; i < temp.length; i++) {
				temp[i] = A[i - shift];
				rightCnt++;
			}
			for (int i = 0; i < shift; i++) {
				temp[i] = A[i + rightCnt];
			}

			for (int i = 0; i < temp.length; i++) {
				if (i != temp.length - 1)
					System.out.print(temp[i] + " ");
				else
					System.out.println(temp[i]);
			}
		}

	}
}
/*
8
12 22 90 2 55 7 17 9
5


 */

