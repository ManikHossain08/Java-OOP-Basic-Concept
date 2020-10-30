package Exam_2_Practice;

import java.util.Arrays;

public class Recursive_PowerSet_Lexicographic_Order {
	private static EntryStr pQue = new EntryStr(100);

	static void permuteRec(String str, int n, int index, String curr) {
		// base case
		if (index == n) {
			return;
		}
		System.out.println(curr);
		pQue.insert(curr);
		for (int i = index + 1; i < n; i++) {

			curr += str.charAt(i);
			permuteRec(str, n, i, curr);

			curr = curr.substring(0, curr.length() - 1);
		}
		return;
	}

	static void powerSet(String str) {

		char[] arr = str.toCharArray();
		Arrays.sort(arr); // ordering first before permutation action
		permuteRec(new String(arr), str.length(), -1, "");
	}

	public static void main(String[] args) {
		String str = "cab";
		powerSet(str);

		// order after permutation using my developed priority queue
		while (!pQue.isEmpty()) {
			System.out.println(pQue.removeFirst());
		}

	}
}
