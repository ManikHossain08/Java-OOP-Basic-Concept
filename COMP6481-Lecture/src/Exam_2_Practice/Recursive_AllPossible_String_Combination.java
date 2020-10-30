package Exam_2_Practice;

import java.util.ArrayList;
import java.util.List;

public class Recursive_AllPossible_String_Combination {
	private static StringBuilder output = new StringBuilder();

	public static void main(String[] args) {
		String s = "abc";
		List<String> result = new ArrayList<>();
		result.add("");
		System.out.println(method(s, result));
		// System.out.println(method(s, result).size());
		combine("abc", 0);
	}

	private static List<String> method(String input, List<String> done) {
		List<String> result = new ArrayList<>();
		if (input.length() == 1) {
			for (String string : done) {
				result.add(string);
				result.add(string + input);
			}
			return result;
		} else {
			for (String string : done) {
				result.add(string);
				result.add(string + input.substring(0, 1));
			}
			return method(input.substring(1), result);
		}
	}

	private static void combine(String inputstring, int start) {
		for (int i = start; i < inputstring.length(); ++i) {
			output.append(inputstring.charAt(i));
			System.out.println(output);
			if (i < inputstring.length())
				combine(inputstring, i + 1);
			output.setLength(output.length() - 1);
		}
	}
}
