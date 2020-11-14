package LinkedList_Lab_7;

//*******************************************************************

//LinkedList6.java By: Aiman Hanna (C) 1993 - 2020
//This program is similar to linkedList1.java, with the exception that 
//the Node class is created as an independent class (i.e. not inner class 
//to the list. You should notice the consequences in doing so, especially 
//to matter such as privacy leak. You should revisit LinkedList5.java and
//consider the design of the classes as shown in this program. 
//
//Key Points:
//1) Designing Node class as an Independent class to the list. 
//*******************************************************************

import java.util.Scanner;

//Node class. Each node has an integer and a link to the next node (or null). 
class Node1 {
	private int val;
	private Node1 next; // A link to the next node, which is of type Node1

	// Default constructors
	public Node1() {
		val = 0;
		next = null;
	}

	// Parameterized constructor
	public Node1(int i, Node1 xt) {
		val = i;
		next = xt;
	}

	public void setVal(int i) {
		val = i;
	}

	public void setNext(Node1 xt) {
		next = xt;
	}

	public int getVal() {
		return val;
	}

	public Node1 getNext() {
		return next;
	}
} // End of Node1 class
//A linked list class that uses the Node1 class

class IntListCar {
	
	private Node1 head;
	// Constructor
	public IntListCar() {
		head = null;
	}

	// A method that adds an node to the start of the list
	public void addToStart(int i) {
		Node1 n = new Node1(i, head);
		head = n;
		n = null;
	}

	// A method that removes an node form the start of the list
	public boolean deleteFromStart() {
		if (head != null) {
			head = head.getNext();
			return true;
		} else
			return false;
	}

	// A method to return the size of the list
	public int size() {
		int ctr = 0;
		Node1 temp = head; // Point to the start of the list
		while (temp != null) {
			ctr++;
			temp = temp.getNext();
		}
		return ctr;
	}

	// A method that searches the list for a given value and returns the first
	// node that has this value or null if the value is not in the list
	public Node1 find(int i) {
		Node1 temp = head;
		while (temp != null) {
			if (temp.getVal() == i) {
				return temp;
			}
			temp = temp.getNext(); // Move temp to the next node
		}
		// If this point is reached then the value was not found in the list
		return null;
	}

	// A method that indicates whether or not a value is in the list
	public boolean contains(int i) {
		if (find(i) != null)
			return true;
		else
			return false;
	}

	// A method that searches the list for a node with value i1, and, if found,
	// the node is modified to have value i2. If there is more than one node
	// with value i1, the first node is the one to be modified
	public boolean replace(int i1, int i2) {
		Node1 n = find(i1);
		if (n == null) {
			System.out.println("Could not find value " + i1 + " in the list; no replacement is possible.");
			return false;
		}
		// If you reach this point, the value is in the list
		n.setVal(i2);
		return true;
	}

	public void showListContents() {
		Node1 temp = head;
		if (temp == null)
			System.out.println("There is nothing to display; list is empty.");
		else
			System.out.println("Here are the contents of the list.");
		while (temp != null) {
			System.out.print(temp.getVal() + " ---> ");
			temp = temp.getNext(); // Move to the next node
		}
		System.out.println("X");
	}

}

public class LinkedList_Car_DeepCopy {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);
		int i, i2;

		// Create an empty list
		IntListCar lst1 = new IntListCar();
		Node1 t = null;

		System.out.println("A list has been created. Its current size is: " + lst1.size());

		System.out.print("You can add a node to the list by entering a value; enter -1 to terminate: ");

		i = kb.nextInt();
		while (i != -1) {
			lst1.addToStart(i);
			i = kb.nextInt();
		}

		if (lst1.size() != 0) {
			System.out.println("\nItems were added to the list. The list current size is: " + lst1.size());
			lst1.showListContents();
		}

		System.out.print("\nPlease enter an item to search for; you will then be prompted to replace it if found: ");
		i = kb.nextInt();

		t = lst1.find(i);

		if (t != null) {
			System.out.println("\nItem " + i + " was found in the list. ");
			System.out.print("Do you wish to replace " + i + " in the list with another value; "
					+ "if so enter the new value, or -1 to continue: ");
			i2 = kb.nextInt();
			if (i2 != -1) {
				lst1.replace(i, i2);
				System.out.println("\nContent of node with value " + i + " was replaced by " + i2 + ".");
				t = null; // Avoid privacy leak; set t away from the list
				lst1.showListContents();
			} else
				System.out.println("\nNo replacement was made.");
		} else
			System.out.println("\nSorry. Item " + i + " was not found in the list. ");

		kb.close();
	}
}
