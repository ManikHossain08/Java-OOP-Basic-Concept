package Stack_Queue;

public class Circular_Queue_ByArray {
	
	public static void main(String[] args) {
		
		MyCircularQueue circularQueue = new MyCircularQueue(10); // set the size to be 3
		circularQueue.enQueue(1); // return true
		circularQueue.enQueue(2); // return true
		circularQueue.enQueue(3); // return true
		circularQueue.enQueue(4); // return false, the queue is full
		circularQueue.Rear(); // return 3
		circularQueue.isFull(); // return true
		circularQueue.deQueue(); // return true
		circularQueue.enQueue(4); // return true
		circularQueue.Rear(); // return 4
		//////////
		circularQueue.deQueue(); // return true
		circularQueue.deQueue(); // return true
		circularQueue.deQueue(); // return true
		circularQueue.deQueue(); // return true
		circularQueue.deQueue(); // return true
		circularQueue.deQueue(); // return true
	}
}

class MyCircularQueue {

	int length;
	int size = 0;
	int[] queue;
	int front;
	int rear;

	
	public MyCircularQueue(int k) {
		this.length = k;
		queue = new int[k];
		front = 0;
		rear = 0;
	}

	
	public boolean enQueue(int value) {
		if (isFull())
			return false;
		queue[rear] = value;
		rear = (rear + 1) % length;
		size++;
		return true;
	}


	public boolean deQueue() {
		if (isEmpty())
			return false;
		System.out.println(queue[front]);
		front = (front + 1) % length;
		size--;
		return true;
	}


	public int Front() {
		if (isEmpty())
			return -1;
		return queue[front];
	}


	public int Rear() {
		if (isEmpty())
			return -1;
		int idx = rear - 1 >= 0 ? rear - 1 : length - 1;
		return queue[idx];
	}


	public boolean isEmpty() {
		return size == 0;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return size == length;
	}
}
