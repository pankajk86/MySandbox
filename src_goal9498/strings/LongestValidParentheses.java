package strings;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

        String s = "()((())()()))()()";
        int result = getLongestValidParentheses(s);
        System.out.println("Result: " + result);
        
        result = getLongestValidParenthesesII(s);
        System.out.println(result);
    }
    
    /**
     * Constant Space
     * 
     * @param s
     * @return
     */
    private static int getLongestValidParenthesesII(String s) {
    	if(s == null || s.isEmpty()) return 0;
    	int left = 0, right = 0, result = 0;
    	
    	for(int i = 0; i < s.length(); i++) {
    		if(s.charAt(i) == '(') left++;
    		else right++;
    		
    		if(left == right) result = Math.max(result, right * 2);
    		else if(right > left) {
    			left = 0; right = 0;
    		}
    	}
    	
    	left = 0; right = 0;
    	for(int i = s.length() - 1; i >= 0; i--) {
    		if(s.charAt(i) == '(') left++;
    		else right++;
    		
    		if(left == right) result = Math.max(result, left * 2);
    		else if(left > right) {
    			left = 0; right = 0;
    		}
    	}
    	
    	return result;
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
