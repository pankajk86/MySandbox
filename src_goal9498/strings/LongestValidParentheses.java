package strings;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

        String s = "()((())()()))()()";
        int length = getLongestValidParenthesesSize(s);
        System.out.println("Result: " + length);
    }

    private static int getLongestValidParenthesesSize(String s) {

    	Stack<Integer> stack = new Stack<>();
    	int longest = 0;
    	
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '(') {
    			stack.push(i);
    		} else {
    			if(!stack.isEmpty()) {
    				if(s.charAt(stack.peek()) == '(') {
    					stack.pop();
    				} else {
    					stack.push(i);
    				}
    			} else {
    				stack.push(i);
    			}
    		}
    	}

    	if(stack.isEmpty()) {
    		longest = s.length();
    	} else {
    		int a = s.length(), b = 0;
    		while(!stack.isEmpty()) {
    			b = stack.pop();
    			longest = Math.max(longest, a - b - 1);
    			a = b;
    		}
    		longest = Math.max(longest, a);
    	}
    	
    	return longest;
	}

	@SuppressWarnings("unused")
	private static int sizeLongestSubsequence(String s) {

        Stack<Character> stack = new Stack<Character>();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                if (stack.peek() == '(') {
                    count += 2;
                    stack.pop();
                }
            }
        }

        return count;
    }

}
