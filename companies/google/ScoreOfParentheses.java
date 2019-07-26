package google;

import java.util.Stack;

public class ScoreOfParentheses {

	public static void main(String[] args) {
		String s = "(()(()))";
		int result = scoreOfParentheses(s);
		System.out.println(result);
	}

	private static int scoreOfParentheses(String s) {
		if(s == null || s.isEmpty()) return 0;
		
		Stack<Integer> stack = new Stack<>();
		for(char c: s.toCharArray()) {
			if(c == '(') stack.push(-1);
			else {
				int curr = 0;
				while(stack.peek() != -1)
					curr += stack.pop();
				stack.pop();
				stack.push(curr == 0 ? 1 : 2 * curr);
			}			
		}
		
		int result = 0;
		while(!stack.isEmpty())
			result += stack.pop();
		
		return result;
	}

}
