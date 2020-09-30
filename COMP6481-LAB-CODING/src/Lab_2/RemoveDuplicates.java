package Lab_2;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicates {
	public static int count = 0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		
		String[] values = new String[size];
		values = sc.nextLine().split(" ");
		
		String[] result = ShrinkArray(values);

		System.out.println(count);
		for (int i = 0; i < count; i++) {
			if (i != count - 1)
				System.out.print(result[i] + " ");
			else
				System.out.print(result[i]);
		}
		sc.close();

	}

	private static String[] ShrinkArray(String[] values) {

		String[] strArr = new String[values.length];
		Arrays.fill(strArr, "");

		for (int i = 0; i < values.length; i++) {
			if (!isAlreadyThere(strArr, values[i])) {
				strArr[count] = values[i];
				count++;
			}
		}
		return strArr;
	}

	private static boolean isAlreadyThere(String[] result, String val) {

		for (int i = 0; i < result.length; i++) {
			if (result[i].contentEquals(val))
				return true;
		}
		return false;
	}
}
