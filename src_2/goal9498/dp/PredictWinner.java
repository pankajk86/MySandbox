package goal9498.dp;

public class PredictWinner {

	public static void main(String[] args) {
		int[] a = { 1, 5, 2 };
		boolean result = predictWinner(a);
		System.out.println(result);
	}

	private static boolean predictWinner(int[] a) {

		int n = a.length;
		int[][] dp = new int[n][n];

		for (int s = n; s >= 0; s--) {
			for (int e = s + 1; e < n; e++) {
				int x = a[s] - dp[s + 1][e];
				int y = a[e] - dp[s][e - 1];
				dp[s][e] = Math.max(x, y);
			}
		}

		return dp[0][n - 1] >= 0;
	}

}
