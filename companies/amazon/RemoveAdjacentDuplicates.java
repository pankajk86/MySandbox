package amazon;

import java.util.Stack;

public class RemoveAdjacentDuplicates {

	public static void main(String[] args) {
		String s = "abbaca";
		String result = removeDuplicates(s);
		System.out.println(result);

		result = removeDuplicatesII(s);
		System.out.println(result);
	}

	private static String removeDuplicatesII(String s) {
		char[] carr = new char[s.length()];
		int index = -1;

		for (char c : s.toCharArray()) {
			if (index == -1 || c != carr[index]) {
				carr[index + 1] = c;
				index++;
			} else {
				index--;
			}
		}
		return new String(carr, 0, index + 1);
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
