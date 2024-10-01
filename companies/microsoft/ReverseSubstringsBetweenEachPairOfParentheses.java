package microsoft;

import java.util.*;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    public static void main(String[] args) {
        String s = "(u(love)i)";
        String result = reverseInPairsI(s);
        System.out.println(result);

        result = reverseInPairsII(s);
        System.out.println(result);
    }

    /**
     * T : O(n)
     * S : O(n)
     *
     * @param s
     */
    private static String reverseInPairsII(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else if (c == ')') {
                int j = stack.pop();
                map.put(j, i);
                map.put(i, j);
            }
        }

        int dir = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i += dir) {
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                i = map.get(i);
                dir = -dir;
            } else sb.append(c);
        }

        return sb.toString();
    }

    /**
     * T : O(n ^ 2)
     * S : O(n)
     *
     * @param s
     */
    private static String reverseInPairsI(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] carr = new char[s.length()];
        int index = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(index);
            } else if (c == ')') {
                reverse(carr, stack.pop(), index - 1);
            } else {
                carr[index++] = c;
            }
        }
        return String.valueOf(carr, 0, index);
    }

    private static void reverse(char[] a, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
