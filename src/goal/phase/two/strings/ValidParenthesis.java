package goal.phase.two.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        String s = "{(}[]{}";
        boolean result = isValidParenthesis(s);
        System.out.println("Result: " + result);
    }

    private static boolean isValidParenthesis(String s) {

        Stack<Character> stack = new Stack<Character>();
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] ch = s.toCharArray();

        for (char c : ch) {
            if (map.keySet().contains(c)) {
                stack.push(c);
            } else if (map.values().contains(c) && map.get(stack.peek()) == c) {
                stack.pop();
            }
        }

        return (stack.isEmpty());
    }

}
