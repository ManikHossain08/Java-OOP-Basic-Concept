package Exam_3_Practice;

//Java implementation for insertion Sort 
//on a doubly linked list 
public class Circular_Doubly_LinkList_inseertion_sort 
{ 

//Node of a doubly linked list 
static class Node 
{ 
	int data; 
	Node prev, next; 
}; 

//function to create and return a new node 
//of a doubly linked list 
static Node getNode(int data) 
{ 
	// allocate node 
	Node newNode = new Node(); 

	// put in the data 
	newNode.data = data; 
	newNode.prev = newNode.next = null; 
	return newNode; 
} 

//function to insert a new node in sorted way in 
//a sorted doubly linked list 
static Node sortedInsert(Node head_ref, Node newNode) 
{ 
	Node current; 

	// if list is empty 
	if (head_ref == null) 
		head_ref = newNode; 

	// if the node is to be inserted at the beginning 
	// of the doubly linked list 
	else if ((head_ref).data >= newNode.data) 
	{ 
		newNode.next = head_ref; 
		newNode.next.prev = newNode; 
		head_ref = newNode; 
	} 

	else
	{ 
		current = head_ref; 

		// locate the node after which the new node 
		// is to be inserted 
		while (current.next != null && 
			current.next.data < newNode.data) 
			current = current.next; 

		//Make the appropriate links / 

		newNode.next = current.next; 

		// if the new node is not inserted 
		// at the end of the list 
		if (current.next != null) 
			newNode.next.prev = newNode; 

		current.next = newNode; 
		newNode.prev = current; 
	} 
	return head_ref; 
} 

//function to sort a doubly linked list using insertion sort 
static Node insertionSort(Node head_ref) 
{ 
	// Initialize 'sorted' - a sorted doubly linked list 
	Node sorted = null; 

	// Traverse the given doubly linked list and 
	// insert every node to 'sorted' 
	Node current = head_ref; 
	while (current != null) 
	{ 

		// Store next for next iteration 
		Node next = current.next; 

		// removing all the links so as to create 'current' 
		// as a new node for insertion 
		current.prev = current.next = null; 

		// insert current in 'sorted' doubly linked list 
		sorted=sortedInsert(sorted, current); 

		// Update current 
		current = next; 
	} 

	// Update head_ref to point to sorted doubly linked list 
	head_ref = sorted; 
	
	return head_ref; 
} 

//function to print the doubly linked list 
static void printList(Node head) 
{ 
	while (head != null) 
	{ 
		System.out.print(head.data + " "); 
		head = head.next; 
	} 
} 

//function to insert a node at the beginning of 
//the doubly linked list 
static Node push(Node head_ref, int new_data) 
{ 
	// allocate node / 
	Node new_node = new Node(); 

	// put in the data / 
	new_node.data = new_data; 

	// Make next of new node as head and previous as null / 
	new_node.next = (head_ref); 
	new_node.prev = null; 

	// change prev of head node to new node / 
	if ((head_ref) != null) 
		(head_ref).prev = new_node; 

	// move the head to point to the new node / 
	(head_ref) = new_node; 
	
	return head_ref; 
} 

//Driver code 
public static void main(String args[]) 
{ 
	// start with the empty doubly linked list / 
	Node head = null; 

	// insert the following data 
	head=push(head, 9); 
	head=push(head, 3); 
	head=push(head, 5); 
	head=push(head, 10); 
	head=push(head, 12); 
	head=push(head, 8); 

	System.out.println( "Doubly Linked List Before Sorting\n"); 
	printList(head); 

	head=insertionSort(head); 

	System.out.println("\nDoubly Linked List After Sorting\n"); 
	printList(head); 

} 
} 

//This code is contributed by Arnab Kundu 


