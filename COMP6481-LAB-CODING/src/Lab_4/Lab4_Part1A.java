package Lab_4;

import java.util.Scanner;

public class Lab4_Part1A {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(compress(str));
		sc.close();
	}

	private static String compress(String str) {
		StringBuilder orgStr = new StringBuilder(str);
		StringBuilder result = new StringBuilder(str.charAt(0) + "");
		int counter = 0;

		for (int i = 0; i < orgStr.length(); i++) {
			int index = result.length() - 1;
			if (result.charAt(index) == orgStr.charAt(i)) {
				counter++;
				if(i != orgStr.length() - 1) continue;
			}
			if (counter >= 2) {
				char ch = result.charAt(index);
				result.deleteCharAt(result.length() - 1);
				result.append(counter);
				result.append(ch);
			} 
			if(i != orgStr.length() - 1) result.append(orgStr.charAt(i));
			counter = 1;
		}

		return result.toString();
	}
}
// gggN@@@@@KKeeeejjdsmmu
// AAAAAbnktttuuWWTHKKKKKWW