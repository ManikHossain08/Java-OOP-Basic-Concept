package Stack_Queue;

public class Queue_By_Array {

	public static void main(String[] args) {

		try {
			MyQueue queue = new MyQueue();

			//System.out.println(queue.dequeue());
			queue.enqueue("1");
			System.out.println(queue.dequeue());

			queue.enqueue("2");
			queue.enqueue("3");
			queue.enqueue("4");
			System.out.println(queue.dequeue());

			queue.enqueue("5");
			queue.enqueue("6");
			queue.enqueue("7");
			System.out.println(queue.dequeue());
			 queue.enqueue("8");
			 
			//System.out.println(MyQueue.DEFAULT_SIZE);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

class MyQueue {
	
	public static final int DEFAULT_SIZE = 5;
	private Object data[];
	private int index;

	public MyQueue() {
		data = new Object[DEFAULT_SIZE];
	}

	public MyQueue(int size) {
		data = new Object[size];
	}

	public boolean isEmpty() {
		return index == 0;
	}

	public void enqueue(Object obj) throws Exception {
		if (index == data.length) {
			throw new Exception("Queue is full. Dequeue some objects");
		}
		this.data[index] = obj;
		this.index++;
	}

	public Object dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is empty");
		Object obj = this.data[0];
		for (int i = 0; i < this.index - 1; i++) {
			data[i] = data[i + 1];
		}
		this.index--;
		return obj;
	}
}