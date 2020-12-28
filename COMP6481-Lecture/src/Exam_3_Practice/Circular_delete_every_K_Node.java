package Exam_3_Practice;

//Java program to delete every kth Node from 
//circular linked list. 
public class Circular_delete_every_K_Node 
{ 
	
/* structure for a Node */
static class Node 
{ 
	int data; 
	Node next; 
	Node(int x) 
	{ 
		data = x; 
		next = null; 
	} 
}; 

/*Utility function to print 
the circular linked list*/
static void printList(Node head) 
{ 
	if (head == null) 
		return; 
	Node temp = head; 
	do
	{ 
		System.out.print( temp.data + "->"); 
		temp = temp.next; 
	} 
	while (temp != head); 
	System.out.println(head.data ); 
} 

/*Function to delete every kth Node*/
static Node deleteK(Node head_ref, int k) 
{ 
	Node head = head_ref; 

	// If list is empty, simply return. 
	if (head == null) 
		return null; 

	// take two pointers - current and previous 
	Node curr = head, prev=null; 
	while (true) 
	{ 

		// Check if Node is the only Node\ 
		// If yes, we reached the goal, therefore 
		// return. 
		if (curr.next == head && curr == head) 
			break; 

		// Print intermediate list. 
		printList(head); 

		// If more than one Node present in the list, 
		// Make previous pointer point to current 
		// Iterate current pointer k times, 
		// i.e. current Node is to be deleted. 
		for (int i = 0; i < k; i++) 
		{ 
			prev = curr; 
			curr = curr.next; 
		} 

		// If Node to be deleted is head 
		if (curr == head) 
		{ 
			prev = head; 
			while (prev.next != head) 
				prev = prev.next; 
			head = curr.next; 
			prev.next = head; 
			head_ref = head; 
		} 

		// If Node to be deleted is last Node. 
		else if (curr.next == head) 
		{ 
			prev.next = head; 
		} 
		else
		{ 
			prev.next = curr.next; 
		} 
	} 
	return head; 
} 

/* Function to insert a Node at the end of 
a Circular linked list */
static Node insertNode(Node head_ref, int x) 
{ 
	// Create a new Node 
	Node head = head_ref; 
	Node temp = new Node(x); 

	// if the list is empty, make the new Node head 
	// Also, it will point to itself. 
	if (head == null) 
	{ 
		temp.next = temp; 
		head_ref = temp; 
		return head_ref; 
	} 

	// traverse the list to reach the last Node 
	// and insert the Node 
	else
	{ 
		Node temp1 = head; 
		while (temp1.next != head) 
			temp1 = temp1.next; 
		temp1.next = temp; 
		temp.next = head; 
	} 
	return head; 
} 

/* Driver code */
public static void main(String args[]) 
{ 
	// insert Nodes in the circular linked list 
	Node head = null; 
	head = insertNode(head, 1); 
	head = insertNode(head, 2); 
	head = insertNode(head, 3); 
	head = insertNode(head, 4); 
	head = insertNode(head, 5); 
	head = insertNode(head, 6); 
	head = insertNode(head, 7); 
	head = insertNode(head, 8); 
	head = insertNode(head, 9); 

	int k = 4; 

	// Delete every kth Node from the 
	// circular linked list. 
	head = deleteK(head, k); 
} 
} 

//This code is contributed by Arnab Kundu 

