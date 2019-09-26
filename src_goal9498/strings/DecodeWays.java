package strings;

public class DecodeWays {

	public static void main(String[] args) {
		String s = "115";
		int count = decodeWays(s);
		System.out.println(count);
		
		int result = decodeWays2(s);
		System.out.println(result);
	}

	private static int decodeWays2(String s) {
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

	private static int decodeWays(String s) {

		int n = s.length();
		
		if(n == 1) {
            if(s.equals("0")) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if(s.charAt(0) == '0') {
                return 0;
            }
        }
		
		int[] dp = new int[n + 1];

		dp[0] = 1;
		dp[1] = s.charAt(1) == '0' ? 0 : 1;

		for (int i = 2; i <= n; i++) {
			int first = Integer.parseInt(s.substring(i - 1, i));
			int second = Integer.parseInt(s.substring(i - 2, i));

			if (first > 0 && first <= 9) {
				dp[i] += dp[i - 1];
			}

			if (second >= 10 && second <= 26) {
				dp[i] += dp[i - 2];
			}
		}

		return dp[n];
	}

}
