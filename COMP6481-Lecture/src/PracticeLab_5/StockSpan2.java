package PracticeLab_5;

public class StockSpan2 {

	private int arr[] = { 60, 30, 40, 50, 20, 70, 30, 80, 20 };

	public void getSpan() {

		ArraysStack s = new ArraysStack(9);
		s.push(0);
		int stockSpanRes[] = new int[arr.length];
		stockSpanRes[0] = 1;

		for (int i = 1; i < arr.length; i++) {
			while (!s.isEmpty() && arr[s.peek()] <= arr[i]) {
				s.pop();
			}
			stockSpanRes[i] = s.isEmpty() ? (i + 1) : (i - s.peek());
			s.push(i);
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(stockSpanRes[i]);
		}
	}

	public static void main(String[] args) {
		StockSpan2 s = new StockSpan2();
		s.getSpan();

	}

}

class ArraysStack {
	private int maxSize;
	private int[] stackArray;
	private int top;

	public ArraysStack(int max) {
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
}
