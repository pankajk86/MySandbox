package amazon;

public class LongestRepeatingSubstring {

	public static void main(String[] args) {
		String s = "ababb";
		int result = longestRepeatingSubstring(s);
		System.out.println(result);
	}

	private static int longestRepeatingSubstring(String s) {
		int n = s.length(), result = 0;
		int[][] dp = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = i + 1; j <= n; j++) {
				if(s.charAt(i - 1) == s.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		return result;
	}

}
