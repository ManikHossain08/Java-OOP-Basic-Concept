package LinkedList_Lab_7;

//Java code to implement binary search 
//on Singly Linked List 

//Node Class 
class NodeBi 
{ 
	int data; 
	NodeBi next; 

	// Constructor to create a new node 
	NodeBi(int d) 
	{ 
		data = d; 
		next = null; 
	} 
} 

public class LinkedList_BinarySearch 
{ 
	// function to insert a node at the beginning 
	// of the Singaly Linked List 
	static NodeBi push(NodeBi head, int data) 
	{ 
		NodeBi newNode = new NodeBi(data); 
		newNode.next = head; 
		head = newNode; 
		return head; 
	} 

	// Function to find middle element 
	// using Fast and Slow pointers 
	static NodeBi middleNode(NodeBi start, NodeBi last) 
	{ 
		if (start == null) 
			return null; 

		NodeBi slow = start; 
		NodeBi fast = start.next; 

		while (fast != last) 
		{ 
			fast = fast.next; 
			if (fast != last) 
			{ 
				slow = slow.next; 
				fast = fast.next; 
			} 
		} 
		return slow; 
	} 

	// function to insert a node at the beginning 
	// of the Singly Linked List 
	static NodeBi binarySearch(NodeBi head, int value) 
	{ 
		NodeBi start = head; 
		NodeBi last = null; 

		do
		{ 
			// Find Middle 
			NodeBi mid = middleNode(start, last); 

			// If middle is empty 
			if (mid == null) 
				return null; 

			// If value is present at middle 
			if (mid.data == value) 
				return mid; 

			// If value is less than mid 
			else if (mid.data > value) 
			{ 
				start = mid.next; 
			} 

			// If the value is more than mid. 
			else
				last = mid; 
		} while (last == null || last != start); 

		// value not present 
		return null; 
	} 

	// Driver Code 
	public static void main(String[] args) 
	{ 
		NodeBi head = null; 

		// Using push() function to 
		// convert singly linked list 
		// 10 -> 9 -> 8 -> 7 -> 4 -> 1 
		head = push(head, 1); 
		head = push(head, 4); 
		head = push(head, 7); 
		head = push(head, 8); 
		head = push(head, 9); 
		head = push(head, 10); 
		int value = 7; 

		if (binarySearch(head, value) == null) 
		{ 
			System.out.println("Value not present"); 
		} 
		else
		{ 
			System.out.println("Present"); 
		} 
	} 
} 



