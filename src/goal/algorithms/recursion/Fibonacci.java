package goal.algorithms.recursion;

public class Fibonacci {

	public static void main(String[] args) {
		/*
		 * fibonacci(0) → 0
		 * fibonacci(1) → 1
		 * fibonacci(2) → 1
		 * ...
		 */
		int number = 7;
		System.out.println("Fibonacci Number for " + number + "th place: " + fibonacci(number));

	}

	private static int fibonacci(int n) {
		if(n==0) {
			return 0;
		}
		
		if(n==1 || n==2) {
			return 1;
		}
		
		return fibonacci(n-1) + fibonacci(n-2);
	}

}
