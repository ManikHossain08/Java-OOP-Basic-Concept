package Lab08;

import java.util.Scanner;

class BST {

	class Node {
		int value;
		Node left, right;
		// add parent for getting the parent all the time

		public Node(int item) {
			value = item;
			left = right = null;
		}
	}

	Node root;
	Node parent;

	BST() {
		root = null;
	}

	public void insert(int key) {
		root = insertRec(root, key);
	}

	public Node insertRec(Node root, int key) {

		if (root == null) {
			root = new Node(key);
			return root;
		}

		if (key < root.value)
			root.left = insertRec(root.left, key);
		else if (key > root.value)
			root.right = insertRec(root.right, key);

		return root;
	}

	public int  parentOf(int val) {
		return findParent(root, val, -1);
	}
	
	static int findParent(Node node, int val, int parent) {
		if (node == null)
			return -1;
		
		if (node.value == val) {
			System.out.println("Parent of " + val + " is " + parent);
			return parent;
		} else {
			findParent(node.left, val, node.value);
			findParent(node.right, val, node.value);
		}
		return parent;
	}
}

public class UseBST {
	public static void main(String[] args) {
		int y;

		BST b1 = new BST();

		System.out.println("Enter a value to add to the tree or -1 to terminate: ");
		int v;
		Scanner kb = new Scanner(System.in);

		v = kb.nextInt();
		while (v != -1) {
			b1.insert(v);
			b1.parentOf(v);
			v = kb.nextInt();
		}

		y = b1.parentOf(126);
		if (y == -1)
			System.out.println("No Parent exists");
		else
			System.out.println("Parent of 126 is " + y);
		
		kb.close();

	}
}
