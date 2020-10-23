package Stack_Queue;

import java.util.Deque;
import java.util.LinkedList;


public class QueueConstructions_Using_2Stacks{
	public static void main(String[] args) {
		//Explanation
		ConstructQueue myQueue = new ConstructQueue();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue.peek(); // return 1
		myQueue.pop(); // return 1, queue is [2]
		myQueue.empty(); // return false
	}
}


class ConstructQueue {
    private Deque<Integer> first = new LinkedList<>();
    private Deque<Integer> second = new LinkedList<>();

    public void push(int x) {
        first.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {

        copyTo();

        second.pop();
    }

    // Get the front element.
    public int peek() {

        copyTo();

        return second.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {

        return first.isEmpty() && second.isEmpty();
    }

    private void copyTo() {
        if(second.isEmpty()) {
            while(!first.isEmpty()) {
                second.push(first.pop());
            }
        }
    }
}