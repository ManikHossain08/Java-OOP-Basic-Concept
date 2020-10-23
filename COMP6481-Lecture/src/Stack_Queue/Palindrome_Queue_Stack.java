package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Palindrome_Queue_Stack {
	public static void main(String[] args) {

		System.out.print("Enter any string:");
		Scanner in = new Scanner(System.in);
		String inputString = in.nextLine();

		usingStack(inputString);
		usingQueue(inputString);
		
		in.close();
	}

	private static boolean usingStack(String inputString) {
		
		Stack<String> stack = new Stack<String>();

		for (int i = 0; i < inputString.length(); i++) {
			stack.push(inputString.charAt(i) + "");
		}

		String reverseString = "";
		while (!stack.isEmpty()) {
			reverseString = reverseString + stack.pop();
		}
		
		if (inputString.equals(reverseString))
			System.out.println("The input String is a palindrome from Stack.");
		else
			System.out.println("The input String is not a palindrome Stack.");
		return true;
	}

	private static boolean usingQueue(String inputString) {
		
		Queue<String> queue = new LinkedList<String>();

		for (int i = inputString.length() - 1; i >= 0; i--) {
			queue.add(inputString.charAt(i) + "");
		}

		String reverseString = "";
		while (!queue.isEmpty()) {
			reverseString = reverseString + queue.remove();
		}
		if (inputString.equals(reverseString))
			System.out.println("The input String is a palindrome Queue.");
		else
			System.out.println("The input String is not a palindrome Queue.");
		return true;
	}

}
