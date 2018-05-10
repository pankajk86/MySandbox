package strings;

public class DecodeWays {

	public static void main(String[] args) {
		String s = "101";
		int count = decodeWays(s);
		System.out.println(count);
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
