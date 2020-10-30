package Exam_2_Practice;

public class Prioritty_Queue_String {
	public static void main(String args[]) {
		EntryStr entry = new EntryStr(100);
		entry.insert("Ram");
		entry.insert("Ram");
		entry.insert("Shyam");
		entry.insert("AAC");
		entry.insert("a");
		entry.insert("ABC");
		entry.insert("AA");
		entry.insert("b");
		entry.insert("css");
		
		System.out.println(entry.max());
		System.out.println(entry.min());
		System.out.println(entry.size());
		System.out.println("-------------");
		
		while (!entry.isEmpty()) {
			System.out.println(entry.removeFirst());
		}
//		entry.insert("css");
//		entry.insert("AA");
//		entry.insert("b");
//		
//		while (!entry.isEmpty()) {
//			System.out.println(entry.removeFirst());
//		}
		
		
	}
}

class EntryStr {
	private static int size;
	private static String[] A = null;
	private static int key;

	EntryStr(int length) {
		size = 0;
		A = new String[length];
		key = 0;
	}

	public void insert(String e) {
		if (size >= A.length)
			throw new RuntimeException("Priority Queue is full");
		A[key++] = e;
		size++;
	}

	public String removeFirst() {
		if (size <= 0)
			throw new RuntimeException("Priority Queue is empty");

		String minStr = A[0];
		int index = 0;
		for (int i = 1; i < size; i++) {
			if (stringCompareTo(minStr, A[i]) >= 0) {
				index = i;
				minStr = A[i];
			}
		}

		A[index] = A[size - 1];
		A[size - 1] = null;
		size--;
		key = size;

		return minStr;
	}
	
	public String min() {
		if (size <= 0)
			throw new RuntimeException("Priority Queue is empty");

		String minStr = A[0];
		for (int i = 1; i < size; i++) {
			if (stringCompareTo(minStr, A[i]) >= 0) {
				minStr = A[i];
			}
		}

		return minStr;
	}
	
	
	public String removeLast() {
		if (size <= 0)
			throw new RuntimeException("Priority Queue is empty");

		String maxStr = A[0];
		int index = 0;
		for (int i = 1; i < size; i++) {
			if (stringCompareTo(maxStr, A[i]) <= 0) {
				index = i;
				maxStr = A[i];
			}
		}

		A[index] = A[size - 1];
		A[size - 1] = null;
		size--;
		key = size;

		return maxStr;
	}
	
	public String max() {
		if (size <= 0)
			throw new RuntimeException("Priority Queue is empty");

		String maxStr = A[0];
		for (int i = 1; i < size; i++) {
			if (stringCompareTo(maxStr, A[i]) <= 0) {
				maxStr = A[i];
			}
		}

		return maxStr;
	}
	

	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}

	public static int stringCompareTo(String str1, String str2) {
		for (int i = 0; i < str1.length() && i < str2.length(); i++) {
			if ((int) str1.charAt(i) == (int) str2.charAt(i)) {
				continue;
			} else {
				return (int) str1.charAt(i) - (int) str2.charAt(i);
			}
		}

		if (str1.length() < str2.length()) {
			return (str1.length() - str2.length());
		} else if (str1.length() > str2.length()) {
			return (str1.length() - str2.length());
		}

		else {
			return 0;
		}
	}

}
