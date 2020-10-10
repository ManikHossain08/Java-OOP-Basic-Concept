package LabExam_1;

import java.util.Arrays;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] nums = new int[size];
		for (int i = 0; i < size; i++) {
			nums[i] = sc.nextInt();
		}

		System.out.print(leftRightSum(nums));
		sc.close();
	}

	private static String leftRightSum(int[] nums) {
		String message = "";
		for (int i = 1; i < nums.length; i++) {
			int[] lefts = Arrays.copyOfRange(nums, 0, i);
			int[] rights = Arrays.copyOfRange(nums, i + 1, nums.length);
			int leftsum = Arrays.stream(lefts).sum();
			int rightSum = Arrays.stream(rights).sum();
			if (leftsum == rightSum) {
				message = "Solution Exists at index " + i;
				break;
			} else
				message = "No Solution Exists; returning -1";

		}
		return message;
	}

}


// time complexity is O(n-1)
// space complexity = O(n)


