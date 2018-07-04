package goal.phase.two.arrays;

import java.util.Stack;

public class MaxHistogramArea {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 3, 3, 2 }; // { 2, 1, 5, 6, 2, 3 };
		int maxArea = getMaxArea(a);

		System.out.println("Result: " + maxArea);
	}

	public static int getMaxArea(int[] a) {

		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = -1;
		int i = 0;

		while (i < a.length) {

			if (stack.isEmpty() || a[i] >= a[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				maxArea = getInterMax(stack, a, i, maxArea);
			}
		}

		while (!stack.isEmpty()) {
			maxArea = getInterMax(stack, a, i, maxArea);
		}

		return maxArea;
	}

	private static int getInterMax(Stack<Integer> stack, int[] a, int i, int maxArea) {
		int height = a[stack.pop()];
		int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
		return Math.max(height * width, maxArea);
	}
}
