package goal9498.dp;

public class MinimumSteps {

	public static void main(String[] args) {
		int n = 3;
		System.out.println(minSteps(n));
	}

	private static int minSteps(int n) {

		int[] dp = new int[n + 1];

		for(int i=2; i<=n; i++) {
			dp[i] = i;
			for(int j=i-1; j>=1; j--) {
				if(i%j == 0) {
					dp[i] = dp[j] + i/j;
					break;
				}
			}
		}

		return dp[n];
	}

	protected static boolean isPrime(int n) {
		if (n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
