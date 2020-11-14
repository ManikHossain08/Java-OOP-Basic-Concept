package Lab_07;

import java.util.Scanner;

class IntList {

	private class Node {
		private int value;
		private Node next;
		public Node(int val, Node nxt) {
			value = val;
			next = nxt;
		}

	}

	private Node h;

	public IntList() {
		h = null;
	}
	
	
	public IntList(IntList list1, IntList list2) {
		Node t1 = list1.h, t2 = list2.h;
		if (list1.h == null) {
			list1.h = list2.h;
		} else {
			while (t1.next != null) {
				t1 = t1.next;
			}
			t1.next = t2;
		}
		
		list1 = null;
		list2 = null;
	}


	public IntList appendListsAndNullify(IntList list2) {
			return new IntList(this, list2);
	}

	public void massAddToStart() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter the number of nodes you want to enter: ");
		int size = sc.nextInt();
		for (int j = 0; j < size; j++) {
			int val = sc.nextInt();

			Node n = new Node(val, h);
			h = n;
			n = null;

			// addToStart (val);
		}
	}

	public void addToStart(int val) {
		Node n = new Node(val, h);
		h = n;
		n = null;

	}

	public Node find(int x) {
		if (h == null)
			return null;
		Node t = h;
		while (t != null) {
			if (t.value == x)
				return t;
			t = t.next;
		}
		return null;
	}

	public int size() {
		int ctr = 0;
		Node temp = h;
		while (temp != null) {
			ctr++;
			temp = temp.next;
		}
		return ctr;
	}

	public void displayContents() {
		int size = size();
		int counter = 0;
		Node temp = h;
		if (temp == null)
			System.out.println("\nThere is nothing to display; list is empty.");
		else
			System.out.println("\nStored nodes on the list are: ");
		while (temp != null) {
			if(size -1 == counter)
				 System.out.print(temp.value);
			else System.out.print(temp.value + " -> ");
			temp = temp.next;
			counter++;
		}
		//System.out.println("X");
	}

	public int compressList() {
		Node current = this.h;
		int noOfRemovedNode = 0;
		while (current != null && current.next != null) {
			if (current.next.value == current.value) {
				current.next = current.next.next;
				noOfRemovedNode++;
			} else {
				current = current.next;
			}
		}
		return noOfRemovedNode;
	}

	public boolean insertBetween(int x, int y, int z) {

		if (h == null) {
			System.out.println("\nList is empty. any value insertion  is impossible");
			return false;
		}
		Node t = h;
		while (t != null && t.value != x) {
				t = t.next;
		}

		if (t == null || (t.next != null && t.next.value != y)) {
			System.out.println("\nValue " + x + " was not found in the list. No insertion is possible");
			return false;
		}

		Node n = new Node(z, t.next);
		t.next = n;
		n = null;
		return true;
	}

}

public class UtilizeList {

	public static void main(String[] args) {

		System.out.println("\n //// -------------------- massAddToStart() --------------//");
		IntList list1 = new IntList();
		System.out.println("\nOrginal list before start massAdding (list1)");
		list1.massAddToStart();
		System.out.println("\nOrginal list after start massAdding (list1):");
		list1.displayContents();
		
		System.out.println("\n //// -------------------- compressList() --------------//");
		IntList list2 = new IntList();
		System.out.println("\nOrginal list before start massAdding (list2):");
		list2.massAddToStart();
		System.out.println("\nOrginal list before start compressed (list2):");
		list2.displayContents();
		System.out.println("\nThis compressed method removed : " + list2.compressList() + " nodes");
		System.out.println("\nNew list after compressed:");
		list2.displayContents();
		
		
		
		System.out.println("\n //// -------------------- insertBetween() --------------//");
		IntList list3 = new IntList();
		System.out.println("\nOrginal list before start massAdding (list3):");
		list3.massAddToStart();
		System.out.println("\nOrginal list after start massAdding (list3):");
		list3.displayContents();
		list3.insertBetween(19, 12, 32); // HERE IS NO INDICATION THAT THIS THREE VALUE WOULD BE USER INPUT SO I USE STATIC VALUE
		System.out.println("\nNew list after inserting value between 19 & 15:");
		list3.displayContents();
		// test with this value : 19 4 6 12 32 19 5 3 7
		
		
		System.out.println("\n //// -------------------- mass adding for appending --------------//");
		IntList list4 = new IntList();
		System.out.println("\nOrginal list before start massAdding (list4):");
		list4.massAddToStart();
		System.out.println("\nOrginal list after start massAdding (list4):");
		list4.displayContents();
		
		System.out.println("\nAppending two list togather start....:");
		System.out.println("\nOrginal list before start appending:");
		list4.displayContents();
		
		System.out.println("\n //// -------------------- add another list to append using appendListsAndNullify() --------------//");
		IntList list5 = new IntList();
		list5.massAddToStart();
		System.out.println("\nOrginal list of to be appended list after massAdding (list5):");
		list4.appendListsAndNullify(list5);
		System.out.println("\nNew list after appending list4 and list5:");
		list4.displayContents();
		
		
		System.out.println("\n //// -------------------- again compressList() --------------//");
		IntList list6 = new IntList();
		System.out.println("\nOrginal list before start massAdding (list6):");
		list6.massAddToStart();
		System.out.println("\nOrginal list before start compressed (list6):");
		list6.displayContents();
		System.out.println("\nThis compressed method removed : " + list6.compressList() + " nodes");
		System.out.println("\nNew list after compressed:");
		list6.displayContents();
		
		
		System.out.println("\n //// -------------------- AGAIN insertBetween() --------------//");
		IntList list7 = new IntList();
		System.out.println("\nOrginal list before start massAdding (list7):");
		list7.massAddToStart();
		System.out.println("\nOrginal list after start massAdding (list7):");
		list7.displayContents();
		list7.insertBetween(8, 3, 32);
		//System.out.println("\nNew list after inserting value between 19 & 15:");
		list7.displayContents();
		
		System.out.println("\n //// -------------------- AGAIN add another list to append using appendListsAndNullify() --------------//");
		IntList list8 = new IntList();
		System.out.println("\nOrginal list before start massAdding (list7):");
		list7.displayContents();
		System.out.println("\nOrginal list before start massAdding (list8):");
		list8.massAddToStart();
		System.out.println("\nOrginal list of to be appended list after massAdding (list8):");
		list8.displayContents();
		list7.appendListsAndNullify(list8); // APPEND LIST7 TO  LIST8
		System.out.println("\nNew list after appending list7 and list8:");
		list7.displayContents();
		
	}

}

/*
5
7 4 12 3 9 

16
7 4 4 4 4 19 17 9 2 2 9 5 3 3 3 9

10 
8 12 17 4 6 12 19 5 3 7

9
19 4 6 12 32 19 5 3 7

6
92 58 6 55 18 6
 */

// hualapai