package facebook;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		String result = minRemoveToMakeValid(s);
		System.out.println(result);
	}

	private static String minRemoveToMakeValid(String s) {
		if(s == null || s.isEmpty()) return s;
		StringBuilder sb = new StringBuilder(s);
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
			if(sb.charAt(i) == '(') stack.push(i);
			else if(sb.charAt(i) == ')') {
				if(!stack.isEmpty()) stack.pop();
				else sb.setCharAt(i, '*');
			}
		}
		
		while(!stack.isEmpty()) sb.setCharAt(stack.pop(), '*');
		return sb.toString().replaceAll("\\*", "");
	}

}
