package LabExam_2;

import java.util.Scanner;

public class Exam2_Part1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many elements you wish to add to the stack:");
		
		int stackArrSize = sc.nextInt();
		Stack_Integer stack = new Stack_Integer(100);
		System.out.println("Enter the values to initialize the stack:");
		for (int i = 0; i < stackArrSize; i++) {
			stack.push(sc.nextInt());
		}
		
		Stack_Integer stack2 = new Stack_Integer(100);
		System.out.println("Please enter size of the array:");
		int arrSize = sc.nextInt();
		System.out.println("Enter the values of the array:");
		for (int i = 0; i < arrSize; i++) {
			stack2.push(sc.nextInt());
		}
		
		clearAndDisplayMax(stack);
		reverseContent(stack2, arrSize);
		
		sc.close();
		
	}

	

	private static void clearAndDisplayMax(Stack_Integer stack) {
		System.out.println("Clearing the contents of the stack ");
		while(!stack.isEmpty()) {
			
			int maxval = stack.max();
			int popedVal = stack.pop();
			System.out.println("Current MAX value of is " + maxval +". Removing " + popedVal);
		}
		
	}
	
	private static void reverseContent(Stack_Integer stack2, int arrSize) {
		System.out.println();
		System.out.println("Here are the contents of the array after reversing it: ");
		while(!stack2.isEmpty()) {
			if(arrSize != 1)
				System.out.print(stack2.pop() +" ");
			else System.out.println(stack2.pop() +" ");
			arrSize = arrSize - 1;
		}
		
	}

}


class Stack_Integer {
	private int maxSize = 100;
	private int[] stackArray;
	private int top;
	private static int MAX;
	

	public Stack_Integer(int max) {
		this.maxSize = max;
		stackArray = new int[maxSize];
		top = 0;
		MAX = Integer.MIN_VALUE;
	}

	public void push(int item) {
		if (top >= maxSize - 1) {
			System.out.println("Stack already full..");
			return;
		}
		MAX = Math.max(MAX, item);
		
		// increment top then insert item
		stackArray[top++] = item;
	}

	public int pop() {
		if (top < 0) {
			throw new RuntimeException("Stack is Empty");
		}
		MAX =  max();
		return stackArray[--top];
	}

	public int top() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top <= 0);
	}

	public int size() {
		return top + 1;
	}

	public boolean isFull() {
		return (top == maxSize - 1);
	}
	
	public int max() {
		if (top <= 0)
			throw new RuntimeException("Stack is empty");
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < top; i++) {
			if (max < stackArray[i]) {
				max = stackArray[i];
			}
		}
		return max;
	}
}

// 12 18 3 7 22 20 7 4 80 55 192 35 450 18 56
// 90 43 23 76 157 26 11 98 62
