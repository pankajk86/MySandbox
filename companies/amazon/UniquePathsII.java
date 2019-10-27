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
        
        int rows = a.length, cols = a[0].length;
        int[][] dp = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            if(a[i][0] == 0) dp[i][0] = 1;
            else break;
        }
        
        for(int j = 0; j < cols; j++) {
            if(a[0][j] == 0) dp[0][j] = 1;
            else break;
        }
        
        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                if(a[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
                
        }
        
        return dp[rows - 1][cols - 1];
	}
}
