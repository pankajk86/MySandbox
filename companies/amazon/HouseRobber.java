package amazon;

public class HouseRobber {

	public static void main(String[] args) {
		int[] a = {4, 3, 5, 2, 7};
		int result = robMax(a);
		System.out.println(result);
	}

	private static int robMax(int[] a) {

		int n = a.length;
		
		if(n == 0) return 0;
		else if(n == 1) return a[0];
		else if(n == 2) return Math.max(a[0], a[1]);
		
		int[] dp = new int[n];
		dp[0] = a[0]; dp[1] = Math.max(a[0], a[1]);
		
		for(int i = 2; i < n; i++)
			dp[i] = Math.max(dp[i - 1], a[i] + dp[i - 2]);
		
		return dp[n - 1];
	}

}
