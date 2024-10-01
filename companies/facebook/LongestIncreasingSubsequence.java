package facebook;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] a = {10, 9, 2, 5, 3, 7, 101, 18};
        int result = getLIS(a);
        System.out.println(result);
    }

    private static int getLIS(int[] a) {
        int n = a.length, result = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        return result;
    }
}
