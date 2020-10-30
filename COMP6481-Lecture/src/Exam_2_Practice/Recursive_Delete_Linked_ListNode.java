package Exam_2_Practice;

public class Recursive_Delete_Linked_ListNode {
	// Recursive Java program to delete k-th node 
	// of a linked list 
		
	static class Node 
	{ 
		int data; 
		Node next; 
	}; 

	// Deletes k-th node and returns new header. 
	static Node deleteNode(Node start, int k) 
	{ 
		// If invalid k 
		if (k < 1) 
		return start; 

		// If linked list is empty 
		if (start == null) 
		return null; 

		// Base case (start needs to be deleted) 
		if (k == 1) 
		{ 
			Node res = start.next; 
			return res; 
		} 
		
		start.next = deleteNode(start.next, k-1); 
		return start; 
	} 

	// Utility function to insert a node at the beginning / 
	static Node push( Node head_ref, int new_data) 
	{ 
		Node new_node = new Node(); 
		new_node.data = new_data; 
		new_node.next = head_ref; 
		head_ref = new_node; 
		return head_ref; 
	} 

	// Utility function to print a linked list / 
	static void printList( Node head) 
	{ 
		while (head!=null) 
		{ 
			System.out.print(head.data + " "); 
			head = head.next; 
		} 
		System.out.printf("\n"); 
	} 

	// Driver program to test above functions / 
	public static void main(String args[]) 
	{ 
		Node head = null; 

		// Create following linked list 
		//12.15.10.11.5.6.2.3 / 
		head=push(head,3); 
		head=push(head,2); 
		head=push(head,6); 
		head=push(head,5); 
		head=push(head,11); 
		head=push(head,10); 
		head=push(head,15); 
		head=push(head,12); 
		
		int k = 3; 
		head = deleteNode(head, k); 

		System.out.printf("\nModified Linked List: "); 
		printList(head); 
	} 
	} 



