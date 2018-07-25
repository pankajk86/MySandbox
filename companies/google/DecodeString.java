package google;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String s = "3[a2[c]]";
		String result = decode(s);
		System.out.println(result);
		
	}

	private static String decode(String s) {
		
		Stack<String> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c != ']') {
				stack.push(String.valueOf(c));
			} else {
				StringBuilder temp = new StringBuilder();
				int count = 0, j = 0;
				while(!stack.peek().equals("[")) {
					temp.insert(0, stack.pop());
				}
				stack.pop();
				
				while(!stack.isEmpty() && stack.peek().compareTo("0") >= 0 && stack.peek().compareTo("9") <= 0) {
					count += Integer.parseInt(stack.pop()) * Math.pow(10, j++);
				}
				
				StringBuilder sb = new StringBuilder();
				
				for(int k = 0; k < count; k++) {
					sb.append(temp.toString());
				}
				
				stack.push(sb.toString());
			}
		}
		
		while(!stack.isEmpty()) {
			result.insert(0, stack.pop());
		}
		
		return result.toString();
	}

}
