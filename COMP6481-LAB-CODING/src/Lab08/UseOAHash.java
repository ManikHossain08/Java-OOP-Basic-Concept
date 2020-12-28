package Lab08;

import java.util.Scanner;

class HashEntry {
	int key;
	int value;

	HashEntry(int key, int value) {
		this.key = key;
		this.value = value;
	}
}

class OAHash {
	private int TABLE_SIZE;
	private int size;
	private HashEntry[] table;
	private int primeSize;

	public OAHash() {
		size = 0;
		TABLE_SIZE = 19;
		table = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
		primeSize = getPrime();
	}

	public int getPrime() {
		return 13;
	}

	public void tableExpansion() {
		TABLE_SIZE = 41;
		HashEntry[] newtable = new HashEntry[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (i < 19) {
				newtable[i] = table[i];
			} else
				newtable[i] = null;
		}
		primeSize = getPrime();
		table = new HashEntry[TABLE_SIZE];
		table = newtable;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void makeEmpty() {
		size = 0;
		for (int i = 0; i < TABLE_SIZE; i++)
			table[i] = null;
	}

	public int get(int key) {
		int hash1 = myhash1(key);
		int hash2 = myhash2(key);

		while (table[hash1] != null && table[hash1].key != key) {
			hash1 += hash2;
			hash1 %= TABLE_SIZE;
		}
		return table[hash1].value;
	}

	public void insert(int key, int value) {
		if (size == TABLE_SIZE) {
			System.out.println("Table full");
			return;
		}
		int hash1 = myhash1(key);
		int hash2 = myhash2(key);
		int collutions = 0;
		while (table[hash1] != null) {
			System.out.println("Collision Occurred at index " + hash1);
			hash1 += hash2;
			hash1 %= TABLE_SIZE;
			collutions++;

		}
		table[hash1] = new HashEntry(key, value);
		System.out.println("Key " + key + " is inserted at index " + hash1);
		System.out.println("Insertion of " + key + " resulted in " + collutions + " Collisions");
		size++;
	}

	private int myhash1(int val) {
		return val % TABLE_SIZE;
	}

	private int myhash2(int x) {
		return primeSize - x % primeSize;
	}

	public void printHashTable() {

		for (int i = 0; i < TABLE_SIZE - 1; i++) {
			if (table[i] != null)
				System.out.print(table[i].key + ", ");
			else
				System.out.print("-1, ");
		}

		if (table[TABLE_SIZE - 1] != null)
			System.out.print(table[TABLE_SIZE - 1].key + ".\n");
		else
			System.out.print("-1.\n");

	}
}

public class UseOAHash {
	public static void main(String[] args) {

		int v;
		Scanner kb = new Scanner(System.in);
		OAHash ht = new OAHash();
		System.out.println("Enter a positive value that you want to insert in the hash table; or -1 to terminate:");
		v = kb.nextInt();
		boolean isExpanded = false;
		while (v != -1) {
			if (isExpanded == false) {
				if ((ht.getSize()) / 19.0 >= 0.73) {
					System.out.println("Load Factor is about to exceed 75%. Expanding table. ");
					System.out.println("Contents of table before expansion is as follows: ");
					ht.printHashTable();
					ht.tableExpansion();
					isExpanded = true;
				}
			}
			ht.insert(v, v);
			v = kb.nextInt();
		}
		ht.printHashTable();
		kb.close();
	}
}
/*
public void tableExpansion() {
	TABLE_SIZE = 41;
	table = new HashEntry[41];
	for (int i = 0; i < TABLE_SIZE; i++) {
		if (i < 19) {
			 insert(table[i].value, table[i].value);
		} else
			table[i] = null;
	}
	primeSize = getPrime();
}*/