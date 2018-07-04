package dp;

public class MaxLengthRepeatedSubarray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 2, 1 };
		int[] b = { 3, 2, 1, 3, 2 };
		int result = maxLength(a, b);
		System.out.println(result);
	}

	private static int maxLength(int[] a, int[] b) {

		int[][] dp = new int[a.length + 1][b.length + 1];
		int result = 0;

		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = b.length - 1; j >= 0; j--) {
				if (a[i] == b[j]) {
					dp[i][j] = dp[i + 1][j + 1] + 1;
  					result = result < dp[i][j] ? dp[i][j] : result;
				}
			}
		}

		return result;
	}

}
