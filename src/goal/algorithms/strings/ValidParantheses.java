package goal.algorithms.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParantheses {

    public static void main(String[] args) {

        String s = "[{}[]{()()}]";
        System.out.println(s + "is a valid parantheses: " + isValidParanthesis(s));
    }

    private static boolean isValidParanthesis(String s) {

        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.keySet().contains(c)) {
                stack.push(c);
            } else if (map.values().contains(c)) {
                if (!stack.isEmpty() && map.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

}
