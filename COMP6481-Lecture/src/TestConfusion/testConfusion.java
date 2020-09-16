package TestConfusion;
// this code belongs to the lecture 1 for finding the complexity of algorithm

class test{
	private int root;
// https://www.thoughtco.com/accessors-and-mutators-2034335
	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}
}

public class testConfusion {
	public static void main(String[] args) {
		int n = 10;
		int[] a = { 1, 2, 5, 2, 7, 9, 10, 5, 8, 1 };
		for (int i = 0; 
				i < n - 1; 
				i++) {
			if (a[i] > a[i + 1])
				System.out.print("found");
		}
	}
}

