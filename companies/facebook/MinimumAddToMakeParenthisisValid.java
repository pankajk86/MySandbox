package facebook;

import java.util.Stack;

public class MinimumAddToMakeParenthisisValid {

	public static void main(String[] args) {
		String s = "())((())(((";
		int result = minAdd(s);
		System.out.println(result);
		
		result = minAddBetter(s);
		System.out.println(result);
	}
	
	private static int minAddBetter(String s) {
		int left = 0, right = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') right++;
			else if(right > 0) right--;
			else left++;
		}
		return left + right;
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
