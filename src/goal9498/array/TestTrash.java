package goal9498.array;

public class TestTrash {
	
	static int[] memo;

	public static void main(String[] args) {
		int n = 40; // 1 1 2 3 5 8

		long start = System.currentTimeMillis();
		int recursion = fibonacciWithRecursion(n);
		long end = System.currentTimeMillis();
		
		System.out.println(recursion + ", Time taken without memorization: " + (end - start));

		memo = new int[n + 1];
		
		start = System.currentTimeMillis();
		recursion = fibonnaciWithMemoization(n);
		end = System.currentTimeMillis();
		
		System.out.println(recursion + ", Time taken with memorization: " + (end - start));
	}

	private static int fibonnaciWithMemoization(int n) {

		if (memo[n] == 0) {

			if (n <= 1) {
				memo[n] = n;
			} else {
				memo[n] = fibonnaciWithMemoization(n - 1) + fibonnaciWithMemoization(n - 2);
			}
		}

		return memo[n];
	}

	private static int fibonacciWithRecursion(int n) {

		if (n <= 1) {
			return n;
		}

		return fibonacciWithRecursion(n - 1) + fibonacciWithRecursion(n - 2);
	}

}
