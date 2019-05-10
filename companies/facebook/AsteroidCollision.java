package facebook;

import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		int[] a = {-10,7,-8,5,-4,-2};
		int[] result = asteroidCollision(a);
		
		for(int i: result)
			System.out.print(i + " ");
	}

	private static int[] asteroidCollision(int[] a) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < a.length; i++) {
			if(stack.isEmpty() || a[i] > 0) {
				stack.push(a[i]);
				continue;
			}
			
			while(true) {
				int prev = stack.peek();
				if(prev < 0) {
					stack.push(a[i]);
					break;
				}
				if(prev == -a[i]) {
					stack.pop();
					break;
				}
				if(prev > -a[i])
					break;
				stack.pop();
				if(stack.isEmpty()) {
					stack.push(a[i]);
					break;
				}
			}
		}
		
		int[] result = new int[stack.size()];
		for(int i = stack.size() - 1; i >=0; i--)
			result[i] = stack.pop();
		
		return result;
	}

}
