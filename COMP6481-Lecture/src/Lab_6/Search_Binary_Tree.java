package Lab_6;


class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2() {
	}

	TreeNode2(int val) {
		this.val = val;
	}

	TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
 
public class Search_Binary_Tree {
	
	public TreeNode2 searchBST(TreeNode2 root, int val) {
        if (root == null) return null;
        if (root.val == val) {
           return root; 
        }
        
        TreeNode2 next = null;
        if (root.val > val) {
            if (root.left != null)
                next = searchBST(root.left, val);
        } else {
            if (root.right !=null)
                next = searchBST(root.right, val);
        }
        
        return next;
    }
}
