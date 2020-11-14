package LinkedList_Lab_7;

//Java program to illustrate merge sorted 
//of linkedList 

class DataLinkedList {  
	public static class Node {
	    int data; 
	    Node nextNode;
	
	    public Node(int data) {
	        this.data = data;
	        this.nextNode = null;       
	    }
	
	    public int getData() {
	        return this.data;
	    }
	} // Node class

    private  Node head;
    private int size; 

    public DataLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            Node currentNode = head;
            while(currentNode.nextNode != null) {
                currentNode = currentNode.nextNode;
            }
            currentNode.nextNode = node;
        }
        size++;     
    }

    public void sort() {
        if (size > 1) {
        	boolean wasChanged;
        	
            do {
                Node current = head;
                Node previous = null;
                Node next = head.nextNode;
                wasChanged = false;
                
                while ( next != null ) {
                    if (current.data > next.data) {
                        /*
                        // This is just a literal translation
                        // of bubble sort in an array
                        Node temp = currentNode;
                        currentNode = next;
                        next = temp;*/
                        wasChanged = true;
                        
                        if ( previous != null ) {
                        	Node sig = next.nextNode;
                        	
                        	previous.nextNode = next;
                        	next.nextNode = current;
                        	current.nextNode = sig;
                        } else {
                        	Node sig = next.nextNode;
                        	
                        	head = next;
                        	next.nextNode = current;
                        	current.nextNode = sig;
                        }
                        
                        previous = next;
                        next = current.nextNode;
                    } else { 
						previous = current;
	                    current = next;
	                    next = next.nextNode;
                    }
                } 
            } while( wasChanged );
        }
    }

    public int listSize() {     
        return size;
    }

    public void printData() {
        Node currentNode = head;
        
        System.out.print("[ ");
        while(currentNode != null) {
            int data = currentNode.getData();
            System.out.print(data + " ");
            currentNode = currentNode.nextNode;
        }
        
        System.out.print(" ]");
        System.out.println();
    }

    public boolean isEmpty() {
        return size == 0;
    }
} // DataInterface class

public class LinkedList_BubbleSort {

    public static void main (String[]args) {

        DataLinkedList dll = new DataLinkedList();

        dll.add(8);
        dll.add(4);
        dll.add(3);
        dll.add(7);
        dll.add(6);
        dll.add(1);

		dll.printData();
        dll.sort();
        dll.printData();
        System.out.println("List size: " + dll.listSize());
    }
}



