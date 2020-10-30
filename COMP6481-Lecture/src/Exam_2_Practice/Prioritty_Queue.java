package Exam_2_Practice;

public class Prioritty_Queue {
	public static void main(String args[]) {
		Entry entry = new Entry(100);
		entry.insert(10);
		entry.insert(20);
		entry.insert(2);
		entry.insert(10);
		entry.insert(0);
		entry.insert(100);
		entry.insert(30);
		entry.insert(15);
		entry.insert(200);
		entry.insert(3);
		
		System.out.println(entry.min());
		System.out.println(entry.max());
		System.out.println(entry.size());
		
		System.out.println("-------------");
		
		while (!entry.isEmpty()) {
			System.out.println(entry.removeFirst());
		}
		
		
		//entry.removeFirst();
		//System.out.println(StringComparator.compare("Manik", "Hossain"));
	}
}

class Entry {
	private static int size;
	private static int[] A = null;
	private static int key;

	Entry(int length) {
		size = 0;
		A = new int[length];
		key = 0;
	}

	public void insert(int e) {
		if (size >= A.length)
			throw new RuntimeException("Priority Queue is full");
		A[key++] = e;
		size++;
	}

	public int removeFirst() {
		if (size <= 0)
			throw new RuntimeException("Priority Queue is empty");
		
		int min = Integer.MAX_VALUE;
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (min > A[i]) {
				index = i;
				min = A[i];
			}
		}

		A[index] = A[size - 1];
		A[size - 1] = 0;
		size--;
		key = size;

		return min;
	}
	
	public int min() {
		if (size <= 0)
			throw new RuntimeException("Priority Queue is empty");
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < size; i++) {
			if (min > A[i]) {
				min = A[i];
			}
		}

		return min;
	}
	
	
	public int removeLast() {
		if (size <= 0)
			throw new RuntimeException("Priority Queue is empty");
		
		int max = Integer.MIN_VALUE;
		int index = 0;
		for (int i = 0; i < size; i++) {
			if (max < A[i]) {
				index = i;
				max = A[i];
			}
		}

		A[index] = A[size - 1];
		A[size - 1] = 0;
		size--;
		key = size;

		return max;
	}
	
	public int max() {
		if (size <= 0)
			throw new RuntimeException("Priority Queue is empty");
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < size; i++) {
			if (max < A[i]) {
				max = A[i];
			}
		}
		return max;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}

}

