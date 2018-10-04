package dp;

public class MinimumPathSum {

	public static void main(String[] args) {
		int[][] a = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

		int result = minPath(a);
		System.out.println(result);
	}

	private static int minPath(int[][] a) {

		int row = a.length, col = a[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = a[0][0];

		for (int i = 1; i < row; i++) {
			dp[i][0] = a[i][0] + dp[i - 1][0];
		}

		for (int j = 1; j < col; j++) {
			dp[0][j] = a[0][j] + dp[0][j - 1];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j] + a[i][j], dp[i][j - 1] + a[i][j]);
			}
		}

		return dp[row - 1][col - 1];
	}

}
