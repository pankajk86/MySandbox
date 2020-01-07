package dp;

public class IntegerBreak {

	public static void main(String[] args) {
		int n = 2;

		int value = getIntegerBreak(n);
		System.out.println(value);
	}

	private static int getIntegerBreak(int n) {
		int[] dp = new int[n + 1];

		if (n == 2 || n == 3) {
			return n - 1;
		}

		if (n == 4) {
			return n;
		}

		for (int i = 0; i <= 4; i++) {
			dp[i] = i;
		}

		for (int i = 5; i <= n; i++) {
			dp[i] = 3 * dp[i - 3];
		}

		return dp[n];
	}

}
