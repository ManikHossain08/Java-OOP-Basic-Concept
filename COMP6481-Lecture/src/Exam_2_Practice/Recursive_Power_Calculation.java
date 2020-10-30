package Exam_2_Practice;

public class Recursive_Power_Calculation {

	public static int power(int x, int n) {
		if (n == 0)
			return 1;
		else if (n % 2 == 0) {
			int y = power(x, n / 2);
			return y * y;
		} else {
			int y = power(x, (n - 1) / 2);
			return x * y * y;
		}
	}

	public static void main(String[] args) {
		System.out.println(power(2, 5));
	}
}