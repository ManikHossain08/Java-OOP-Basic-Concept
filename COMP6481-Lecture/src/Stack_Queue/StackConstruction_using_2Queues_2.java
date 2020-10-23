package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;

// https://java2blog.com/implement-stack-using-two-queues-in-java/

public class StackConstruction_using_2Queues_2 {

	Queue<Integer> queue1;
	Queue<Integer> queue2;

	StackConstruction_using_2Queues_2() {
		queue1 = new LinkedList<Integer>();
		queue2 = new LinkedList<Integer>();
	}

	// Remove value from the beginning of the list for demonstrating behavior of
	// stack
	public void push(int i) {
		if (queue1.size() == 0)
			queue1.add(i);
		else {
			int sizeOfQueue1 = queue1.size();
			// Copy elements of Queue1 to Queue2
			for (int j = 0; j < sizeOfQueue1; j++)
				queue2.add(queue1.remove());
			queue1.add(i);
			// Copy elements for Queue2 to Queue1
			for (int k = 0; k < sizeOfQueue1; k++)
				queue1.add(queue2.remove());
		}
	}

	public int pop() {
		if (queue1.size() == 0)
			try {
				throw new Exception("Underflow Exception");
			} catch (Exception e) {
				e.printStackTrace();
			}
		return queue1.remove();
	}

	public static void main(String[] args) {
		StackConstruction_using_2Queues_2 stack = new StackConstruction_using_2Queues_2();
		stack.push(20);
		stack.push(40);
		stack.push(70);
		stack.push(50);
		stack.push(90);
		stack.push(110);
		stack.push(30);
		System.out.println("Removed element : " + stack.pop());
		stack.push(170);
		System.out.println("Removed element : " + stack.pop());
	}
}
