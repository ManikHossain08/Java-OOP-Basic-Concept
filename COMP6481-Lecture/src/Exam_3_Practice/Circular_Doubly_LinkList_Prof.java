package Exam_3_Practice;

//*******************************************************************
//LinkedList10.java By: Aiman Hanna (C) 1993 - 2020
//This program introduces doubly linked lists. 
//In fact, the program shows doubly linked lists that are circular as well. 
//
//Key Points:
//1) Doubly Linked Lists. 
//2) Circular Linked Lists.  
//*******************************************************************


import java.util.Scanner;

import java.util.NoSuchElementException;



class List	
{
	// An inner class.
	// Node class. Each node has an integer, a link to the next node (or null) 
	// and a link to the previous node (or null). 
	class Node
	{
		private int x;	
		private Node next;	// A link to the next node
		private Node previous; // A link to the previous node
		
		// Default constructors 
		public Node()
		{
			x = 0;
			next = null;
			previous = null;
		}
		
		
		// Parameterized constructor 
		public Node(int y, Node xt, Node pr)
		{
			x = y;		
			next = xt;
			previous = pr;
		}
		
		
		
		public void setX(int y)
		{
			x = y;		
		}
		
		public void setNext(Node xt)
		{
			next = xt;
		}
		
		public void setPrevious(Node pr)
		{
			previous = pr;
		}
		
		public int getX()
		{
			return x;	
		}
		
		
		public Node getNext()
		{
			return next;
		}
		
		public Node getPrevious()
		{
			return previous;
		}
	}	// end of Node<T> inner class
	
	
	
	
	private Node head;
	private Node tail;
	int size;
	
	// Default constructor
	public List()
	{
		head = null;
		tail = null;
		size = 0;
	}
	
	
	public int getSize()
	{
		return size;
	}
	
	// A method that returns the value at a given index 
	public int getItemAt(int index)
	{
		if (index > size -1)
		{
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			throw new NoSuchElementException();
		}
		int i = 0;
		Node temp = head;
		while(i != index)
		{
			temp = temp.next;
			i++;
		}
		
		return temp.x;
	}
	
	
	// A method that replaces the value at a given index 
	public void replaceItemAt(int index, int val)
	{
		if (index > size -1)
		{
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			throw new NoSuchElementException();
		}
		
		int i = 0;
		Node temp = head;
		while(i != index)
		{
			temp = temp.next;
			i++;
		}
		System.out.println("Replacing value at index # " + index + " from " + temp.x + " to " + val + ". \n");
		temp.x = val;
	}
	
	// A method that inserts a node at a given index. The old node pointed by index is shifted forward (right) 
	public void insertItemAt(int index, int val)
	{
		if (index > size -1)
		{
			System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
			throw new NoSuchElementException();
		}
		
		System.out.println("\nInserting new node with value " + val + " at index # " + index + ".");
		int i = 0;
		Node temp = head;
		
		// Handle the special case when insertion on head
		if (index == 0)
		{
			Node newNode = new Node(val, head, tail);
			head = newNode;
			newNode = null;
		}
		else
		{
			while (i != index -1)	// Stop at the node that precedes index
			{
				temp = temp.next;
				i++;
			}
			// Now we are pointing at the node preceding index
			Node newNode = new Node(val, temp.next, temp);	// next will point to temp.next and 
//previous will point to temp	
			temp.next.previous = newNode;
			temp.next = newNode;
			newNode = null;
		}
		size++;
	}
		
		
		// A method that deletes a node at a given index
		public void deleteItemAt(int index)
		{
			if (index > size -1)
			{
				System.out.println("ERROR: Given index is out of range! Program will terminate. \n");
				throw new NoSuchElementException();
			}
			

			int i = 0;
			Node temp = head;
			
			// Handle the special case when list has only one node
			if (size == 1)
			{
				System.out.println("\nDeleting the only node of the list at index # " + 0 + ".");

				head = tail = null;
				size--;
				return;
			}
			
			// Handle the special cases when deletion on head or tail
			if (index == 0)
			{
				System.out.println("\nDeleting node with value " + head.x + " from index # " + index + ".");
				head = head.next;
				head.previous = tail;
				tail.next = head;
			}
			else if (index == size-1)
			{
				System.out.println("\nDeleting node with value " + tail.x + " from index # " + index + ".");
				tail = tail.previous;
				tail.next = head;
				head.previous = tail;
			}
			else	// The more general case; deletion from the middle
			{
				while (i != index -1)	// Stop at the node that precedes index
				{
					temp = temp.next;
					i++;
				}
				// Now we are pointing at the node preceding index where deletion should take place
				System.out.println("\nDeleting node with value " + temp.next.x + " from index # " + index + ".");
				temp.next = temp.next.next;
				temp.next.previous = temp;
			}
			size--;
	}
	
	
	
	// A method that adds a node at the end of the list
	public void append(int v)
	{
		
		if (head == null)	// List is empty
		{
			Node temp = new Node(v, null, null);
			head = temp;
			head.next = head;
			head.previous = head;
			tail = head;
		}
		else
		{
			Node temp = new Node(v, head, tail);	
			head.previous = temp;
			tail.next = temp;
			tail = temp;
			temp = null;
		}
		size++;
	}

	//Function to insert Node at the beginning 
	//of the List, 
	public void insertBegin(int value) 
	{ 
		if(head == null)
		{
			append(value);
			return;
		}
		
		// Pointer points to last Node 
		Node last = head.previous; 

		Node new_node = new Node(); 
		new_node.x = value; // Inserting the data 

		// setting up previous and next of new node 
		new_node.next = head; 
		new_node.previous = last; 

		// Update next and previous pointers of start 
		// and last. 
		last.next = head.previous = new_node; 

		// Update start pointer 
		head = new_node;
		
		size++;
		
	} 
	
	//Function to insert node with value as value1. 
	//The new node is inserted after the node with 
	//with value2 
	public void insertAfter(int value1, 
										int value2) 
	{ 
		Node new_node = new Node(); 
		new_node.x = value1; // Inserting the data 

		// Find node having value2 and next node of it 
		// here is a bug like infinity loop need to fix it using the condition
		Node temp = head; 
		while (temp.x != value2) 
			temp = temp.next; 
		Node next = temp.next; 

		// insert new_node between temp and next. 
		temp.next = new_node; 
		new_node.previous = temp; 
		new_node.next = next; 
		next.previous = new_node; 
	} 
	
	//Function to insert node with value as value1. 
		//The new node is inserted after the node with 
		//with value2 
	public void insertBefore(int value1, int value2) 
	{ 
		
		Node p = new Node(); 
        p.x = value1; // new insertion node
        p.next = null; 
		
		// Insert Before: Find the node before which we need to  insert p. 
        Node temp = head.next; 
        while (temp.x != value2) 
                temp = temp.next; 
                  
        // Insert new node before temp  
        temp.previous.next = p; 
        p.previous = temp.previous; 
        temp.previous = p; 
        p.next = temp; 
	} 


	// sorted insert in the CDLL
	public void nodeInsetail(int key) 
    { 
        Node p = new Node(); 
        p.x = key; 
        p.next = null; 
  
        // If first node to be insetailed in doubly  
        // linked list 
        if (head == null) 
        { 
        	append(key);
            return; 
        } 
  
        // If node to be insetailed has value less  
        // than first node  
        if (p.x < head.x) 
        { 
            p.previous = null; 
            head.previous = p; 
            p.next = head; 
            head = p; 
            return; 
        } 
              
        // If node to be insetailed has value more  
        // than last node  
        if (p.x > tail.x) 
        { 
            p.previous = tail; 
            tail.next = p; 
            tail = p; 
            return; 
        } 
  
        // Insert Before: Find the node before which we need to  insert p. 
        Node temp = head.next; 
        while (temp.x < p.x) 
                temp = temp.next; 
                  
        // Insert new node before temp  
        (temp.previous).next = p; 
        p.previous = temp.previous; 
        temp.previous = p; 
        p.next = temp; 
    } 
	
	
	public void showListContents()
	{
		if (size == 0)
		{
			System.out.println("There is nothing to display; list is empty." );
			return;
		}
		
		
		System.out.println("List size is: " + size + ". Here are the contents of the list." );
		Node temp = head;
		
		while(temp != tail)
		{
			System.out.print("" + temp.x  + " <===> ");
			temp = temp.next;		
		}
		// Display that last node
		System.out.println("" + temp.x  + " <===> " + head.x);
		//System.out.println("" + temp.x  + " <===> (Back to First Node)");
	}
}




public class Circular_Doubly_LinkList_Prof{
	
	
	public static void main(String[] args) 
	{

		Scanner kb = new Scanner(System.in);

		//int i;
		// Create a list
		List lst1 = new List();
		
		lst1.insertBegin(10);
		lst1.append(20);
		lst1.insertBegin(30);
		lst1.showListContents();
		
		lst1.insertBegin(40);
		lst1.append(50);
		lst1.insertBegin(60);
		lst1.insertAfter(100, 40);
		lst1.showListContents();
		lst1.insertBefore(200, 10);
		lst1.showListContents();
		
		/*
		
		System.out.println("A list of Cars has been created. Its current size is: " + lst1.getSize());
		System.out.print("You can add nodes to the list by entering some values; enter -1 to terminate: ");
		
		i = kb.nextInt();
		while (i != -1)
		{
			lst1.append(i);
			i = kb.nextInt();
		}
		
		if(lst1.getSize() != 0)
		{
			System.out.println("\nItems were added to the list. The list current size is: " + lst1.getSize());	
			lst1.showListContents();
		}
		
		lst1.replaceItemAt(0, 444);
		
		lst1.replaceItemAt(3, 888);
		System.out.println("\nThe list current size is: " + lst1.getSize());	
		lst1.showListContents();
		
		lst1.deleteItemAt(6);
		System.out.println("The list current size is: " + lst1.getSize());	
		lst1.showListContents();

		lst1.insertItemAt(8, 777);
		System.out.println("The list current size is: " + lst1.getSize());	
		lst1.showListContents();
		
		// Create a second list just to test some of the special cases
		
		System.out.println("\nNow will be creating and manipulating a second list");	
		System.out.println("===================================================");	
		
		List lst2 = new List();
		lst2.append(10);
		lst2.deleteItemAt(0);
		System.out.println("The list current size is: " + lst2.getSize());	
		lst2.showListContents();
	
		lst2.append(1000);
		lst2.append(2000);
		lst2.deleteItemAt(1);
		lst2.showListContents();		
		
		lst2.insertItemAt(0, 5000);
		lst2.showListContents();		
	*/
		System.out.println("\nThanks for using our Doubly Linked List. Goodbye.");
		kb.close();
		
	}
}

