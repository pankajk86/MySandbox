package goal.phase.two.strings;

import java.util.Stack;

public class LongestValidParentheses {

    public static void main(String[] args) {

        String s = ")()(()(())";
        int length = sizeLongestValidParentheses(s);
        System.out.println("Result: " + length);
    }

    private static int sizeLongestValidParentheses(String s) {

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
