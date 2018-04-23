package goal9498.dp;

public class EditMinDistance {

	public static void main(String[] args) {
		String s1 = "algorithm", s2 = "logarithm";
		int count = minEditDistance(s1, s2);
		System.out.println("For s1: " + s1 + ", s2: " + s2 + ":: " + count);
	}

	private static int minEditDistance(String s1, String s2) {

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];

		for (int i = 1; i <= s1.length(); i++) {
			dp[i][0] = i;
		}

		for (int j = 1; j <= s2.length(); j++) {
			dp[0][j] = j;
		}
		
		for(int i=1; i<= s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1];
				} else {
					dp[i][j] = minInThree(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]) + 1;
				}
			}
		}

		return dp[s1.length()][s2.length()];
	}
	
	private static int minInThree(int a, int b, int c) {
		return Math.min(Math.min(a, b), c);
	}

}
