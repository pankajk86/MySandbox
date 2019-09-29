package google;

public class InterleavingStrings {

	public static void main(String[] args) {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
		boolean result = isInterleave(s1, s2, s3);
		System.out.println(result);
	}

	private static boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        if(l1 + l2 != l3) return false;
        
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        dp[0][0] = true;
        
        for(int i = 1; i < dp.length; i++)
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        
        for(int i = 1; i < dp[0].length; i++)
            dp[0][i] = dp[0][i - 1] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                boolean part1 = dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(i + j - 1));
                boolean part2 = dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(i + j - 1));
                dp[i][j] = part1 || part2;
            }
        }
        
        return dp[l1][l2];
	}

}
