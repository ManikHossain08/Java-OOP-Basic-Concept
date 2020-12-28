package Exam_3_Practice;

//Java program to print all internal 
//nodes in tree 
import java.util.*;

public class Tree_print_Internal_Nodes {

//A node in the Binary tree 
	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			left = right = null;
			this.data = data;
		}
	}

//Function to print all internal nodes 
//in level order from left to right 
	static void printInternalNodes(Node root) {
		// Using a queue for a level order traversal
		Queue<Node> q = new LinkedList<Node>();  
		q.add(root);
		while (!q.isEmpty()) {

			// Check and pop the element in
			// the front of the queue
			Node curr = q.peek();
			q.remove();

			// The variable flag keeps track of
			// whether a node is an internal node
			boolean isInternal = false;

			// The node has a left child
			if (curr.left != null) {
				isInternal = true;
				q.add(curr.left);
			}

			// The node has a right child
			if (curr.right != null) {
				isInternal = true;
				q.add(curr.right);
			}

			// In case the node has either a left
			// or right child or both print the data
			if (isInternal == true)
				System.out.print(curr.data + " ");
		}
	}

//Driver code 
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.right.right = new Node(10);
		root.right.right.left = new Node(7);
		root.right.left.left = new Node(8);
		root.right.left.right = new Node(9);

		// A call to the function
		printInternalNodes(root);
	}
}
