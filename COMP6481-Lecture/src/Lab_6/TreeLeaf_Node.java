package Lab_6;

import java.util.Stack;

public class TreeLeaf_Node {

		  public static void main(String[] args) throws Exception {

		    // let's create a binary tree
		    BinaryTree bt = new BinaryTree();
		    bt.root = new BinaryTree.TreeNode("a");
		    bt.root.left = new BinaryTree.TreeNode("b");
		    bt.root.right = new BinaryTree.TreeNode("f");
		    bt.root.left.left = new BinaryTree.TreeNode("c");
		    bt.root.left.right = new BinaryTree.TreeNode("e");
		    bt.root.left.left.left = new BinaryTree.TreeNode("d");
		    bt.root.right.left = new BinaryTree.TreeNode("g");
		    bt.root.right.right = new BinaryTree.TreeNode("h");
		    bt.root.right.right.right = new BinaryTree.TreeNode("k");

		    // count all leaf nodes of binary tree using recursion
		    System.out
		        .println("total number of leaf nodes of binary tree in Java (recursively)");
		    System.out.println(bt.countLeafNodesRecursively());

		    // count all leaf nodes of binary tree without recursion
		    System.out
		        .println("count of leaf nodes of binary tree in Java (iteration)");
		    System.out.println(bt.countLeafNodes());

		  }

		}

		class BinaryTree {
		  static class TreeNode {
		    String value;
		    TreeNode left, right;

		    TreeNode(String value) {
		      this.value = value;
		      left = right = null;
		    }

		    boolean isLeaf() {
		      return left == null ? right == null : false;
		    }

		  }

		  // root of binary tree
		  TreeNode root;

		  /**
		   * Java method to calculate number of leaf node in binary tree.
		   * 
		   * @param node
		   * @return count of leaf nodes.
		   */
		  public int countLeafNodesRecursively() {
		    return countLeaves(root);
		  }

		  private int countLeaves(TreeNode node) {
		    if (node == null)
		      return 0;

		    if (node.isLeaf()) {
		      return 1;
		    } else {
		      return countLeaves(node.left) + countLeaves(node.right);
		    }
		  }

		  /**
		   * Java method to count leaf nodes using iteration
		   * 
		   * @param root
		   * @return number of leaf nodes
		   * 
		   */
		  public int countLeafNodes() {
		    if (root == null) {
		      return 0;
		    }

		    Stack<TreeNode> stack = new Stack<>();
		    stack.push(root);
		    int count = 0;

		    while (!stack.isEmpty()) {
		      TreeNode node = stack.pop();
		      if (node.left != null)
		        stack.push(node.left);
		      if (node.right != null)
		        stack.push(node.right);
		      if (node.isLeaf())
		        count++;
		    }

		    return count;

		  }
		}
