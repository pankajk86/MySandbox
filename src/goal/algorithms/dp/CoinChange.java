package goal.algorithms.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = {1, 3, 5};
        int target = 8;

        int result = getCoinChange(coins, target);
        System.out.println(result);
    }

    private static int getCoinChange(int[] coins, int amount) {
    	if(coins == null || coins.length == 0 || amount < 0) return -1;
        
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        
        for(int i = 1; i <= amount; i++) {
            for(int coin: coins) {
                if(i - coin >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
