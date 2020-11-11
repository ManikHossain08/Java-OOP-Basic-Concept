package Lab_6;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lab6_Q2 {
	private int[] Heap;
	private int size;
	private int maxsize;
	private static int COUNTER = 0;
	private static final int FRONT = 1;

	public Lab6_Q2(int maxsize) {
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
		
		COUNTER = size;
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
		List<Integer> sortList= new ArrayList<>();
		
		
		Scanner sc = new Scanner(System.in);
		int inpSize = sc.nextInt();
		Lab6_Q2 minHeap = new Lab6_Q2(inpSize);
		for (int i = 0; i < inpSize; i++) {
			minHeap.add(sc.nextInt());
		}
		
		
		System.out.print("HEAP BEFORE REMOVALS: ");
	
		for (int i = 0; i < COUNTER - 1; i++) {
			minHeap.print();
			sortList.add(minHeap.removeMin()); 
		}
		
		
		System.out.print("SORTED VALUES: ");
		
		for (int i = 0; i < sortList.size(); i++) {
			if(i != sortList.size() - 1) System.out.print(sortList.get(i) + " ");
			else System.out.println(sortList.get(i));
		}

		sc.close();

	}
}

/*
9
7 20 13 29 31 25 22 39 30
 */
