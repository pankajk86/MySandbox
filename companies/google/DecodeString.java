package google;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
		String result = decode(s);
		System.out.println(result);
	}

	private static String decode(String s) {
        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if(c != ']') stack.push(String.valueOf(c));
            else {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) sb.insert(0, stack.pop());
                stack.pop();

                String val = sb.toString();
                sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek().compareTo("0") >= 0 && stack.peek().compareTo("9") <= 0)
                    sb.insert(0, stack.pop());

                int count = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                for(int i = 0; i < count; i++) sb.append(val);
                stack.push(sb.toString());
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
	}

}
