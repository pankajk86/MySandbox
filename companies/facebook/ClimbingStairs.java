package facebook;

public class ClimbingStairs {

    public static void main(String[] args) {
        int n = 3;
        int result = climbStairs(n);
        System.out.println(result);

        result = climbStairsII(n);
        System.out.println(result);

        result = climbStairsIII(n);
        System.out.println(result);
    }

    private static int climbStairsIII(int n) {
        if (n <= 2) return n;

        int one = 1, two = 1;

        for (int i = n - 2; i >= 0; i--) {
            int temp = one + two;
            two = one;
            one = temp;
        }

        return one;
    }

    // bottom up
    private static int climbStairsII(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[n] = 1; dp[n - 1] = 1;

        // dp = 3, 2, 1, 1
        //      0  1  2  3

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }
        return dp[0];
    }

    // top down
    private static int climbStairs(int n) {
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
