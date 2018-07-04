package dp;

public class DeleteAndEarn {

	public static void main(String[] args) {
		int[] a = { 7, 1, 3, 3, 4, 8, 5, 4 };
		int result = deleteAndEarn(a);
		System.out.println(result);
	}

	private static int deleteAndEarn(int[] a) {

		int[] dp = new int[10001];

		for (int i : a) {
			dp[i] += i;
		}

		for (int i = 2; i < dp.length; i++) {
			dp[i] = Math.max(dp[i] + dp[i - 2], dp[i - 1]);
		}

		return dp[dp.length - 1];
	}

}
