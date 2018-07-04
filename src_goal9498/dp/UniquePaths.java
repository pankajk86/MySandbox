package dp;

public class UniquePaths {

	public static void main(String[] args) {
		int m = 8, n = 3;
		int result = countUnqiuePathsRecursion(m, n);
		result = countUniquePathsDP(m, n);
		System.out.println(result);
	}

	private static int countUniquePathsDP(int m, int n) {
		int[][] dp = new int[n][m];

		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = 1;
		}

		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		return dp[n - 1][m - 1];
	}

	private static int countUnqiuePathsRecursion(int m, int n) {
		int count = helper(0, 1, 1, m, n);
		return count;
	}

	private static int helper(int total, int i, int j, int m, int n) {

		if (i == m && j == n) {
			return total + 1;
		} else if (i == m && j < n) {
			return helper(total, i, j + 1, m, n);
		} else if (i < m && j == n) {
			return helper(total, i + 1, j, m, n);
		} else {
			return helper(total, i + 1, j, m, n) + helper(total, i, j + 1, m, n);
		}

	}

}
