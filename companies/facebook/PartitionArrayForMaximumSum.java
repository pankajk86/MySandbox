package facebook;

import java.util.HashMap;
import java.util.Map;

public class PartitionArrayForMaximumSum {

    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] a = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;

        int result = maxSumPartition(a, k);
        System.out.println(result);

        result = maxSumPartitionDP(a, k);
        System.out.println(result);
    }

    private static int maxSumPartitionDP(int[] a, int k) {
        int n = a.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int currMax = -1;
            for(int j = 1; j <= k && i - j >= 0; j++) {
                currMax = Math.max(currMax, a[i - j]);
                dp[i] = Math.max(dp[i], (currMax * j) + dp[i - j]);
            }
        }
        return dp[n];
    }

    private static int maxSumPartition(int[] a, int k) {
        return dfs(a, k, 0);
    }

    private static int dfs(int[] a, int k, int i) {
        if (i >= a.length) return 0;
        if (map.containsKey(i)) return map.get(i);

        int currMax = 0, result = 0;

        for (int j = i; j < Math.min(a.length, i + k); j++) {
            currMax = Math.max(currMax, a[j]);
            int window = j - i + 1;
            result = Math.max(result, (currMax * window) + dfs(a, k, j + 1));
        }

        return result;
    }
}
