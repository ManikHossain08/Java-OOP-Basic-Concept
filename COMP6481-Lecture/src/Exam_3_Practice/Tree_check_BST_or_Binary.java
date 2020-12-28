package Exam_3_Practice;

//Java implementation to check if given Binary tree 
//is a BST or not 

/* Class containing left and right child of current 
node and key value*/
class TrrNode  
{ 
	int data; 
	TrrNode left, right; 

	public TrrNode(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class Tree_check_BST_or_Binary 
{ 
	//Root of the Binary Tree 
	TrrNode root; 

	/* can give min and max value according to your code or 
	can write a function to find min and max value of tree. */

	/* returns true if given search tree is binary 
	search tree (efficient version) */
	boolean isBST() { 
		return isBSTUtil(root, Integer.MIN_VALUE, 
							Integer.MAX_VALUE); 
	} 

	/* Returns true if the given tree is a BST and its 
	values are >= min and <= max. */
	boolean isBSTUtil(TrrNode node, int min, int max) 
	{ 
		/* an empty tree is BST */
		if (node == null) 
			return true; 

		/* false if this node violates the min/max constraints */
		if (node.data < min || node.data > max) 
			return false; 

		/* otherwise check the subtrees recursively 
		tightening the min/max constraints */
		// Allow only distinct values 
		return (isBSTUtil(node.left, min, node.data-1) && 
				isBSTUtil(node.right, node.data+1, max)); 
	} 

	/* Driver program to test above functions */
	public static void main(String args[]) 
	{ 
		Tree_check_BST_or_Binary tree = new Tree_check_BST_or_Binary(); 
		tree.root = new TrrNode(4); 
		tree.root.left = new TrrNode(2); 
		tree.root.right = new TrrNode(5); 
		tree.root.left.left = new TrrNode(1); 
		tree.root.left.right = new TrrNode(3); 

		if (tree.isBST()) 
			System.out.println("IS BST"); 
		else
			System.out.println("Not a BST"); 
	} 
} 


