package Lab_2;

import java.util.Scanner;

public class PrintStars {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		printStars(size);
		
		sc.close();

	}

	private static void printStars(int size) {
		for (int i = 1 ; i <= size; i = i+2) {
			for (int j = 1; j <= size - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}
}
