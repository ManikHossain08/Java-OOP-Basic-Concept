package LinkedList_Lab_7;

import java.util.HashMap;
import java.util.Map;

// *******************************************************************
// LinkedList2.java By: Aiman Hanna (C) 1993 - 2020
// This program introduces linked lists structure. The program is 
// similar to LinkedList1.java. However, it shows how to create 
// another copy of a list through a copy constructor and a clone method. 
//
// VERY IMPORTANT: You should notice that a node includes an integer value,
// which is a primitive type. Will the code work if the node has an object 
// instead of a primitive type?? Why, or why not? 
//
// You should notice that the method addAtEnd() has been removed from  
// this program.
// 
// Key Points:
// 1) Linked Lists - Copy Constructor and clone() methods. 
// *******************************************************************

class IntList {
	
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

	public IntList() {
		head = null;
	}

	// copy constructor
	public IntList(IntList lst) {

		if (lst.head == null)
			head = null;
		else {
			head = null; // start with an empty list; then
			// copy the nodes one by one from lst
			Node t1, t2, t3; // create 3 temporary pointers

			t1 = lst.head;
			t2 = t3 = null;

			while (t1 != null) 
			
			{

				if (head == null) // this happens only once
				{
					t2 = new Node(t1.v, null);
					head = t2;
				} else 
				{
					t3 = new Node(t1.v, null);
					t2.next = t3;
					t2 = t3;
				}
				t1 = t1.next;
			}

			t2 = t3 = null; // t1 is already null by now

		}

	}

	public IntList clone() {
		return new IntList(this);
	}

	public void addToStart(int i) {
		Node n = new Node(i, head); 
		head = n; 
		n = null; // Avoid privacy leak

	}
	
	/**
	 * Inserting new node at the end of the linked list
	 * 
	 * @param item - represent the node item to be added to the linked list
	 */
	public void insertNode(int item) {
		Node node = new Node();
		node.v = item;
		Node current = this.head;

		if (this.head == null) {
			this.head = node;
			this.head.next = null;
			System.out.println(this.head.toString());
		} else {

			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
			node.next = null;
		}
	}

	public Node find(int x) {
		if (head == null)
			return null;
		Node t = head;
		while (t != null) {
			if (t.v == x)
				return t; // Is that dangerous ?? See Later
			t = t.next;
		}
		return null; // value was not found in the list
	}

	public boolean insertAfter(int i, int x) {
		
		if (head == null) {
			System.out
					.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
			return false;
		}
		Node t = head;
		while (t != null && t.v != i)
			t = t.next;

		if (t == null) {
			System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
			return false;
		}

		Node n = new Node(x, t.next);
		t.next = n;
		n = null; 
		return true;
	}

	public boolean insertBefore(int i, int x) {
	
		if (head == null) {
			System.out
					.println("\nList is empty. Value " + i + " cannot be found in the list. No insertion is possible");
			return false;
		}

		if (head.v == i) 
		{
			head = new Node(x, head);
			return true;
		}

		Node t = head;
		while (t.next != null && t.next.v != i)
			t = t.next;
		if (t.next == null) {
			System.out.println("\nValue " + i + " was not found in the list. No insertion is possible");
			return false;
		}

		Node n = new Node(x, t.next);
		t.next = n;
		n = null; 
		return true;
	}

	
	public int size() {
		int ctr = 0;
		Node temp = head; 
		while (temp != null) {
			ctr++;
			temp = temp.next;
		}
		return ctr;
	}

	
	public boolean contains(int i) {
		if (find(i) != null)
			return true;
		else
			return false;
	}

	
	public boolean replace(int i1, int i2) {
		Node t = find(i1);
		if (t == null) {
			System.out.println("\nCould not find value " + i1 + " in the list; no replacement is possible.");
			return false;
		}
		t.v = i2;
		return true;
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
	
	// ------------------- my addition --------------//
	
	// this method will delete duplicate from order linked list
	public Node deleteDuplicates() {
	    Node current = this.head;
	    while (current != null && current.next != null) {
	        if (current.next.v == current.v) {
	            current.next = current.next.next;
	        } else {
	            current = current.next;
	        }
	    }
	    return head;
	}
	
	public Node getIntersectionNode(Node headA, Node headB) {
        Node currA = headA, currB = headB;
        while (currA != null  || currB != null) {
            if (currA == currB) return currA;
            currA = (currA == null) ? headB : currA.next;
            currB = (currB == null) ? headA : currB.next;
        }
        return null;
    }
	
	
	public Node partition( int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
		Node head  = this.head;
        Node before_head = new Node();
        Node before = before_head;
        Node after_head = new Node();
        Node after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.v < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }
	
	/*
	 * public ListNode partition(ListNode head, int x) {
		    if (head == null || head.next == null) {
		        return head;
		    }
		    ListNode head1, p1 = new ListNode(0), head2, p2 = new ListNode(0);
		    head1 = p1;
		    head2 = p2;
		    while (head != null) {
		        if (head.val < x) {
		            p1.next = head;
		            p1 = p1.next;
		        } else {
		            p2.next = head;
		            p2 = p2.next;
		        }
		        head = head.next;
		    }
		    p2.next = null;
		    p1.next = head2.next;
		    return head1.next;
		}
	 */
	

	/** * Java method to reverse a linked list without recursion */ 
	public void reverse() { 
		Node pointer = this.head; 
		Node previous = null, current = null; 
			while (pointer != null) 
			{ 
				current = pointer; 
				pointer = pointer.next;  
				current.next = previous; 
				previous = current; 
				head = current; 
			}	
	}
	
	
	public Node oddEvenLinkedList() {
			Node head = this.head;
	        if (head == null) return null;
	        Node odd = head, even = head.next, evenHead = even;
	        while (even != null && even.next != null) {
	            odd.next = even.next;
	            odd = odd.next;
	            even.next = odd.next;
	            even = even.next;
	        }
	        odd.next = evenHead;
	        
	        Node temp = head;
	        System.out.println("\nOdd Even Linked List:.");
	        while (temp != null) {
				System.out.print(temp.v + " ---> ");
				temp = temp.next; 
			}
	        
	        return head;
	    }
	
	// modify code later
	public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        for(ListNode node = root; node != null; node = node.next)
            len++;
        int n = len / k, r = len % k;
        ListNode node = root, prev = null;
        for(int i = 0; node != null && i < k; i++, r--){
            parts[i] = node;
            for(int j = 0; j < n + (r > 0 ? 1 : 0); j++){
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return parts;
    } 
	
	
	public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;
        map.put(prefix, dummy);
        while (head != null) {
            prefix += head.val;
            if (map.containsKey(prefix)) {
                head = map.get(prefix).next;
                int tempPrefix = prefix + head.val;
                while (tempPrefix != prefix) {   // remove the skipped nodes from map
                    map.remove(tempPrefix);
                    head = head.next;
                    tempPrefix += head.val;
                }
                map.get(prefix).next = head.next;
            } else {
                map.put(prefix, head);
            }
            head = head.next;
        }
        return dummy.next;
    }


	

}

public class LinkedList_With_Methods_Professor {

	public static void main(String[] args) {

		IntList lst1 = new IntList();

		lst1.addToStart(18);
		lst1.addToStart(22);
		lst1.addToStart(4);
		lst1.addToStart(7);
		lst1.addToStart(32);
		lst1.addToStart(48);
		lst1.addToStart(18);
		lst1.addToStart(12);
		//lst1.addToStart(32);
		//lst1.addToStart(32);
		lst1.insertNode(333);
		//lst1.insertNode(333);

		System.out.println("\nShowing contents of lst1");
		lst1.showListContents();

		IntList lst2 = lst1.clone();

		System.out.println("\nShowing contents of lst2");
		lst2.showListContents();

		lst2.replace(4, 52);

		lst2.addToStart(98);
		
		lst1.deleteDuplicates();

		System.out.println("\nShowing contents of lst1");
		lst1.showListContents();

		System.out.println("\nShowing contents of lst2 after modifications");
		lst2.showListContents();
		
		lst2.reverse();
		lst2.showListContents();
		lst2.oddEvenLinkedList();
		

	}

}
