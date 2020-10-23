package PracticeLab_5;

import java.util.Stack;

public class ArithmeticExpression {
	
	public static int evaluate(String expression) {
		
		char[] tokens = expression.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> ops = new Stack<Character>();

		for (int i = 0; i < tokens.length; i++) {
			
			if (tokens[i] == ' ') continue;

			if (Character.isDigit(tokens[i])) {
			//if (tokens[i] >= '0' && tokens[i] <= '9') {
				
				StringBuffer sbuf = new StringBuffer();
				
				while (i < tokens.length && Character.isDigit(tokens[i]))
				//while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
					sbuf.append(tokens[i++]);
				values.push(Integer.parseInt(sbuf.toString()));
				i--;
			}

			else if (tokens[i] == '(')
				ops.push(tokens[i]);

			else if (tokens[i] == ')') {
				while (ops.peek() != '(')
					values.push(applyOp(values.pop(),ops.pop(), values.pop()));
				ops.pop();
			}

			else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

				while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) {
						values.push(applyOp( values.pop(), ops.pop(), values.pop()));
					}

				ops.push(tokens[i]);
			}
		}

		while (!ops.empty())
			values.push(applyOp( values.pop(), ops.pop(), values.pop()));

		return values.pop();
	}

	public static boolean hasPrecedence(char current, char old) {
		if (old == '(' || old == ')')
			return false;
		if ((current == '*' || current == '/') && (old == '+' || old == '-'))
			return false;
		else
			return true;
	}

	public static int applyOp( int b, char op, int a) {
		switch (op) {
		case '+':
			return a + b;
		case '-':
			return a - b;
		case '*':
			return a * b;
		case '/':
			if (b == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return a / b;
		}
		return 0;
	}

	public static void main(String[] args) {
		String expr = "5 * ( 6 + 2 ) - 12 / 4";
		String[] eqOP = {"<", ">", "=", ">=", "<="};
		String left = "", right = "";
		String[] splitVal = {};
		String whichOP = null;
		for (int i = 0; i < eqOP.length; i++) {
			if(expr.contains(eqOP[i])) {
				splitVal = expr.split(eqOP[i]);
				left = splitVal[0].strip();
				right = splitVal[1].strip();
				whichOP = eqOP[i];
			}
		}
			
		
		if(splitVal.length == 0)
		System.out.println(ArithmeticExpression.evaluate(expr));
		else {
			System.out.println(isEqualitymatch(left, right, whichOP, eqOP));
		}
	}

	private static  boolean isEqualitymatch(String left, String right, String whichOP, String[] eqOP) {
		
		
			if(whichOP.contentEquals("<="))
				return ArithmeticExpression.evaluate(left) <= ArithmeticExpression.evaluate(right);
			if(whichOP.contentEquals("="))
				return ArithmeticExpression.evaluate(left) == ArithmeticExpression.evaluate(right);
			if(whichOP.contentEquals(">="))
				return ArithmeticExpression.evaluate(left) >= ArithmeticExpression.evaluate(right);
			if(whichOP.contentEquals("<"))
				return ArithmeticExpression.evaluate(left) < ArithmeticExpression.evaluate(right);
			if(whichOP.contentEquals(">"))
				return ArithmeticExpression.evaluate(left) > ArithmeticExpression.evaluate(right);
		
		
		return false;
	}
}
// https://www.tutorialcup.com/interview/stack/arithmetic-expression-evaluation.htm
/*
 * Rules for Evaluation:
 * 1. exponential
 * 2. parenthesis
 * 3. multiplication/division
 * 4. addition/subtraction
 * 
 * 
 * */
