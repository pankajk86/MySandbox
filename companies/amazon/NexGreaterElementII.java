package amazon;

import java.util.Arrays;
import java.util.Stack;

public class NexGreaterElementII {

	public static void main(String[] args) {
		int[] a = { 1, 2, -1, 3, 2, 1 };
		int[] result = nextGreater(a);
		for(int i: result) System.out.print(i + " ");
	}

	private static int[] nextGreater(int[] a) {
		if(a == null || a.length == 0) return null;
		int n = a.length;
		int[] next = new int[n];
		Arrays.fill(next, -1);
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < n * 2; i++) {
			int curr = a[i % n];
			while(!stack.isEmpty() && a[stack.peek()] < curr)
				next[stack.pop()] = curr;
			if(i < n)
				stack.push(i);
		}
		return next;
	}

}
