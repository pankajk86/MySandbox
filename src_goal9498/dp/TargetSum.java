package dp;

public class TargetSum {

	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1, 1 };
		int S = 3;
		int result = targetSum(a, S);
		System.out.println(result);
	}

	private static int targetSum(int[] a, int S) {

		int[] dp = new int[2001];
		dp[a[0] + 1000] = 1;
		dp[-a[0] + 1000] += 1;

		for (int i = 1; i < a.length; i++) {
			int[] temp = new int[2001];
			for (int sum = -1000; sum <= 1000; sum++) {
				if (dp[sum + 1000] > 0) {
					temp[sum + a[i] + 1000] += dp[sum + 1000];
					temp[sum - a[i] + 1000] += dp[sum + 1000];
				}
			}
			dp = temp;
		}
		return S > 1000 ? 0 : dp[S + 1000];
	}

}
