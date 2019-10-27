package microsoft;

public class UniqueBinarySearchTrees {

	public static void main(String[] args) {
		int n = 3;
		int result = countBST(n);
		System.out.println(result);
	}

	private static int countBST(int n) {
		if(n <= 2) return n;
		
		int[] dp = new int[n + 1];
		dp[1] = 1; dp[2] = 2;
		
		for(int i = 3; i <= n; i++)
			dp[i] = helper(dp, i);
		
		return dp[n];
	}

	private static int helper(int[] dp, int index) {
		int temp = 0;
		
		for(int i = 1; i <= index; i++) {
			if(i == 1 || i == index) temp += dp[index - 1];
			else temp += dp[i - 1] * dp[index - i];
		}
		return temp;
	}

}
