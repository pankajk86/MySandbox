package strings;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

        String s = "()((())()()))()()";
        int length = getLongestValidParentheses(s);
        System.out.println("Result: " + length);
    }
    
    private static int getLongestValidParentheses(String s) {
    	Stack<Integer> stack = new Stack<>();
    	int result = 0;
    	stack.push(-1);
    	
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '(') stack.push(i);
    		else {
    			if(stack.peek() == -1 || s.charAt(stack.peek()) == ')')
    				stack.push(i);
    			else {
    				stack.pop();
    				result = Math.max(result, i - stack.peek());
    			}
    		}
    	}
    	return result;
    }
}
