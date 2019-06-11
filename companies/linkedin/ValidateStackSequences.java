package linkedin;

import java.util.Stack;

public class ValidateStackSequences {

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 5, 4, 3, 2, 1 };
		boolean result = isValidStackSequence(pushed, popped);
		System.out.println(result);
	}

	private static boolean isValidStackSequence(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		int i = 0, j = 0, n = pushed.length;

		while (i < pushed.length) {
			if (pushed[i] != popped[j])
				stack.push(pushed[i++]);
			else {
				stack.push(pushed[i]);
				while (!stack.isEmpty() && stack.peek() == popped[j]) {
					stack.pop();
					j++;
				}
				i++;
			}
		}

		while (j < n) {
			if (stack.peek() == popped[j]) {
				stack.pop();
				j++;
			} else
				return false;
		}

		return stack.isEmpty();
	}

}
