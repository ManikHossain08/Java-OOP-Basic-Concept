package Exam_2_Practice;

public class Binary_Summing_Array_element {
	
	public static int binarySum(int[] a, int low, int high) {
		
		if (low > high)
			return 0;
		else if (low == high)
			return a[low];
		else {
			int mid = (low + high) / 2;
			return binarySum(a, low, mid) + binarySum(a, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };

		int sum = binarySum(a, 0, a.length - 1);
		System.out.println("\n The sum using binay approach is: " + sum + ".");

	}

}
