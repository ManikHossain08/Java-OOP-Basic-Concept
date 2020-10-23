package Stack_Queue;


public class LinkedListStack {
	private Node head; // the first node

	// nest class to define linkedlist node
	private class Node {
		int value;
		Node next;
	}

	public LinkedListStack() {
		head = null;
	}

	// Remove value from the beginning of the list for demonstrating behaviour of
	// stack
	public int pop() throws LinkedListEmptyException {
		if (head == null) {
			throw new LinkedListEmptyException();
		}
		int value = head.value;
		head = head.next;
		return value;
	}

	// Add value to the beginning of the list for demonstrating behaviour of stack
	public void push(int value) {
		Node oldHead = head;
		head = new Node();
		head.value = value;
		head.next = oldHead;
	}

	// Utility function to check if the stack is empty or not
	public boolean isEmpty() {
		return head == null;
	}

	// Utility function to return top element in a stack
	public int peek() {
		// check for empty stack
		if (!isEmpty()) {
			return head.value;
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public static void main(String args[]) {
		LinkedListStack lls = new LinkedListStack();
		System.out.println("Element isempty from LinkedList: " + lls.isEmpty());
		lls.push(20);
		lls.push(50);
		System.out.println("Element peek from LinkedList: " + lls.peek());
		System.out.println("Element isempty from LinkedList: " + lls.isEmpty());
		lls.push(80);
		lls.push(40);
		lls.push(60);
		lls.push(75);
		System.out.println("Element peek from LinkedList: " + lls.peek());
		System.out.println("Element removed from LinkedList: " + lls.pop());
		System.out.println("Element removed from LinkedList: " + lls.pop());
		lls.push(10);
		System.out.println("Element removed from LinkedList: " + lls.pop());
		printList(lls.head);
		
		System.out.println(isValidParenthesis("({[ ])}"));
	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	private static boolean isValidParenthesis(String inputs) {

		if (inputs.length() == 1)
			return false;

		//Stack<Character> parenthesis = new Stack<Character>();
		LinkedListStack parenthesis = new LinkedListStack();

		for (int i = 0; i < inputs.length(); i++) {
			char ch = inputs.charAt(i);
			if (ch == '(')
				parenthesis.push(')');
			else if (ch == '{')
				parenthesis.push('}');
			else if (ch == '[')
				parenthesis.push(']');
			else if (parenthesis.isEmpty())
				return false;
			else if (parenthesis.pop() != ch)
				return false;
		}

		return parenthesis.isEmpty();
	}
}

/**
 * 
 * Exception to indicate that LinkedList is empty.
 */

class LinkedListEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LinkedListEmptyException() {
		super();
	}

	public LinkedListEmptyException(String message) {
		super(message);
	}
}
