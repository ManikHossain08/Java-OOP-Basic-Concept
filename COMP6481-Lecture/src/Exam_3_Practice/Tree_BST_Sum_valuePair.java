package Exam_3_Practice;

import java.util.HashSet;
import java.util.Set;

// Data structure to store a Binary Search Tree node
class NodeSum
{
	int data;
	NodeSum left = null, right = null;

	NodeSum(int data) {
		this.data = data;
	}
}

public class Tree_BST_Sum_valuePair
{
	// Recursive function to insert a key into BST
	public static NodeSum insert(NodeSum root, int key)
	{
		// if the root is null, create a new node and return it
		if (root == null) {
			return new NodeSum(key);
		}

		// if given key is less than the root node, recur for left subtree
		if (key < root.data) {
			root.left = insert(root.left, key);
		}

		// if given key is more than the root node, recur for right subtree
		else {
			root.right = insert(root.right, key);
		}

		return root;
	}

	// Function to find a pair with given sum in given BST
	public static boolean findPair(NodeSum root, int sum, Set<Integer> set)
	{
		// base case
		if (root == null) {
			return false;
		}

		// return true if pair is found in the left subtree else continue
		// processing the node
		if (findPair(root.left, sum, set)) {
			return true;
		}

		// if pair is formed with current node, print the pair and return true
		if (set.contains(sum - root.data))
		{
			System.out.print("Pair found (" + (sum - root.data) + ", "
									+ root.data + ")");
			return true;
		}

		// insert current node's value into the set
		else {
			set.add(root.data);
		}

		// search in right subtree
		return findPair(root.right, sum, set);
	}

	public static void main(String[] args)
	{
		int[] keys = { 15, 10, 20, 8, 12, 16, 25 };
		NodeSum root = null;

		for (int key : keys) {
			root = insert(root, key);
		}

		// find pair with given sum
		int sum = 28;

		// create an empty set
		Set<Integer> set = new HashSet<>();

		if (!findPair(root, sum, set)) {
			System.out.print("Pair do not exists");
		}
	}
}
