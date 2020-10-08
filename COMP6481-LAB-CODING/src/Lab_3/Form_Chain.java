package Lab_3;


import java.util.Scanner;

public class Form_Chain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		sc.nextLine();
		String[] words = new String[size];
		for (int i = 0; i < size; i++) {
			words[i] = sc.nextLine();
		}
		
		System.out.println(formChain(words));
		sc.close();

	}

	private static String formChain(String[] words) {
		if (words.length == 0)
			return "NO";

		for (int i = 0; i < words.length - 1; i++) {
			char first = words[i].charAt(words[i].length() - 1);
			char second = words[i + 1].charAt(0);
			if (first != second)
				return "NO";
		}

		return "YES";
	}

}
/*
 * 6 
 * hello orange exam moon non ny
 * 
 * 4 hi inside eclipse source
 * 
 */
