package Lab_6;


	class Node2 {
		  int item;
		  Node2 left, right;

		  public Node2(int key) {
		  item = key;
		  left = right = null;
		  }
		}

	public	class Preorder_Tree_Traversal {
		  // root of Tree
		  Node2 root;

		  Preorder_Tree_Traversal() {
		  root = null;
		  }

		  void preorder(Node2 node) {
		    if (node == null)
		      return;

		    // traverse the root node
		    System.out.print(node.item + "->");
		    // traverse the left child
		    preorder(node.left);
		    // traverse the right child
		    preorder(node.right);
		  }

		  public static void main(String[] args) {
		    // create object of tree
		    Preorder_Tree_Traversal tree = new Preorder_Tree_Traversal();

		    // create nodes of the tree
		    tree.root = new Node2(1);
		    tree.root.left = new Node2(12);
		    tree.root.right = new Node2(9);
		    tree.root.left.left = new Node2(5);
		    tree.root.left.right = new Node2(6);

		    // preorder tree traversal
		    System.out.println("\nPreorder traversal ");
		    tree.preorder(tree.root);
		  }
		}
