package microsoft;

import java.util.Arrays;

public class Candy {

	public static void main(String[] args) {
		int[] a = { 1, 0, 3, 5, 2 };
		int result = countCandies(a);
		System.out.println(result);
	}

	private static int countCandies(int[] a) {
		if(a == null || a.length == 0) return 0;
		
		int n = a.length, result = 0;
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < n; i++) {
			if(a[i] > a[i - 1]) dp[i] = dp[i - 1] + 1;
		}
		
		for(int i = n - 2; i >= 0; i--) {
			if(a[i] > a[i + 1]) dp[i] = Math.max(dp[i], dp[i + 1] + 1);
		}
		
		for(int i = 0; i < dp.length; i++) result += dp[i];
		return result;
	}

}
