package PracticeLab_5;

import java.util.Stack;

public class LC_856_Score_of_Parentheses {
	
	public static void main(String[] args) {
		System.out.print(scoreOfParentheses("(()(()))"));
	}
	
	
	public static int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(-1);
            } else {
                int cur = 0;
                while (stack.peek() != -1) {
                    cur += stack.pop();
                }
                stack.pop();
                stack.push(cur == 0 ? 1 : cur * 2);
            }
        }
        
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }

}
