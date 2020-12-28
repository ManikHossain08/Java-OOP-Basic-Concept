package Exam_3_Practice;

//Java implementation of the approach
public class Tree_BST_Methods {

	/*
	 * A binary tree node has data, pointer to left child and a pointer to right
	 * child
	 */
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			left = right = null;
		}
	};

//Recursive function to find the
//parent of the given node
	static void findParent(Node node, int val, int parent) {
		if (node == null)
			return;

		// If current node is the required node
		if (node.data == val) {

			// Print its parent
			System.out.print(parent);
		} else {

			// Recursive calls for the children
			// of the current node
			// Current node is now the new parent
			findParent(node.left, val, node.data);
			findParent(node.right, val, node.data);
		}
	}

//Driver code
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		int node = 4;

		findParent(root, node, -1);
	}
}
