package LinkedList_Lab_7;

import java.util.ArrayList;

public class SortedLListToBST {

}


//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

 //  Definition for a binary tree node.
   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 

class Solution {
    public TreeNode construct(ArrayList<Integer> list, int start, int end){
        if(start > end) return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = construct(list, start, mid-1);
        root.right = construct(list, mid+1, end);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }  
        return construct(list, 0, list.size()-1);
    }
}