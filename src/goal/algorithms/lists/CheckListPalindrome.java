package goal.algorithms.lists;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CheckListPalindrome {

    public static void main(String[] args) {

        List<Character> list = new LinkedList<Character>();
        list.addAll(Arrays.asList('a', 'b', 'c', 'd', 'd', 'c', 'b', 'a'));

        boolean result = isPalindrome(list);
        System.out.println("Result: " + result);
    }

    private static boolean isPalindrome(List<Character> list) {

        Stack<Character> stack = new Stack<Character>();
        int size = list.size();
        int stackSize = size / 2;

        int peekStart = (size % 2 == 0) ? stackSize : (stackSize + 1);

        for (int i = 0; i < stackSize; i++) {
            stack.push(list.get(i));
        }

        for (int i = peekStart; i < list.size(); i++) {
            if (stack.peek() == list.get(i)) {
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
