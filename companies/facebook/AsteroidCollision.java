package facebook;

import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		int[] a = { -10, 7, -8, 5, -4, -2 };
		int[] result = asteroidCollision(a);

		for (int i : result)
			System.out.print(i + " ");
	}

	private static int[] asteroidCollision(int[] a) {
		Stack<Integer> stack = new Stack<>();
		boolean destroyed;
		
		for(int i: a) {
			destroyed = false;
			while(!stack.isEmpty() && i < 0 && stack.peek() > 0) {
				if(stack.peek() < -i) {			// when left moving asteroid is larger than the right moving (stack.peek)
					stack.pop(); continue;  	// in this case right moving will be destroyed
				} else if(stack.peek() == -i) { // when both are of same size
					stack.pop();				// right moving will be destroyed
					destroyed = true;			// and so will the current (left moving)
				} else destroyed = true;		// if the left moving is small, only it will be destroyed
				break;
			}
			
			if(!destroyed) stack.push(i);		// add, if not destroyed
		}

		int[] result = new int[stack.size()];
		for (int i = stack.size() - 1; i >= 0; i--)
			result[i] = stack.pop();

		return result;
	}

}
