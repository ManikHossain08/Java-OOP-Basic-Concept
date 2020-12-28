package Exam_3_Practice;

//Java implementation for Sorted merge of two 
//sorted doubly circular linked list 
public class Circular_Doubly_merge_two_CDLL 
{ 
	
static class Node 
{ 
	int data; 
	Node next, prev; 
}; 

//A utility function to insert a new node at the 
//beginning of doubly circular linked list 
static Node insert(Node head_ref, int data) 
{ 
	// allocate space 
	Node new_node = new Node(); 

	// put in the data 
	new_node.data = data; 

	// if list is empty 
	if (head_ref == null) 
	{ 
		new_node.next = new_node; 
		new_node.prev = new_node; 
	} 

	else
	{ 

		// pointer points to last Node 
		Node last = (head_ref).prev; 

		// setting up previous and next of new node 
		new_node.next = head_ref; 
		new_node.prev = last; 

		// update next and previous pointers of head_ref 
		// and last. 
		last.next = (head_ref).prev = new_node; 
	} 

	// update head_ref pointer 
	head_ref = new_node; 
	return head_ref; 
} 

//function for Sorted merge of two 
//sorted doubly linked list 
static Node merge(Node first, Node second) 
{ 
	// If first list is empty 
	if (first == null) 
		return second; 

	// If second list is empty 
	if (second == null) 
		return first; 

	// Pick the smaller value and adjust 
	// the links 
	if (first.data < second.data) 
	{ 
		first.next = merge(first.next, second); 
		first.next.prev = first; 
		first.prev = null; 
		return first; 
	} 
	else
	{ 
		second.next = merge(first, second.next); 
		second.next.prev = second; 
		second.prev = null; 
		return second; 
	} 
} 

//function for Sorted merge of two sorted 
//doubly circular linked list 
static Node mergeUtil(Node head1, Node head2) 
{ 
	// if 1st list is empty 
	if (head1 == null) 
		return head2; 

	// if 2nd list is empty 
	if (head2 == null) 
		return head1; 

	// get pointer to the node which will be the 
	// last node of the final list 
	Node last_node; 
	if (head1.prev.data < head2.prev.data) 
		last_node = head2.prev; 
	else
		last_node = head1.prev; 

	// store null to the 'next' link of the last nodes 
	// of the two lists 
	head1.prev.next = head2.prev.next = null; 

	// sorted merge of head1 and head2 
	Node finalHead = merge(head1, head2); 

	// 'prev' of 1st node pointing the last node 
	// 'next' of last node pointing to 1st node 
	finalHead.prev = last_node; 
	last_node.next = finalHead; 

	return finalHead; 
} 

//function to print the list 
static void printList(Node head) 
{ 
	Node temp = head; 

	while (temp.next != head) 
	{ 
		System.out.print ( temp.data+ " "); 
		temp = temp.next; 
	} 
	System.out.print ( temp.data + " "); 
} 

//Driver code 
public static void main(String args[]) 
{ 
	Node head1 = null, head2 = null; 

	// list 1: 
	head1 = insert(head1, 8); 
	head1 = insert(head1, 5); 
	head1 = insert(head1, 3); 
	head1 = insert(head1, 1); 

	// list 2: 
	head2 = insert(head2, 11); 
	head2 = insert(head2, 9); 
	head2 = insert(head2, 7); 
	head2 = insert(head2, 2); 

	Node newHead = mergeUtil(head1, head2); 

	System.out.print( "Final Sorted List: "); 
	printList(newHead); 
} 
} 

/*
 * Merge two unsorted linked lists to get a sorted list
// Java program for 
// the above approach
class GFG{

static node head1 = null;
static node head2 = null;

// Create structure for a node
static class node
{
int data;
node next;
};

// Function to print 
// the linked list
static void setData(node head)
{
node tmp;

// Store the head of the linked
// list into a temporary node
// and iterate
tmp = head;

while (tmp != null) 
{
	System.out.print(tmp.data + " -> ");
	tmp = tmp.next;
}
}

// Function takes the head of the
// LinkedList and the data as
// argument and if no LinkedList
// exists, it creates one with the
// head pointing to first node.
// If it exists already, it appends
// given node at end of the last node
static node getData(node head, int num)
{
// Create a new node
node temp = new node();
node tail = head;

// Insert data into the temporary
// node and point it's next to null
temp.data = num;
temp.next = null;

// Check if head is null, create a
// linked list with temp as head
// and tail of the list
if (head == null) 
{
	head = temp;
	tail = temp;
}

// Else insert the temporary node
// after the tail of the existing
// node and make the temporary node
// as the tail of the linked list
else
{
	while (tail != null) 
	{
	if (tail.next == null) 
	{
		tail.next = temp;
		tail = tail.next;
	}
	tail = tail.next;
	}
}

// Return the list
return head;
}

// Function to concatenate 
// the two lists
static node mergelists()
{
node tail = head1;

// Iterate through the 
// head1 to find the
// last node join the 
// next of last node
// of head1 to the 
// 1st node of head2
while (tail != null) 
{
	if (tail.next == null && 
		head2 != null) 
	{
	tail.next = head2;
	break;
	}
	tail = tail.next;
}

// return the concatenated 
// lists as a single list - head1
return head1;
}

// Sort the linked list 
// using bubble sort
static void sortlist()
{
node curr = head1;
node temp = head1;

// Compares two adjacent elements
// and swaps if the first element
// is greater than the other one.
while (curr.next != null) 
{
	temp = curr.next;
	while (temp != null) 
	{
	if (temp.data < curr.data) 
	{
		int t = temp.data;
		temp.data = curr.data;
		curr.data = t;
	}
	temp = temp.next;
	}
	curr = curr.next;
}
}

// Driver Code
public static void main(String[] args)
{
// Given Linked List 1
head1 = getData(head1, 4);
head1 = getData(head1, 7);
head1 = getData(head1, 5);

// Given Linked List 2
head2 = getData(head2, 2);
head2 = getData(head2, 1);
head2 = getData(head2, 8);
head2 = getData(head2, 1);

// Merge the two lists
// in a single list
head1 = mergelists();

// Sort the unsorted merged list
sortlist();

// Print the final
// sorted merged list
setData(head1);
}
}

// This code is contributed by shikhasingrajput

*/
