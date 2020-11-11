package Lab_6;

//Data structure to store a Binary Tree node
class Node3
{
	int key;
	Node3 left = null, right = null;

	Node3(int key) {
		this.key = key;
	}
}

public class Tree_Height
{
	// Recursive function to calculate height of given binary tree
	public static int height(Node3 root)
	{
		// Base case: empty tree has height 0
		if (root == null) {
			return 0;
		}

		// recur for left and right subtree and consider maximum depth
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public static void main(String[] args)
	{
		Node3 root = null;

		root = new Node3(15);
		root.left = new Node3(10);
		root.right = new Node3(20);
		root.left.left = new Node3(8);
		root.left.right = new Node3(12);
		root.right.left = new Node3(16);
		root.right.right = new Node3(25);

		System.out.print("The height of the binary tree is " + height(root));
	}
}