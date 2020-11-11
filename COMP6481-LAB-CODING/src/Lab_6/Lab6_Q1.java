package Lab_6;

import java.util.Scanner;

public class Lab6_Q1 {
	private int[] Heap;
	private int size;
	private int maxsize;

	private static final int FRONT = 1;

	public Lab6_Q1(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	private void swaping(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	private void getMinHeap(int pos) { 

		if (!isLeaf(pos)) {
			if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {

				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
					swaping(pos, leftChild(pos)); 
					getMinHeap(leftChild(pos));
				} else {
					swaping(pos, rightChild(pos));
					getMinHeap(rightChild(pos));
				}
			}
		}
	}

	public void add(int element) {
		if (size >= maxsize) {
			return;
		}
		Heap[++size] = element;
		int current = size;

		while (Heap[current] < Heap[parent(current)]) {
			swaping(current, parent(current));
			current = parent(current);
		}
	}

	public void print() {
		for (int i = 1; i <= size; i++) {
			if(i != size) System.out.print(Heap[i] + " ");
			else System.out.println(Heap[i]);
		}
	}

	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			getMinHeap(pos);
		}
	}

	public int removeMin() {
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		getMinHeap(FRONT);
		return popped;
	}

	public static void main(String[] arg) {
		Lab6_Q1 minHeap = new Lab6_Q1(100);

		Scanner sc = new Scanner(System.in);
		int inpSize = sc.nextInt();
		for (int i = 0; i < inpSize; i++) {
			minHeap.add(sc.nextInt());
		}
		int addval = sc.nextInt();
		System.out.println("Add value:");
		System.out.print("HEAP BEFORE ADD: ");
		minHeap.print();

		minHeap.add(addval);
		System.out.print("HEAP AFTER ADD: ");
		minHeap.print();

		System.out.println("Min: " + minHeap.removeMin());

		System.out.print("HEAP AFTER REMOVE:");
		minHeap.print();

		sc.close();

	}
}

/*
8 
7 20 13 30 31 25 22 39 
29
 */
