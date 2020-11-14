package LinkedList_Lab_7;

//*******************************************************************
//LinkedList9.java By: Aiman Hanna (C) 1993 - 2020
//This program illustrates iterators. The program is indented only  
//to provide an introduction to iterators, so it is kept as simple 
//as possible. You should hence note that there are some obvious 
//situations where this code may misbehave. Look for "WARNING" in the 
//text. This is just an example of such potential misbehavior. 
//You should also look at the output for cases when exceptions will 
//be thrown by the program. 
//
//Key Points:
//1) Iterators.  
//*******************************************************************


import java.util.Scanner;
import java.util.NoSuchElementException;



//A generic linked list class that uses the generic Node class
//Notice the bounded use of type T
class List	
{
	// An inner class.
	// Node class. Each node has an integer and a link to the next node (or null). 
	private class Node
	{
		private int x;	
		private Node next;	// A link to the next node
		
		// Default constructors 
		public Node()
		{
			x = 0;
			next = null;
		}
		
		
		// Parameterized constructor 
		public Node(int y, Node xt)
		{
			x = y;		
			next = xt;
		}
		
		
		
		public void setX(int y)
		{
			x = y;		
		}
		
		public void setNext(Node xt)
		{
			next = xt;
		}
		
		
		public int getX()
		{
			return x;	
		}
		
		
		public Node getNext()
		{
			return next;
		}
	}	// end of Node<T> inner class
	
	
	// An inner iterator class 
	public class ListIterator 		// ListIterator is just a name; it can be given a different name 
	{
		// Two attributes. Except for special cases, such as empty list, "current" will always point
		// to a specific location on the list, where various operations will take place. "previous" 
		// points to the node preceding the one pointed by "current" 
		private Node current;
		private Node previous;
		
		// Resets the pointers
		public void reset()
		{
			current = head;		// This is the attribute "head" of the outer class
			previous = null;
		}
		
		
		// Find out if there are more nodes after the one pointed by "current". "current" is allowed 
		// to move to the null pointed by the last node in the list, and so hasNext will still 
//return true if "current" is pointing to the last node in the list at the time it is called. 
		public boolean hasNext()
		{
			if(current == null)
				return false;		// No next nodes (from the current position) are there in the list 
			else 
				return true;
		}
	
		
		
		// Return the value of the node pointed by "current", then moves both "current" and "previous" 
		// ahead by one node
		public int next()
		{
			if(!hasNext())
			{
				System.out.println("ERROR: Pointing to NULL. No value to return and cannot move forward! Program will terminate. \n");
				throw new NoSuchElementException();
			}

			else 		// You do not really need that else. You are only here if nothing is thrown
			{
				int val = current.x;
				previous = current;		// Move to the following node 
				current = current.next;		// Move to the following node 	 
				return val;
			}
				
		}
		
		
		// Return the value of the node pointed by "current", but do NOT move "current" or "previous" 
		public int peek()
		{
			if(!hasNext())
			{
				System.out.println("ERROR: Pointing to NULL. Cannot peek from that node! Program will terminate. \n");
				throw new NoSuchElementException();
			}
			else 
			{
				return current.x;
			}
		}
		
		// Adds a new node before current. "current" does not move; "previous" moves to point to this new node
		public void addBeforeCurrent(int v)
		{
			if(head == null)	// List is empty
			{
				head = new Node(v, null);
				current = head;
				previous = null;
			}
			else if (current == head)	// current points to the first node in the list
			{
				previous = new Node(v, head);
				head = previous;
			}
			else 
			{
				previous.next = new Node(v, previous.next);
				previous = previous.next;
			}
		}
		
		
		// Change the contents of the node pointed by "current"
		public void change(int v)
		{
			if(!hasNext())
			{
				System.out.println("ERROR: Pointing to NULL. Cannot change value! Program will terminate. \n");
				throw new NoSuchElementException();
			}
			else 
			{
				current.x = v;
			}
		}
		
		// Delete the node pointed by "current"; and move "current" to the next node
		public void delete()
		{
			if(!hasNext())
			{
				System.out.println("ERROR: Pointing to NULL. Cannot delete node! Program will terminate. \n");
				throw new NoSuchElementException();
			}
			if(current == head)		// Case when current is pointing at the first node
			{
				current = current.next;
				head = current;
			}
			else 
			{
				previous.next = current.next;
				current = previous.next;
			}
		}
		
		
	}
	
	
	private Node head;
	
	// Default constructor
	public List()
	{
		head = null;
	}
	
	// Copy constructor -  use the clone() method of the Node class
	// Does this really work? Is the result a deep copy? 
	public List(List lst)
	{
		if(lst == null) throw new NullPointerException();
		if (lst.head == null)
			head = null;
		else
		{
			// Call our copyList() method to copy the list
			head = copyList(lst.head);
		}
	}
		
	
	
	// A method that returns an iterator to for "this" List object
	public ListIterator createIterator()
	{
		return new ListIterator();
	}
	
	
	
	// A method that adds a node to the start of the list
	// WARNING: This method does not manipulate the iterator, and hence 
	// programmers must either reset the iterators when this method is called or
	// write additional code to adjust the iterators 
	public void addToStart(int v)
	{
		head = new Node(v, head);	
	}

	// A method that removes a node form the start of the list 
	public boolean deleteFromStart()
	// WARNING: This method does not manipulate the iterator, and hence 
	// programmers must either reset the iterators when this method is called or
	// write additional code to adjust the iterators 
	{
		if (head != null)
		{
			head = head.next;	// Access to inner class private attributes are possible 
			return true;
		}
		else
			return false;
	}
	
	// A method to return the size of the list
	public int size()
	{
		int ctr = 0;
		Node temp = head;	// Point to the start of the list
		while( temp!= null)
		{
			ctr++;
			temp = temp.next;	
		}
		return ctr;
	}
	
	// A method that searches the list for a given value and returns the first node that has this 
	// value of null if no node exists with this value
	private Node find(int v)		
	{
		Node temp = head;
		while( temp != null )
		{
			if (temp.x == v)
			{
				return temp;		
			}						
			temp = temp.next;		// Move temp to the next node
		}
		// If this point is reached then the car was not found in the list
		return null;
	}

	// A method that indicates whether or not a a node in the list has some value
	public boolean contains(int v)
	{
		if(find(v) != null)
			return true;
		else 
			return false;
	}

	

	
	public void showListContents()
	{
		Node temp = head;
		if (temp == null)
			System.out.println("There is nothing to display; list is empty." );
		else
			System.out.println("Here are the contents of the list." );
		while(temp != null)
		{
			System.out.print("" + temp.x  + " ---> ");
			temp = temp.next;		
		}
		System.out.println("X");	// Just show "X" indicating the end of the list (null)
	}
	
	// This clone() method will perform the entire copying operation itself instead of 
	// just calling the copy constructor 

	public List clone()
	{
		// First call the clone() method from the Object class. This will 
		// verify whether the class implements the Cloneable interface. If this test 
		// passes, then a copy of the object is returned. However this copy is a 
		// shallow copy, so further operations need to be done after that to create a 
		// deep copy
		try
		{
			List newLst = (List)super.clone();
			if (head == null)
				newLst.head = null;
			else
				// Call our copyList() method to copy the list
				newLst.head = copyList(head);
			return newLst;
		}
		catch (CloneNotSupportedException e)
		{	//This should not happen
			return null;
		}
	}
	
	// Given a Node pointer that is not null, this method create and return
	// a deep copy of this list pointed by this pointer
	private Node copyList(Node n1)
	{
		Node temp = n1;
		Node newHead = null;
		Node end = null;		// This pointer will always point at the end of the new list 
								// while it is being created (growing)
		newHead = new Node(temp.x, null);		
		
		end = newHead;
		temp = temp.next;
		
		while (temp != null)
		{
			end.next = new Node(temp.x, null);

			
			end = end.next;
			temp = temp.next;
		}
		
		// Now the entire list is created, just return its head pointer
		return newHead;
		
	}
	
	
}




public class LinkedList_Iterators{
	
	
	public static void main(String[] args) 
	{

		Scanner kb = new Scanner(System.in);

		int i;
		// Create a list
		List lst1 = new List();
		
		// Create an iterator for that list
		List.ListIterator iter1 = lst1.createIterator();
		
		System.out.println("A list of Cars has been created. Its current size is: " + lst1.size());
		System.out.print("You can add nodes to the list by entering some values; enter -1 to terminate: ");
		
		i = kb.nextInt();
		while (i != -1)
		{
			lst1.addToStart(i);
			i = kb.nextInt();
		}
		
		if(lst1.size() != 0)
		{
			System.out.println("\nItems were added to the list. The list current size is: " + lst1.size());	
			lst1.showListContents();
		}
		
		
		// Now start using the iterator
		iter1.reset();
		
		i = 0;
		// Move the iterator 3 places ahead if the list has these many node; 
		// otherwise, it moves to the end of the list
		while (iter1.hasNext() && i++ < 3)
		{
			iter1.next();
		}
		
		
		System.out.println("\nThe current node pointed by the iterator is: " + iter1.peek());	
		
		// Change the value of the node pointed by the iterator
		iter1.change(190);
		
		// Add few nodes before the "current" pointer of the iterator
		iter1.addBeforeCurrent(300);
		iter1.addBeforeCurrent(400);
		iter1.addBeforeCurrent(500);
		iter1.addBeforeCurrent(600);
		
		System.out.println("\nThe list current size is: " + lst1.size());	
		lst1.showListContents();

		
		// Move the iterator two location ahead if possible and delete that node (if exists) 
		iter1.next();
		iter1.next();
		System.out.println("\nThe current node pointed by the iterator is: " + iter1.peek());	
		System.out.println("\nAttempting to delete the node pointed by the iterator ");
			
		iter1.delete();
		
		
		System.out.println("\nThe list current size is: " + lst1.size());	
		lst1.showListContents();


		System.out.println("\nThanks for using our Linked List & Iterators. Goodbye.");
		kb.close();
	}
	
}

