package PracticeLab_5;

import java.util.Scanner;
import java.util.Stack;

public class Super_Reduced_String {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		String str = s.next(); // aaabccddd

		Stack<Character> st = new Stack<Character>();
		s.close();

		for (int i = 0; i < str.length(); i++)

		{
			if (st.isEmpty())

			{
				st.push(str.charAt(i));
			}

			else if (!st.isEmpty() && st.peek() == str.charAt(i))

			{
				st.pop();
			} else {
				st.push(str.charAt(i));
			}
		}

		StringBuilder sb = new StringBuilder();

		if (st.isEmpty())

		{
			System.out.println("Empty String");

		} else {
			while (!st.isEmpty())

			{
				sb.append(st.pop());
			}
			System.out.println(sb.reverse());

		}
	}
}
