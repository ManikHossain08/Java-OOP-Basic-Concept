package Stack_Queue;

public class Stack_By_Arrays {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public Stack_By_Arrays(int max) { 
		this.maxSize = max;
		stackArray = new int[maxSize];
		top = -1;
	}

	public void push(int item) {
		if (top >= maxSize - 1) {
			System.out.println("Stack already full..");
			return;
		}
		// increment top then insert item
		stackArray[++top] = item;
	}

	public int pop() {
		if (top < 0) {
			throw new RuntimeException("Stack is Empty");
		}
		// retrieve item then decrement
		return stackArray[top--];
	}

	public int peek() {
		// return top item value
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top < 0);
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}

	public static void main(String[] args) {
		Stack_By_Arrays stack = new Stack_By_Arrays(20);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("Item popped- " + stack.pop());
		System.out.println("Item popped- " + stack.pop());
		
		while (!stack.isEmpty()) {
			System.out.println("popped by loop - " + stack.pop());
		}
	}
}