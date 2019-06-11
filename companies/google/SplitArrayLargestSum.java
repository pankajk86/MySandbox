package google;

public class SplitArrayLargestSum {

	public static void main(String[] args) {
		int[] nums = { 7, 2, 5, 10, 8 };
		int m = 3;
		
		int result = maxSumArrayDP(nums, m);
		System.out.println(result);
		
		result = maxSumArrayBinarySearch(nums, m);
		System.out.println(result);
	}

	private static int maxSumArrayBinarySearch(int[] a, int m) {
		int max = 0, sum = 0;
		
		for(int i: a) {
			max = Math.max(max, i);
			sum += i;
		}
		
		int low = max, high = sum;
		while(low < high) {
			int mid = low + (high - low) / 2;
			int pieces = split(a, mid);
			if(pieces > m)
				low = mid + 1;
			else high = mid;
		}
		return low;
	}

	private static int split(int[] a, int largestSum) {
		int pieces = 1, temp = 0;
		
		for(int i: a) {
			if(temp + i > largestSum) {
				temp = i;
				pieces++;
			} else {
				temp += i;
			}
		}
		return pieces;
	}

	private static int maxSumArrayDP(int[] nums, int m) {
		int[][] dp = new int[m][nums.length];
		dp[0][0] = nums[0];
		
		for(int i = 1; i < nums.length; i++)
			dp[0][i] = dp[0][i - 1] + nums[i];
		
		
		for(int i = 1; i < m; i++) {
			for(int j = i; j < nums.length; j++) {
				int min = Integer.MAX_VALUE;
				for(int k = 0; k < j; k++)
					min = Math.min(min, Math.max(dp[i - 1][k], dp[0][j] - dp[0][k]));
				dp[i][j] = min;
			}
		}
		return dp[m - 1][nums.length - 1];
	}

}
