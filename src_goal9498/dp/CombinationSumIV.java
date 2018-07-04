package dp;

import java.util.Arrays;

public class CombinationSumIV {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		int target = 4;

		long start = System.currentTimeMillis();
		int result = conbinationSumRecurr(a, target);
		System.out.println(result);
		System.out.println(System.currentTimeMillis() - start);
		
		start = System.currentTimeMillis();
		result = combinationSumDP(a, target);
		System.out.println(result);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	private static int combinationSumDP(int[] a, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		return helper(a, target, dp);
	}

	private static int helper(int[] a, int target, int[] dp) {
		if(dp[target] != -1) {
			return dp[target];
		}
		
		int ret = 0;
		
		for(int n: a) {
			if(n <= target) {
				ret += helper(a, target - n, dp);
			}
		}
		
		dp[target] = ret;
		return ret;
	}

	private static int conbinationSumRecurr(int[] a, int target) {

		int result = helper(a, 0, 0, target);
		return result;
	}

	private static int helper(int[] a, int count, int sum, int target) {
 
		if (sum == target) {
			return count + 1;
		} else if (sum > target) {
			return 0;
		} else {
			int temp = 0;
			for (int i = 0; i < a.length; i++) {
				temp += helper(a, count, sum + a[i], target);
			}
			return temp;
		}
	}
}
