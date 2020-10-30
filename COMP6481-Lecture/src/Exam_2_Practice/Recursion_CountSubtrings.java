package Exam_2_Practice;

public class Recursion_CountSubtrings {
	// Java program to count substrings
	// with same first and last characters

	// Function to count subtrings
	// with same first and
	// last characters
	static int countSubstrs(String str, int i, int j, int n) {
		// base cases
		if (n == 1)
			return 1;
		if (n <= 0)
			return 0;

		int res = countSubstrs(str, i + 1, j, n - 1) + countSubstrs(str, i, j - 1, n - 1)
				- countSubstrs(str, i + 1, j - 1, n - 2);

		if (str.charAt(i) == str.charAt(j))
			res++;

		return res;
	}

	// Driver code
	public static void main(String[] args) {
		String str = "abc";
		int n = str.length();
		System.out.print(countSubstrs(str, 0, n - 1, n));
	}
}

/*

Input  : S = "abcab"
Output : 7
There are 15 substrings of "abcab"
a, ab, abc, abca, abcab, b, bc, bca
bcab, c, ca, cab, a, ab, b
Out of the above substrings, there 
are 7 substrings : a, abca, b, bcab, 
c, a and b.

*/
