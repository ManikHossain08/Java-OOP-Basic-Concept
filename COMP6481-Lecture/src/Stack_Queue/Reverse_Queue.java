package Stack_Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_Queue {
	static Queue<Integer> queue;

	// Utility function to print the queue
	static void Print( Queue<Integer> queue) {
		while (!queue.isEmpty()) {
			System.out.print(queue.peek() + ", ");
			queue.remove();
		}
	}

	// Function to reverse the queue
	static void reversequeue() {
		Stack<Integer> stack = new Stack<>();
		while (!queue.isEmpty()) {
			stack.add(queue.peek());
			queue.remove();
		}
		while (!stack.isEmpty()) {
			queue.add(stack.peek());
			stack.pop();
		}
	}

	// Recurrsive function to reverse the queue 
	static Queue<Integer> reverseQueue_Recursion(Queue<Integer> q) 
	{ 
	    // Base case 
	    if (q.isEmpty()) 
	        return q; 
	  
	    // Dequeue current item (from front)   
	    int data = q.peek(); 
	    q.remove(); 
	  
	    // Reverse remaining queue   
	    q = reverseQueue_Recursion(q); 
	  
	    // Enqueue current item (to rear)   
	    q.add(data); 
	          
	    return q; 
	} 
	
	
	// Driver code
	public static void main(String args[]) {
		queue = new LinkedList<Integer>();
		queue.add(10);
		queue.add(20);
		queue.add(30);
		queue.add(40);
		queue.add(50);
		queue.add(60);
		queue.add(70);
		queue.add(80);
		queue.add(90);
		queue.add(100);
		

		for (Integer val : queue) {
			System.out.print(val +", ");
		}
		System.out.println();

		reversequeue();
		Print(queue);
		
		Queue<Integer> orgQueue = new LinkedList<Integer>();
		orgQueue.add(10);
		orgQueue.add(20);
		orgQueue.add(30);
		orgQueue.add(40);
		orgQueue.add(50);
		orgQueue.add(60);
		orgQueue.add(70);
		orgQueue.add(80);
		orgQueue.add(90);
		orgQueue.add(100);
		
		Queue<Integer> revQueue = reverseQueue_Recursion(orgQueue);
		System.out.println();
		Print(revQueue);
	}
	
	
}
