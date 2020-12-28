package Exam_3_Practice;

//A complete working Java program to demonstrate all 

//Class for Doubly Linked List 
public class DoublyLink_List {
	
	/* Doubly Linked list Node*/
	private class Node { 
		int data; 
		Node prev; 
		Node next; 

		// Constructor to create a new node 
		// next and prev is by default initialized as null 
		Node(int d) { 
			data = d; 
			prev = null; 
			next = null; 
			} 
	} 
	
	Node head, tail; // head of list 
	//Represent the head and tail of the doubly linked list  
   
	
	// always Adding a node at the front of the list 
	public void addToFirst(int new_data)  
	{ 
		/* 1. allocate node 
		* 2. put in the data */
		Node new_Node = new Node(new_data); 

		/* 3. Make next of new node as head and previous as NULL */
		new_Node.next = head; 
		new_Node.prev = null; 

		/* 4. change prev of head node to new node */
		if (head != null) 
			head.prev = new_Node; 
		else  tail.next = null;  
		/* 5. move the head to point to the new node */
		head = new_Node; 
	} 
	
	// Function to delete a node in a Doubly Linked List.
    // head_ref --> pointer to head node pointer.
    // del --> data of node to be deleted.
    public int delete (Node del)
    {
    	int val = del.data;
        // Base case
        if (head == null || del == null) {
            return -1;
        }
 
        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }
 
        // Change next only if node to be deleted
        // is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }
 
        // Change prev only if node to be deleted
        // is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }
 
        // Finally, free the memory occupied by del
        return val;
    }

	/* Given a node as prev_node, insert a new node after the given node */
	public void InsertAfter(Node prev_Node, int new_data) 
	{ 

		/*1. check if the given prev_node is NULL */
		if (prev_Node == null) { 
			System.out.println("The given previous node cannot be NULL "); 
			return; 
		} 

		/* 2. allocate node 
		* 3. put in the data */
		Node new_node = new Node(new_data); 

		/* 4. Make next of new node as next of prev_node */
		new_node.next = prev_Node.next; 

		/* 5. Make the next of prev_node as new_node */
		prev_Node.next = new_node; 

		/* 6. Make prev_node as previous of new_node */
		new_node.prev = prev_Node; 

		/* 7. Change previous of new_node's next node */
		if (new_node.next != null) 
			new_node.next.prev = new_node; 
	} 
	
	

	// Add a node at the end of the list 
	public void addToEnd(int new_data) 
	{ 
		/* 1. allocate node 
		* 2. put in the data */
		Node new_node = new Node(new_data); 

		//Node last = head; /* used in step 5*/

		/* 3. This new node is going to be the last node, so 
		* make next of it as NULL*/
		new_node.next = null; 

		/* 4. If the Linked List is empty, then make the new 
		* node as head */
		if (head == null) { 
			new_node.prev = null; 
			head = tail = new_node; 
			tail.next = null;
			return; 
		}else {
			//newNode will be added after tail such that tail's next will point to newNode  
            tail.next = new_node;  
            //newNode's previous will point to tail  
            new_node.prev = tail;  
            //newNode will become new tail  
            tail = new_node;  
            //As it is last node, tail's next will point to null  
            tail.next = null;  
		} 

//		/* 5. Else traverse till the last node */
//		while (last.next != null) 
//			last = last.next; 
//
//		/* 6. Change the next of last node */
//		last.next = new_node; 
//
//		/* 7. Make last node as previous of new node */
//		new_node.prev = last; 
	} 
	
	
	//deleteFromEnd() will delete a node from the end of the list  
    public void deleteFromEnd() {  
        //Checks whether list is empty  
        if(head == null) {  
            return;  
        }  
        else {  
            //Checks whether the list contains only one node  
            if(head != tail) {  
                //Previous node to the tail will become new tail  
                tail = tail.prev;  
                //Node next to current tail will be made null  
                tail.next = null;  
            }  
            //If the list contains only one element   
            //Then it will remove node and now both head and tail will point to null  
            else {  
                head = tail = null;  
            }  
        }  
    }  
    
    
    /*
    
     * this method removes element from the start of the linked list
     * @return
   
    public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: "+tmp.element);
        return tmp.element;
    }
     
    /**
     * this method removes element from the end of the linked list
     * @return
   
    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: "+tmp.element);
        return tmp.element;
    }
     */
    
    

	// This function prints contents of linked list starting from the given node 
	public void printlist(Node node) 
	{ 
		Node last = null; 
		System.out.println("Traversal in forward Direction"); 
		while (node != null) { 
			System.out.print(node.data + " "); 
			last = node; 
			node = node.next; 
		} 
		System.out.println(); 
		System.out.println("Traversal in reverse direction"); 
		while (last != null) { 
			System.out.print(last.data + " "); 
			last = last.prev; 
		} 
	} 

	/* Driver program to test above functions*/
	public static void main(String[] args) 
	{ 
		/* Start with the empty list */
		DoublyLink_List dll = new DoublyLink_List(); 

		dll.addToEnd(6);  
		dll.addToFirst(7); 
		dll.addToFirst(1); 
		dll.addToEnd(4); 
		dll.InsertAfter(dll.head.next, 8); 
		
		// Deleting middle node from 1->7->8->6->4->NULL 
        //dll.delete(dll.head.next);
        dll.deleteFromEnd();
        dll.deleteFromEnd();
        
        dll.addToEnd(10); 

		// Insert 7 at the beginning. So linked list becomes 7->6->NULL 
		dll.addToFirst(0); 
		 dll.addToEnd(11); 

		System.out.println("Created DLL is: "); 
		dll.printlist(dll.head); 
		
		
		
		
	} 
} 




