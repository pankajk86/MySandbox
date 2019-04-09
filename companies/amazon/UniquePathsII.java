package amazon;

public class UniquePathsII {

	public static void main(String[] args) {
		int[][] a = {
				{ 0, 0, 0, 0, 0 },
				{ 0, 1, 0, 1, 0 },
				{ 0, 0, 0, 0, 0 }
		};
		int result = findUniquePaths(a);
		System.out.println(result);
	}

	private static int findUniquePaths(int[][] a) {
		if(a == null || a.length == 0) return 0;
		
		int cols = a[0].length;
		int[] dp = new int[cols];
		dp[0] = 1;
		
		for(int[] row: a) {
			for(int j = 0; j < cols; j++) {
				if(row[j] == 1)
					dp[j] = 0;
				else if(j > 0)
					dp[j] += dp[j - 1];
			}
		}
		
		return dp[cols - 1];
	}

	
}
