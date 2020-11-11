package Lab_6;

import java.util.Scanner;

public class Lab6_Q3 {

	static class HashTable {

		private final static int TABLE_SIZE = 13;
		private static int chainSize = 13;
		public static LinkedHashEntry[] table;

		HashTable() {
			table = new LinkedHashEntry[TABLE_SIZE];
			chainSize = 13;
			for (int i = 0; i < TABLE_SIZE; i++)
				table[i] = null;
		}
		
		private int hashValue(int value) {
			return ((4 * value) + 7) % TABLE_SIZE;
		}

		private void hashAndAdd(int value) {
			int hash = hashValue(value);
			if (table[hash] == null)
				table[hash] = new LinkedHashEntry(value, 1);
			else {
				LinkedHashEntry entry = table[hash];
				entry.setValue(entry.getValue() + 1);
			}
		}
		

	}

	public static void main(String[] args) {
		HashTable hp = new HashTable();
		
		Scanner sc = new Scanner(System.in);
		int inpSize = sc.nextInt();
		for (int i = 0; i < inpSize; i++) {
			hp.hashAndAdd(sc.nextInt());
		}
		
		LinkedHashEntry[] hashTable = HashTable.table;
		 int maxCollution =  0;
		 int colIndex = -1;
		 
		for (int i = 0; i < hashTable.length; i++) {
			if(hashTable[i] != null && maxCollution < hashTable[i].getValue() && hashTable[i].getValue() >=2 ) {
				LinkedHashEntry entry = hashTable[i];
				maxCollution = entry.getValue();
				colIndex = i;
				}
			}
		
		 System.out.println("MAX COLLISIONS: " + maxCollution);
		 System.out.println("MAX COLLISIONS INDEX: " + colIndex);
		 sc.close();
	}

}

class LinkedHashEntry {
	private int key;
	private int value;
	private LinkedHashEntry next;

	LinkedHashEntry(int key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getKey() {
		return key;
	}

	public LinkedHashEntry getNext() {
		return next;
	}

	public void setNext(LinkedHashEntry next) {
		this.next = next;
	}
}

/*
7
13 26 6 7 52 101 99

13
1 2 3 4 5 6 7 8 9 10 11 12 13

 */

