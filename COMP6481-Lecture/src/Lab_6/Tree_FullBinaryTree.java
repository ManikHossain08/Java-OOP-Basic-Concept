package Lab_6;

//Java program to check if binay tree is full or not 

/* Tree node structure */
class Node12 
{ 
	int data; 
	Node12 left, right; 

	Node12(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class Tree_FullBinaryTree 
{ 
	Node12 root; 
	
	/* this function checks if a binary tree is full or not */
	boolean isFullTree(Node12 node) 
	{ 
		// if empty tree 
		if(node == null) 
		return true; 
		
		// if leaf node 
		if(node.left == null && node.right == null ) 
			return true; 
		
		// if both left and right subtrees are not null 
		// the are full 
		if((node.left!=null) && (node.right!=null)) 
			return (isFullTree(node.left) && isFullTree(node.right)); 
		
		// if none work 
		return false; 
	} 

	
	// Driver program 
	public static void main(String args[]) 
	{ 
		Tree_FullBinaryTree tree = new Tree_FullBinaryTree(); 
		tree.root = new Node12(10); 
		tree.root.left = new Node12(20); 
		tree.root.right = new Node12(30); 
		tree.root.left.right = new Node12(40); 
		tree.root.left.left = new Node12(50); 
		tree.root.right.left = new Node12(60); 
		tree.root.left.left.left = new Node12(80); 
		tree.root.right.right = new Node12(70); 
		tree.root.left.left.right = new Node12(90); 
		tree.root.left.right.left = new Node12(80); 
		tree.root.left.right.right = new Node12(90); 
		tree.root.right.left.left = new Node12(80); 
		tree.root.right.left.right = new Node12(90); 
		tree.root.right.right.left = new Node12(80); 
		tree.root.right.right.right = new Node12(90); 
		
		if(tree.isFullTree(tree.root)) 
			System.out.print("The binary tree is full"); 
		else
			System.out.print("The binary tree is not full"); 
	} 
} 

//This code is contributed by Mayank Jaiswal 

/*
 // Java implementation to check whether a binary 
// tree is a full binary tree or not 
import java.util.*; 
class GfG { 

// structure of a node of binary tree 
static class Node { 
	int data; 
	Node left, right; 
} 

// function to get a new node 
static Node getNode(int data) 
{ 
	// allocate space 
	Node newNode = new Node(); 

	// put in the data 
	newNode.data = data; 
	newNode.left = null; 
	newNode.right = null; 
	return newNode; 
} 

// function to check whether a binary tree 
// is a full binary tree or not 
static boolean isFullBinaryTree(Node root) 
{ 
	// if tree is empty 
	if (root == null) 
		return true; 

	// queue used for level order traversal 
	Queue<Node> q = new LinkedList<Node> (); 

	// push 'root' to 'q' 
	q.add(root); 

	// traverse all the nodes of the binary tree 
	// level by level until queue is empty 
	while (!q.isEmpty()) { 
		// get the pointer to 'node' at front 
		// of queue 
		Node node = q.peek(); 
		q.remove(); 

		// if it is a leaf node then continue 
		if (node.left == null && node.right == null) 
			continue; 

		// if either of the child is not null and the 
		// other one is null, then binary tree is not 
		// a full binary tee 
		if (node.left == null || node.right == null) 
			return false; 

		// push left and right childs of 'node' 
		// on to the queue 'q' 
		q.add(node.left); 
		q.add(node.right); 
	} 

	// binary tree is a full binary tee 
	return true; 
} 

// Driver program to test above 
public static void main(String[] args) 
{ 
	Node root = getNode(1); 
	root.left = getNode(2); 
	root.right = getNode(3); 
	root.left.left = getNode(4); 
	root.left.right = getNode(5); 

	if (isFullBinaryTree(root)) 
		System.out.println("Yes"); 
	else
		System.out.println("No"); 
} 
} 


 */

