package Exam_3_Practice;

/*
 *  Java Program to Implement Doubly Linked List
 */
 
import java.util.Scanner;
 
 
/* Class linkedList */
class DlinkedList
{ 
	
	class Node
	{
	    protected int data;
	    protected Node next, prev;
	 
	    /* Constructor */
	    public Node()
	    {
	        next = null;
	        prev = null;
	        data = 0;
	    }
	    /* Constructor */
	    public Node(int d, Node n, Node p)
	    {
	        data = d;
	        next = n;
	        prev = p;
	    }
	
	}
    protected Node start;
    protected Node end ;
    public int size;
 
    /* Constructor */
    public DlinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /* Function to check if list is empty */
    public boolean isEmpty()
    {
        return start == null;
    }
    /* Function to get size of list */
    public int getSize()
    {
        return size;
    }
    /* Function to insert element at begining */
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null, null);        
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            start.prev = nptr;
            nptr.next = start;
            start = nptr;
        }
        size++;
    }
    /* Function to insert element at end */
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val, null, null);        
        if(start == null)
        {
            start = nptr;
            end = start;
        }
        else
        {
            nptr.prev = end;
            end.next = nptr;
            end = nptr;
        }
        size++;
    }
    /* Function to insert element at position */
    public void insertAtPos(int val , int pos)
    {
        Node nptr = new Node(val, null, null);    
        if (pos == 1)
        {
            insertAtStart(val);
            return;
        }            
        Node ptr = start;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node tmp = ptr.next;
                ptr.next = nptr;
                nptr.prev = ptr;
                nptr.next = tmp;
                tmp.prev = nptr;
            }
            ptr = ptr.next;            
        }
        size++ ;
    }
    /* Function to delete node at position */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            if (size == 1)
            {
                start = null;
                end = null;
                size = 0;
                return; 
            }
            start = start.next;
            start.prev = null;
            size--; 
            return ;
        }
        if (pos == size)
        {
            end = end.prev;
            end.next = null;
            size-- ;
        }
        Node ptr = start.next;
        for (int i = 2; i <= size; i++)
        {
            if (i == pos)
            {
                Node p = ptr.prev;
                Node n = ptr.next;
 
                p.next = n;
                n.prev = p;
                size-- ;
                return;
            }
            ptr = ptr.next;
        }        
    }    
    /* Function to display status of list */
    public void display()
    {
        System.out.print("\nDoubly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }
        if (start.next == null) 
        {
            System.out.println(start.data );
            return;
        }
        Node ptr = start;
        System.out.print(start.data+ " <-> ");
        ptr = start.next;
        while (ptr.next != null)
        {
            System.out.print(ptr.data+ " <-> ");
            ptr = ptr.next;
        }
        System.out.print(ptr.data+ "\n");
    }
}
 
/* Class DoublyLinkedList */
public class DoublyLinkList_2
{    
    public static void main(String[] args)
    {            
        Scanner scan = new Scanner(System.in);
      
        DlinkedList list = new DlinkedList(); 
        
                list.insertAtStart( 10);                     
                                  
            
                list.insertAtEnd( 20 );   
                list.insertAtEnd( 30 ); 
                list.insertAtStart(100);      
                
           
                int pos = 5 ;
                if (pos < 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(30, pos);
              
                int p = 10 ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
              
                System.out.println("Empty status = "+ list.isEmpty());
               
                System.out.println("Size = "+ list.getSize() +" \n");
                list.display();
                        
            scan.close();        
    }
}