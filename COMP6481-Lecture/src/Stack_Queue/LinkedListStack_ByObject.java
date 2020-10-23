package Stack_Queue;

public class LinkedListStack_ByObject {
	private ONode head; // the first node

	// nest class to define linkedlist node
	private class ONode {
		Object value;
		ONode next;
	}

	public LinkedListStack_ByObject() {
		head = null;
	}

	// Remove value from the beginning of the list for demonstrating behaviour of
	// stack
	public Object pop() throws OLinkedListEmptyException {
		if (head == null) {
			throw new OLinkedListEmptyException();
		}
		Object value = head.value;
		head = head.next;
		return value;
	}

	// Add value to the beginning of the list for demonstrating behaviour of stack
	public void push(Object value) {
		ONode oldHead = head;
		head = new ONode();
		head.value = value;
		head.next = oldHead;
	}

	// Utility function to check if the stack is empty or not
	public boolean isEmpty() {
		return head == null;
	}

	// Utility function to return top element in a stack
	public Object peek() {
		// check for empty stack
		if (!isEmpty()) {
			return head.value;
		} else {
			System.out.println("Stack is empty");
			return -1;
		}
	}

	public static void main(String args[]) {

		System.out.println(isValidParenthesis("( )(( )){([( )])}"));
	}

	public static void printList(ONode head) {
		ONode temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	private static boolean isValidParenthesis(String inputs) {

		if (inputs.length() == 1)
			return false;

		LinkedListStack_ByObject parenthesis = new LinkedListStack_ByObject();

		for (int i = 0; i < inputs.length(); i++) {
			String ch = inputs.charAt(i) + "";
			if(ch.contentEquals(" ")) continue;
			if (ch.contentEquals("("))
				parenthesis.push(")");
			else if (ch.contentEquals("{"))
				parenthesis.push("}");
			else if (ch.contentEquals("["))
				parenthesis.push("]");
			else if (parenthesis.isEmpty())
				return false;
			else if (!parenthesis.pop().toString().contentEquals(ch))
				return false;
		}

		return parenthesis.isEmpty();
	}
}

/**
 * 
 * Exception to indicate that LinkedList is empty.
 */

class OLinkedListEmptyException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OLinkedListEmptyException() {
		super();
	}

	public OLinkedListEmptyException(String message) {
		super(message);
	}
}
