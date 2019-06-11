package facebook;

import java.util.Stack;

public class MinimumAddToMakeParenthisisValid {

	public static void main(String[] args) {
		String s = "())((())(((";
		int result = minAdd(s);
		System.out.println(result);
	}

	private static int minAdd(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(char c: s.toCharArray()) {
			if(stack.isEmpty() || c == '(') 
				stack.push(c);
			else {
				if(c == ')') {
					if(stack.peek() == '(') 
						stack.pop();
					else stack.push(c);
				}
			}
		}
		return stack.size();
	}

}
