package google;

import java.util.Stack;

public class TernaryExpressionParser {

	public static void main(String[] args) {
		String s = "T?T?F:5:3";
		String result = parseTernary(s);
		System.out.println(result);
	}

	private static String parseTernary(String s) {
		if(s == null || s.isEmpty()) return s;
		
		Stack<Character> stack = new Stack<>();
		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if (!stack.isEmpty() && stack.peek() == '?') {

				stack.pop(); // pop '?'
				char trueStr = stack.pop();
				stack.pop(); // pop ':'
				char falseStr = stack.pop();

				stack.push(c == 'T' ? trueStr : falseStr);
			} else {
				stack.push(c);
			}
		}
		
		return String.valueOf(stack.peek());
	}

}
