package tutorial_0011;

/*
 * Ragged Arrays: 
 Each row in a two-dimensional array need not have the same number of elements
 Different rows can have different numbers of columns
 An array that has a different number of elements per row it is called a ragged array
 */


class Array {
	Array() {
		String[] ary = new String[6];
		load(ary);
		dump(ary);
	}

	void load(String[] ary) {
		for (int n = 1; n < ary.length; n += 2) {
			ary[n - 1] = " Pos: " + n;
			ary[n] = " Neg: " + (-n - 1);
		}
	}

	void dump(String[] ary) {
		for (int n = 0; n < ary.length; n++)
			System.out.println(ary[n]);
		System.out.println();
	}

	public void change(char[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			char c = a[i];
			a[i] = a[a.length - i - 1];
			a[a.length - i - 1] = c;
		}
	}
}