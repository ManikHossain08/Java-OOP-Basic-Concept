package PracticeLab_5;

import java.util.Stack;

// Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 8 -> 0 -> 7

public class LC_445_Add_Two_Numbers_II {

	public static void main(String[] args) {
		ListNode l1 = new ListNode();
		ListNode l2 = new ListNode();
		System.out.print(addTwoNumbers(l1, l2));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();

		while (l1 != null) {
			s1.push(l1.val);
			l1 = l1.next;
		}
		
		while (l2 != null) {
			s2.push(l2.val);
			l2 = l2.next;
		}

		int sum = 0;
		ListNode list = new ListNode(0);
		while (!s1.empty() || !s2.empty()) {
			if (!s1.empty())
				sum += s1.pop();
			if (!s2.empty())
				sum += s2.pop();
			list.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			head.next = list;
			list = head;
			sum /= 10;
		}

		return list.val == 0 ? list.next : list;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
