package Lab_6;

//Java program to find height of tree 

//A binary tree node 
class Node4 
{ 
	int data; 
	Node4 left, right; 

	Node4(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

public class MaxDepth_Tree 
{ 
	Node4 root; 

	/* Compute the "maxDepth" of a tree -- the number of 
	nodes along the longest path from the root node 
	down to the farthest leaf node.*/
	int maxDepth(Node4 node) 
	{ 
		if (node == null) 
			return 0; 
		else
		{ 
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.left); 
			int rDepth = maxDepth(node.right); 

			/* use the larger one */
			if (lDepth > rDepth) 
				return (lDepth + 1); 
			else
				return (rDepth + 1); 
		} 
	} 
	
	/* Driver program to test above functions */
	public static void main(String[] args) 
	{ 
		MaxDepth_Tree tree = new MaxDepth_Tree(); 

		tree.root = new Node4(1); 
		tree.root.left = new Node4(2); 
		tree.root.right = new Node4(3); 
		tree.root.left.left = new Node4(4); 
		tree.root.left.right = new Node4(5); 

		System.out.println("Height of tree is : " + 
									tree.maxDepth(tree.root)); 
	} 
} 

//This code has been contributed by Mayank Jaiswal(mayank_24) 


