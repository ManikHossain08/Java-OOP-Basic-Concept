package Lab_3;

import java.util.Scanner;

public class Display_Sum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] nums = new int[size];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}

		int[] result = findSum(nums);
		for (int i = 0; i < result.length; i++) {
			if (i != result.length - 1)
				System.out.print(result[i] + " ");
			else {
				System.out.println(result[i]);
			}
		}
		sc.close();
	}

	private static int[] findSum(int[] nums) {
		int[] result = new int[nums.length];
		result[0] = 0;

		for (int i = 1; i < result.length; i++) {
			int sum = 0;
			int val = nums[i];
			for (int j = i - 1; j >= 0; j--) {
				if (val > nums[j]) {
					sum += val - nums[j];
					result[i] = sum;
				} else
					break;
			}
		}
		return result;
	}

}

/*
 * 8 8 5 3 6 7 4 2 3
 * 
 * 7 5 9 22 3 5 8 25
 * 
 */