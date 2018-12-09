package facebook;

import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		int[] a = {-2, 1, 1, -2};
		int[] result = asteroidCollision(a);
		
		for(int i: result)
			System.out.print(i + " ");
	}

	// NOT FULL PROOF
	private static int[] asteroidCollision(int[] a) {
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < a.length; i++) {
			int curr = a[i];
			if(i == 0) stack.push(curr);
			else {
				if(!stack.isEmpty()) {
					int top = stack.peek();
					if(curr < 0 && top > 0) {
						while(!stack.isEmpty() && curr != 0) {
							if(stack.peek() > 0) {
								if(Math.abs(curr) > stack.peek())
									stack.pop();
								else if(Math.abs(curr) == stack.peek()) {
									stack.pop(); curr = 0;
								} else
									curr = 0;
							} else if(stack.peek() < 0) {
								stack.push(curr);
								break;
							}
						}
//						if(curr != 0) stack.push(curr);
					} else {
						stack.push(curr);
					}
				} else {
					stack.push(curr);
				}
			}
		}
		
		int[] result = new int[stack.size()];
		
		for(int i = result.length - 1; i >= 0; i--)
			result[i] = stack.pop();
		
		return result;
	}

}
