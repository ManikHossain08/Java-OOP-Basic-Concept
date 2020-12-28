package Exam_3_Practice;


class IntList {

	private class Node {
		private int v;
		private Node next;
		
		public Node(int i, Node xt) {
			v = i;
			next = xt;
		}

	}

	private Node head;
	private Node tail;

	public IntList() {
		head = null;
		tail = null;
	}

	public void addToStart(int i) {
		Node n = new Node(i, head);

		if (head == null) {
			head = n;
			head.next = head;
			tail = head;
		} else {
			tail.next = n;
			head = tail.next;
			n = null;
		}
	}


	public void addToEnd(int item) {
		
		Node n = new Node(item, head);
		if (head == null) {
			addToStart(item);
		} else {
			tail.next = n;
			tail.next.next = head;
			tail = tail.next;
			n = null;
		}
	}

	public Node find(int x) {
		if (head == null)
			return null;
		Node t = head;
		while (t.next != head) {
			if (t.v == x)
				return t; 
			t = t.next;
		}
		if(t.v == x) return t;
		else return null;
	
	}
	
	/*This function returns true if given linked 
	list is circular, else false. */
	static boolean isCircular( Node head) 
	{ 
	    // An empty linked list is circular 
	    if (head == null) 
	    return true; 
	  
	    // Next of head 
	    Node node = head.next; 
	  
	    // This loop would stop in both cases (1) If 
	    // Circular (2) Not circular 
	    while (node != null && node != head) 
	    node = node.next; 
	  
	    // If loop stopped because of circular 
	    // condition 
	    return (node == head); 
	} 

	public boolean insertAfter(int i, int x) {

		if (head == null) {
			System.out
					.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
			return false;
		}
		Node t = head;
		while (t != null && t.v != i)
			t = t.next;

		if (t == null) {
			System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
			return false;
		}

		Node n = new Node(x, t.next);
		t.next = n;
		n = null;
		return true;
	}

	public boolean insertBefore(int i, int x) {

		if (head == null) {
			System.out
					.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
			return false;
		}

		if (head.v == i) {
			head = new Node(x, head);
			return true;
		}

		Node t = head;
		while (t.next != null && t.next.v != i)
			t = t.next;
		if (t.next == null) {
			System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
			return false;
		}

		Node n = new Node(x, t.next);
		t.next = n;
		n = null;
		return true;
	}

	public int size() {
		int ctr = 1;
		Node temp = head;
		while (temp.next != head) {
			ctr++;
			temp = temp.next;
		}
		return ctr;
	}

	public boolean contains(int i) {
		if (find(i) != null)
			return true;
		else
			return false;
	}

	public boolean replace(int i1, int i2) {
		Node t = find(i1);
		if (t == null) {
			System.out.println("\nCould not find value " + i1 + " in the list; no replacement is possible.");
			return false;
		}
		t.v = i2;
		return true;
	}
	
	public boolean insertBetween(int x, int y, int z) {

		if (head == null) {
			System.out.println("\nList is empty. any value insertion  is impossible");
			return false;
		}
		Node t = head;
		while (t != head && t.v != x) {
				t = t.next;
		}

		if (t == null || (t.next != null && t.next.v != y)) {
			System.out.println("\nValue " + x + " was not found in the list. No insertion is possible");
			return false;
		}

		Node n = new Node(z, t.next);
		t.next = n;
		n = null;
		return true;
	}

	public void showListContents() {
		Node temp = head;

		if (temp == null)
			System.out.println("\nThere is nothing to display; list is empty.");
		else
			System.out.println("\nHere are the contents of the list.");


		while (temp.next != head) {
			System.out.print(temp.v + " --> ");
			temp = temp.next;
		}
		System.out.print(temp.v + " --> " + head.v);

	}

}

public class Circular_LinkedList_Professor {

	public static void main(String[] args) {

		IntList lst1 = new IntList();
		
		lst1.addToStart(18);
		lst1.addToStart(22);
		lst1.addToStart(4);
		lst1.addToStart(7);
		lst1.addToStart(48);
		lst1.addToStart(18);
		lst1.addToStart(12);
		lst1.addToStart(32);
		System.out.println("\nShowing contents of lst1");
		lst1.showListContents();
		lst1.addToEnd(333);
		lst1.addToEnd(635);

		System.out.println("\nShowing contents of lst1");
		lst1.showListContents();
		System.out.println("\nSize : "+ lst1.size());
		
		lst1.insertAfter(48, 40);
		lst1.showListContents();
		lst1.insertBefore(48, 50);
		lst1.showListContents();
		lst1.insertBetween(500, 48, 60);
		lst1.showListContents();
		System.out.println("\nFound : "+ lst1.find(32)); 

	}

}
