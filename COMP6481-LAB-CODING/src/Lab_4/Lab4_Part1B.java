package Lab_4;

import java.util.Scanner;

public class Lab4_Part1B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] nums = new int[size];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}

		int target = sc.nextInt();

		System.out.println(findNearestElement(nums, target));
		sc.close();
	}

	private static String findNearestElement(int[] nums, int target) {
		int index = 0;
		String result = "";
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				index = i;
				break;
			}
		}

		int sum = 0, x = 0, y = 0;
		int max = Integer.MIN_VALUE;

		for (int i = index - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				sum = nums[i] + nums[j];
				if (sum > target)
					continue;

				if (sum == target) {
					x = Math.min(i, j);
					y = Math.max(i, j);

					return result = "Exact, or Nearest, elsements that add to target value " + target
							+ " are found at index " + x + " and index " + y + " ading to " + sum;
				}

				if (max < sum) {
					x = Math.min(i, j);
					y = Math.max(i, j);
					max = sum;
					result = "Exact, or Nearest, elsements that add to target value " + target + " are found at index "
							+ x + " and index " + y + " ading to " + sum;
				}

			}
		}

		return result;
	}
}

/*
 * 12 2 10 26 50 55 67 75 93 105 120 127 145 127
 */
// WAMPANOAG.ENCS.CONCORDIA
