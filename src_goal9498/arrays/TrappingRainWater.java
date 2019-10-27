package arrays;

import java.util.Stack;

public class TrappingRainWater {

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int result = trapLinearSpace(a);
		System.out.println(result);
		
		result = trapConstantSpace(a);
		System.out.println(result);
	}

	private static int trapConstantSpace(int[] a) {
		int left = 0, right = a.length - 1;
		int leftMax = a[left], rightMax = a[right];
		int result = 0;
		
		while(left <= right) {
			if(a[left] <= a[right]) {
				if(leftMax <= a[left])
					leftMax = a[left];
				else result += leftMax - a[left];
				left++;
			} else {
				if(rightMax <= a[right])
					rightMax = a[right];
				else result += rightMax - a[right];
				right--;
			}
		}
		
		return result;
	}

	private static int trapLinearSpace(int[] a) {
		Stack<Integer> stack = new Stack<>();
		int maxWater = 0, botWater = 0;
		
		for(int i = 0; i < a.length; ) {
			if(stack.isEmpty() || a[stack.peek()] >= a[i]) {
				stack.push(i++);
			} else {
				int bot = stack.pop();
				if(!stack.isEmpty()) {
					int height = Math.min(a[stack.peek()], a[i]) - a[bot];
					int width = i - 1 - stack.peek();
					botWater = height * width;
				} else botWater = 0;
				maxWater += botWater;
			}
		}
		
		return maxWater;
	}

}
