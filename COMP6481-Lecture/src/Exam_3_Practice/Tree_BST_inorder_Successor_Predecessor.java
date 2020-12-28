package Exam_3_Practice;

//Java program to find predecessor 
//and successor in a BST 
public class Tree_BST_inorder_Successor_Predecessor{ 

//BST Node 
static class Node 
{ 
	int key; 
	Node left, right; 

	public Node() 
	{} 

	public Node(int key) 
	{ 
		this.key = key; 
		this.left = this.right = null; 
	} 
}; 

static Node pre = new Node(), suc = new Node(); 

//This function finds predecessor and 
//successor of key in BST. It sets pre 
//and suc as predecessor and successor 
//respectively 
static void findPreSuc(Node root, int key) 
{ 
	
	// Base case 
	if (root == null) 
		return; 

	// If key is present at root 
	if (root.key == key) 
	{ 
		
		// The maximum value in left 
		// subtree is predecessor 
		if (root.left != null) 
		{ 
			Node tmp = root.left; 
			while (tmp.right != null) 
				tmp = tmp.right; 
				
			pre = tmp; 
		} 

		// The minimum value in 
		// right subtree is successor 
		if (root.right != null) 
		{ 
			Node tmp = root.right; 
			
			while (tmp.left != null) 
				tmp = tmp.left; 
				
			suc = tmp; 
		} 
		return; 
	} 

	// If key is smaller than 
	// root's key, go to left subtree 
	if (root.key > key) 
	{ 
		suc = root; 
		findPreSuc(root.left, key); 
	} 
	
	// Go to right subtree 
	else
	{ 
		pre = root; 
		findPreSuc(root.right, key); 
	} 
} 

//A utility function to insert a 
//new node with given key in BST 
static Node insert(Node node, int key) 
{ 
	if (node == null) 
		return new Node(key); 
	if (key < node.key) 
		node.left = insert(node.left, key); 
	else
		node.right = insert(node.right, key); 
		
	return node; 
} 

//Driver code 
public static void main(String[] args) 
{ 
	
	// Key to be searched in BST 
	int key = 65; 

	/* 
	* Let us create following BST 
	*		 50 
	*		 / \ 
	*	 30 70 
	*	 / \ / \ 
	*	 20 40 60 80 
	*/

	Node root = new Node(); 
	root = insert(root, 50); 
	insert(root, 30); 
	insert(root, 20); 
	insert(root, 40); 
	insert(root, 70); 
	insert(root, 60); 
	insert(root, 80); 

	findPreSuc(root, key); 
	if (pre != null) 
		System.out.println("Predecessor is " + pre.key); 
	else
		System.out.println("No Predecessor"); 

	if (suc != null) 
		System.out.println("Successor is " + suc.key); 
	else
		System.out.println("No Successor"); 
} 
} 

//This code is contributed by sanjeev2552


