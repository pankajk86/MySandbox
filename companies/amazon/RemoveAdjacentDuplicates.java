package amazon;

import java.util.Stack;

public class RemoveAdjacentDuplicates {

	public static void main(String[] args) {
		String s = "abbaca";
		String result = removeDuplicates(s);
		System.out.println(result);
	}

	private static String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(char c: s.toCharArray()) {
			if(stack.isEmpty() || stack.peek() != c)
				stack.push(c);
			else stack.pop();
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) sb.append(stack.pop());
		
		return sb.reverse().toString();
	}

}
