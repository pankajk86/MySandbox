package maps;

import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		
		int[] result = dailyTemperatures(temperatures);
		for (int i : result) System.out.print(i + " ");
		
		System.out.println();
		result = dailyTemperaturesSimple(temperatures);
		for (int i : result) System.out.print(i + " ");
		
	}
	
	private static int[] dailyTemperaturesSimple(int[] a) {
		if (a == null || a.length == 0)
			return null;

		int[] result = new int[a.length];
		Stack<Integer> stack = new Stack<>();
		result[a.length - 1] = 0;
		stack.push(a.length - 1);

		for (int i = a.length - 2; i >= 0; i--) {
			while (!stack.isEmpty() && a[stack.peek()] <= a[i])
				stack.pop();
			result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}

		return result;
	}

	private static int[] dailyTemperatures(int[] temps) {
		if(temps == null || temps.length == 0) return null;
		
		int n = temps.length;
		int[] result = new int[n];
		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] {n - 1, temps[n - 1]});
		result[n - 1] = 0;
		
		for(int i = n - 2; i >= 0; i--) {
			int[] top = stack.peek();
			int[] curr = new int[] {i, temps[i]};
			
			if(curr[1] < top[1]) {
				result[i] = top[0] - curr[0];
			} else {
				while(!stack.isEmpty() && stack.peek()[1] <= curr[1])
					stack.pop();
				if(stack.isEmpty())
					result[i] = 0;
				else result[i] = stack.peek()[0] - curr[0];
			}
			stack.push(curr);
		}
		return result;
	}
}
