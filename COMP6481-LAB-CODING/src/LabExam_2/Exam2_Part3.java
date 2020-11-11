package LabExam_2;

import java.util.Arrays;
import java.util.Scanner;

public class Exam2_Part3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		int index = sc.nextInt();
		try {
			balancePoint(arr, index);
		} catch (InvalidIndexException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		sc.close();
	}

	private static void balancePoint(int[] arr, int index) throws InvalidIndexException {

		if(index == arr.length - 1 || index == 0)
			throw new InvalidIndexException();
		
		int[] lefts = Arrays.copyOfRange(arr, 0, index);
		int[] rights = Arrays.copyOfRange(arr, index + 1, arr.length);

		int leftsum = binarySum(lefts, 0, lefts.length - 1);
		int rightsum = binarySum(rights, 0, rights.length - 1);
		if(leftsum == rightsum) 
			System.out.println("Array is balanced at this point " + index + ". Right side total is: "+ leftsum + " and left is: "+ rightsum +".");
		else 
			System.out.println("Array is NOT balanced at this point " + index +". Right side total is: "+leftsum + " and left is: "+ rightsum );
			

	}

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

}

class InvalidIndexException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidIndexException() {
		super("Error! Invalid Index exception.");
	}

	public InvalidIndexException(String s) {
		super(s);
	}

	public String getMessage() {
		return super.getMessage();
	}
}


/*
12
2 4 6 8 10 20 2 3 2 3 2 18
5

6
2 4 7 890 989 2
5

6
2 4 7 890 989 2
2
*/