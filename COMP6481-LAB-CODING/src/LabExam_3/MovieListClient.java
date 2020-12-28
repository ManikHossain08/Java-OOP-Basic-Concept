package LabExam_3;

class MovieListX  {

	private class MovieNode {
		private String movieName;
		private MovieNode next;

		public MovieNode(String i, MovieNode xt) {
			movieName = i;
			next = xt;
		}

	}

	private MovieNode head;
	private MovieNode tail;
	private static int size = 0;

	public MovieListX() {
		head = null;
		tail = null;
	}

	public void addToStart(String val) {
		MovieNode n = new MovieNode(val, head);

		if (head == null) {
			head = n;
			head.next = head;
			tail = head;
		} else {
			tail.next = n;
			head = tail.next;
			n = null;
		}
		size++;
	}

	public void addAtEnd(String item) {

		MovieNode n = new MovieNode(item, head);
		if (head == null) {
			addToStart(item);
		} else {
			tail.next = n;
			tail.next.next = head;
			tail = tail.next;
			n = null;
		}
		size++;
	}

	// contains
	public MovieNode find(String x) {
		if (head == null)
			return null;
		MovieNode t = head;
		while (t.next != head) {
			if (t.movieName == x)
				return t;
			t = t.next;
		}
		if (t.movieName == x)
			return t;
		else
			return null;

	}

	public int size() {
		return size;
	}

	public boolean contains(String i) {
		if (find(i) != null)
			return true;
		else
			return false;
	}

	public String displayContents() {
		String contents = "";
		int size = size();
		int counter = 0;
		MovieNode temp = head;

		if (temp == null)
			System.out.println("\nThere is nothing to display; list is empty.");
		else
			System.out.println("\nHere are the contents of the list.");

		while (temp.next != head) {
			if (size - 1 != counter)
				contents = contents + temp.movieName + ", ";
			temp = temp.next;
			counter++;
		}
		contents = contents + temp.movieName;

		return contents;

	}

}

public class MovieListClient {

	public static void main(String[] args) {

		MovieListX lst1 = new MovieListX();

		lst1.addToStart("Gone with the Wind");
		lst1.addAtEnd("The Wolf House");
		lst1.addAtEnd("The Painted Bird");
		lst1.addAtEnd("Skyscraper");
		System.out.println("\nShowing contents of lst1");
		System.out.println(lst1.displayContents());

	}

}
