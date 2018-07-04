package arrays;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int result = trap(a);
		System.out.println(result);
	}

	private static int trap(int[] a) {
		
		Stack<Integer> stack = new Stack<>();
		int i = 0, maxWater = 0, botWater = 0;
		
		while(i < a.length) {
			if(stack.isEmpty() || a[stack.peek()] >= a[i]) {
				stack.push(i++);
			} else {
				int bot = stack.pop();
				botWater = stack.isEmpty() ? 0 : (Math.min(a[stack.peek()], a[i]) - a[bot]) * (i - 1 - stack.peek());
				maxWater += botWater;
			}
		}
		
		return maxWater;
	}

}
