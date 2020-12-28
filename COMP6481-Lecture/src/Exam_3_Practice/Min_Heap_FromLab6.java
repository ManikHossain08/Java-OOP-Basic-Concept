package Exam_3_Practice;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Min_Heap_FromLab6 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		Heap heap = new Heap(n);
		int[] sortedArray = new int[n];

		for (int i = 0; i < n; i++) {

			heap.insert(input.nextInt());
		}

		System.out.println("HEAP BEFORE REMOVALS");
		heap.print();

		for (int i = 0; i < n; i++) {

			int temp = heap.deleteMin();

			sortedArray[i] = temp;
			heap.print();
		}

		Arrays.sort(sortedArray);
		System.out.println("SORTED VALUES");
		for (int i = 0; i < sortedArray.length; i++) {

			System.out.print(sortedArray[i] + " ");
		}

		input.close();
	}

}

class Heap {

	int size;
	private static int d = 2;
	private int[] array;

	public Heap(int capacity) {

		size = 0;
		array = new int[capacity + 1];
		Arrays.fill(array, -1);
	}

	public boolean isEmpty() {

		return size == 0;
	}

	public boolean isFull() {
		return size == array.length;
	}

	public int parent(int i) {
		return i - 1 / d;
	}

	public int kthchild(int i, int k) {

		return d * i + k;
	}

	public int findMin() {
		if (isEmpty()) {
			throw new NoSuchElementException("heap is empty");
		}

		return array[0];
	}

	public int deleteMin() {

		int delItem = array[0];
		delete(0);
		return delItem;
	}

	public int delete(int index) {
		if (isEmpty()) {
			throw new NoSuchElementException("heap is empty");
		}

		int delItem = array[index];
		array[index] = array[size - 1];
		size--;
		heapDwon(index);

		return delItem;

	}

	public void heapDwon(int index) {

		int child;
		int temp = array[index];

		while (kthchild(index, 1) < size) {

			child = minChild(index);
			if (array[child] < temp) {

				array[index] = array[child];
			} else
				break;
			index = child;
		}

		array[index] = temp;
	}

	public int minChild(int index) {

		int bestChild = kthchild(index, 1);
		int k = 2;
		int pos = kthchild(index, k);

		while (k <= d && pos < size) {

			if (array[pos] < array[bestChild])

				bestChild = pos;
			pos = kthchild(index, k++);

		}

		return bestChild;
	}

	public void insert(int x) {

		if (isFull()) {
			throw new NoSuchElementException("heap is full");
		}
		array[size] = x;
		size++;
		heapUp(size - 1);
	}

	public void heapUp(int childIndex) {

		int temp = array[childIndex];

		while (childIndex > 0 && temp < array[parent(childIndex)]) {

			array[childIndex] = array[parent(childIndex)];
			childIndex = parent(childIndex);
		}

		array[childIndex] = temp;
	}

	public void print() {
		for (int i = 0; i < size; i++)
			System.out.print(array[i] + " ");

		System.out.println();
	}
}