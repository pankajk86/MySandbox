package strings;

public class DecodeWays {

	public static void main(String[] args) {
		String s = "115";
		int count = decodeWays(s);
		System.out.println(count);
	}

	private static int decodeWays(String s) {
		if(s == null || s.isEmpty()) return 0;
		int n = s.length();
		int[] dp = new int[n];
		dp[0] = s.charAt(0) == '0' ? 0 : 1;
		
		for(int i = 1; i < n; i++) {
			int curr = Integer.parseInt(s.substring(i, i + 1));
			int lastTwo = Integer.parseInt(s.substring(i - 1, i + 1));
			
			if(curr >= 1 && curr <= 9) dp[i] += dp[i - 1];
			if(lastTwo >= 10 && lastTwo <= 26) dp[i] += i >= 2 ? dp[i - 2] : 1;
		}
		
		return dp[n - 1];
	}

}
