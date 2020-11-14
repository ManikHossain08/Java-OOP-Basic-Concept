package LinkedList_Lab_7;


class LLRNode {
	private class Node {
		private int v;
		private Node next; // A link to the next node,
		// which is of type Node1

		// Default constructors
		public Node() {
			v = 0;
			next = null;
		}

		// Parameterized constructor
		public Node(int i, Node xt) {
			v = i;
			next = xt;
		}

	} // end of inner class Node

	private Node head;

	public LLRNode() {
		head = null;
	}

	public static int length(Node l) {
		if (l == null)
			return 0;
		else
			return 1 + length(l.next);
	}

	public static int sum(Node l) {
		if (l == null)
			return 0;
		else
			return l.v + sum(l.next);
	}

	public static void print(Node l) {
		if (l == null)
			return;
		else {
			System.out.println(l.v);
			print(l.next);
		}
		;
	}

	public static void reversePrint(Node l) {
		if (l == null)
			return;
		else {
			reversePrint(l.next);
			System.out.println(l.v);
		}
		;
	}

	public static Node search(Node l, int value) {
		if (l == null)
			return null;
		else if (l.v == value)
			return l;
		else
			return search(l.next, value);
	}

	public static Node removeAll(Node l, int value) {
		if (l != null)
			if (l.v == value)
				l = removeAll(l.next, value);
			else
				l.next = removeAll(l.next, value);

		return l;
	}

	public int total(Node n) {
		int sum = 0;
		while (n != null) {
			sum += n.v;
			n = n.next;
		}
		return sum;
	}

	void insertInOrder(int n) {
		if (head == null) // case 1: list is empty
			head = new Node(n, null);
		else if (head.v >= n) // case 2: n should be before the first node
			head = new Node(n, head); // push on front of list
		else { // case 3: find the node before where n should be using the inchworm technique

			Node p = head.next;
			Node q = head;
			while (p != null) {
				if (p.v >= n) { // found insertion point, between p and q
					q.next = new Node(n, p);
					return;
				}
				q = p; // chain along!
				p = p.next;
			}
			q.next = new Node(n, null); // case 4: Node must be added at end of list
		}
	}
	
	
	public void showListContents() {
		Node temp = head;
		if (temp == null)
			System.out.println("\nThere is nothing to display; list is empty.");
		else
			System.out.println("\nHere are the contents of the list.");
		while (temp != null) {
			System.out.print(temp.v + " ---> ");
			temp = temp.next; 
		}
		System.out.println("X"); 
	}
	
	public Node copyList() {
	    Node p = this.head;
	    if(p == null)                   // Case 1: list is empty
	      return null;       
	    else {                          // Case 2: list has at least one node
	      Node c = new Node(p.v, null);    //    put first node in place in copy
	      Node last = c;                // Maintain a pointer to the last node to facilitate adding to the end of the list
	      p = p.next;
	      while( p != null ) {
	        last.next = new Node(p.v, null); 
	        last = last.next;           // chain along original list and with the last node in new list
	        p = p.next; 
	      }
	      return c; 
	    }
	  }
	
	public Node merge( Node p, Node q ) {
        if ( p == null) 
           return q;
        else if ( q == null) 
           return p;
        else if (p.v < q.v) {
           p.next = merge( p.next, q );
           return p;
        }
        else {
           q.next = merge( p, q.next );
           return q;
        }
     } // head = merge( head, anotherlist );
	
	public static Node deleteLast( Node p ) {
	       if( p == null || p.next == null ) 
	          return null;      
	       else {
	          p.next = deleteLast( p.next );
	          return p;
	       }
	    }   
	
	Node append( Node p, Node q ) {
        if ( p == null) 
           return q; 
        else {
          p.next = append( p.next, q );
          return p;
        }
     } // head = append(head, anotherList); 

}

public class LinkedList_Recursion {

	public static void main(String[] args) {
		LLRNode node = new LLRNode();
		node.insertInOrder(5);
		node.insertInOrder(10);
		node.insertInOrder(3);
		node.insertInOrder(1);
		node.insertInOrder(100);
		node.insertInOrder(50);
		
		node.showListContents();
		
	}

}