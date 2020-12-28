package Exam_3_Practice;

/*
 * Author : Venkatesh, Thallam
 * Date : 10/09/2017
 * Single Linked List Java Implementation
 */
public class LinkList_head_tail {
	
	class Node{
		int val;
		Node next;
		public Node(int val){
			this.val = val;
		}
	}
	
	Node head = null, tail = null;
	
	public static void main(String[] args) {
		LinkList_head_tail listImpl = new LinkList_head_tail();
		listImpl.addNode(10);
		listImpl.addNode(20);
		listImpl.addNode(30);
		listImpl.addNode(40);
		listImpl.printLinkedList();
		listImpl.addNodeAtStart(50);
		listImpl.printLinkedList();
		listImpl.removeNode();
		listImpl.printLinkedList();
		listImpl.removeNodeAtCertainIndex(3);
		listImpl.printLinkedList();
		
	}
	
	/*
	 * Adds node at the end of the current list
	 */
	public void addNode(int val){
		if(head==null){
			Node temp = new Node(val);
			head = temp;
			tail = temp;
		}else{
			tail.next = new Node(val);
			tail = tail.next;
		}
	}
	
	/*
	 * Adds node at the start of the current list
	 */
	public void addNodeAtStart(int val){
		if(head==null){
			Node temp = new Node(val);
			head = temp;
			tail = temp;
		}else{
			Node temp = new Node(val);
			temp.next = head;
			head = temp;
		}
	}
	
	/*
	 * Adds node at the certain index.
	 */
	public void addNodeAtCertainIndex(int val, int index){
			Node temp = head;
			int count = 0;
			while(temp!=null && ++count!=index)
				temp = temp.next;
			Node node  = new Node(val);
			node.next = temp.next;
			temp.next = node;
	}
	
	/*
	 * Removes the last node in the given list and updates tail node
	 */
	public void removeNode(){
		 Node temp = head;
		 while(temp.next!=null && temp.next.next!=null){
			 temp = temp.next;
		 }
		 temp.next = null;
		 tail = temp;
	}
	
	/*
	 * Removes the first node in the given list and updates head node
	 * 
	 */
	public void removeNodeAtStart(){
		//The first node would become zombie and should be garbage collected after the below operation
		 head = head.next;
	}
	
	/*
	 * Removes the node at the given index in the given list and updates head node
	 * 
	 */
	public void removeNodeAtCertainIndex(int index){
		Node temp = head;
		int count = 0;
		while(temp!=null && ++count!=index)
			temp = temp.next;
		temp.val = temp.next.val;
		temp.next = temp.next.next;
	}
	
	/*
	 * Checks if a node with the given value exist in the list, returns true or false.
	 * Alternatively you can return the index too.
	 */
	public boolean search(int target){
		Node temp = head;
		while(temp!=null){
			if(temp.val == target)
				return true;
		}
		return false;
		
	}
	
	/*
	 * Checks if a node with the given value exist in the list, returns the index of the given value in the list.
	 */
	public int searchAndReturnIndex(int target){
		Node temp = head;
		int count = 0;
		while(temp!=null){
			count++;
			if(temp.val==target) return count;
		}
		return -1;
	}
	
	/*
	 * Prints the current list
	 */
	
	public void printLinkedList(){
		System.out.println();
		Node temp = head;
		while(temp!=null){
			System.out.print(" "+temp.val);
			temp = temp.next;
		}
	}
	

}
