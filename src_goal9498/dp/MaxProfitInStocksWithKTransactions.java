package dp;

public class MaxProfitInStocksWithKTransactions {

	public static void main(String[] args) {
		int[] a = { 3, 3, 5, 0, 0, 3, 1, 4 };
		int result = maxProfitWithKTransactions(a, 2);
		System.out.println(result);
	}

	private static int maxProfitWithKTransactions(int[] a, int k) {

		int[][] dp = new int[k + 1][a.length];

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j < a.length; j++) {
				int max = dp[i][j - 1];

				for (int m = 0; m < j; m++) {
					int current = a[j] - a[m] + dp[i - 1][m];
					max = Math.max(max, current);
				}
				dp[i][j] = max;
			}
		}

		return dp[k][a.length - 1];
	}

}
