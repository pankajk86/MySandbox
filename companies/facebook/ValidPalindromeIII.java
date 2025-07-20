package facebook;

import java.util.Arrays;

public class ValidPalindromeIII {

    public static void main(String[] args) {
        String s = "abcdeca";
        int k = 2;

        boolean result = isValidPalindrome(s, k);
        System.out.println(result);
    }

    private static boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int[] row : dp) Arrays.fill(row, -1);

        int result = isPalindrome(s, 0, n - 1, dp);
        return result <= k;
    }

    private static int isPalindrome(String s, int l, int r, int[][] dp) {
        if (l > r) return 0;
        if (dp[l][r] != -1) return dp[l][r];

        if (s.charAt(l) != s.charAt(r)) {
            dp[l][r] = 1 + Math.min(isPalindrome(s, l + 1, r, dp), isPalindrome(s, l, r - 1, dp));
        } else {
            dp[l][r] = isPalindrome(s, l + 1, r - 1, dp);
        }
        return dp[l][r];
    }
}
