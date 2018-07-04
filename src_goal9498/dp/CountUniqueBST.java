package dp;

public class CountUniqueBST {

	public static void main(String[] args) {
		int n = 5;
		int result = countUniqueBST(n);
		System.out.println(result);
	}

	private static int countUniqueBST(int n) {

		if(n <= 2) {
			return n;
		}
		
		int[] dp = new int[n + 1];
		
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = helper(i, dp);
		}

		return dp[n];
	}

	private static int helper(int index, int[] dp) {

		int temp = 0;

		for (int i = 1; i <= index; i++) {
			if (i == 1 || i == index) {
				temp += dp[index - 1];
			} else {
				temp += dp[i - 1] * dp[index - i];
			}
		}

		return temp;
	}

}
