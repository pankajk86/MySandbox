package google;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";
		String result = decode(s);
		System.out.println(result);
		
		result = decode2(s);
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
	
	
	private static String decode2(String s) {
		if(s == null || s.length() == 0) return s;
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != ']') stack.push(String.valueOf(s.charAt(i)));
            else {
                StringBuilder sb = new StringBuilder();
                while(!stack.peek().equals("[")) sb.insert(0, stack.pop());
                stack.pop();
                
                String val = sb.toString(), countS = "";
                while(!stack.isEmpty() && stack.peek().compareTo("0") >= 0 && stack.peek().compareTo("9") <= 0)
                    countS = stack.pop() + countS;
                int count = Integer.parseInt(countS);
                
                sb = new StringBuilder();
                for(int j = 0; j < count; j++) sb.append(val);
                stack.push(sb.toString());
            }
        }
        
        String result = "";
        while(!stack.isEmpty()) result = stack.pop() + result;
        return result; 
	}

}
