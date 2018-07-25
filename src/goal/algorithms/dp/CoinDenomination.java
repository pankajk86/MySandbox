package goal.algorithms.dp;

public class CoinDenomination {

    public static void main(String[] args) {

        int coins[] = {1, 3, 5};
        int target = 8;

        // int minCoinDenomination = getMinCoinDenomination(coins, target);

        long start = System.currentTimeMillis();
        int minCoinDenomination = getMinCoinDenominationWithoutRecursion(coins, target);
        long end = System.currentTimeMillis();
        System.out.println("Minimum # of coins: " + minCoinDenomination);
        System.out.println("Time taken (in ms): " + (end - start));
        
        int result = getMinCoinDenominationWithDP(coins, target);
        System.out.println(result);
    }
    
    private static int getMinCoinDenominationWithDP(int[] coins, int target) {
    	
    	if(target < 1)
    		return 0;
    	
    	int[] dp = new int[target + 1];
    	int sum = 0;
    	
    	while(++sum <= target) {
    		int min = -1;
    		for(int coin: coins) {
    			if(sum >= coin && dp[sum - coin] != -1) {
    				int temp = dp[sum - coin] + 1;
    				min = min < 0 ? temp : (temp <min ? temp : min);
    			}
    		}
    		dp[sum] = min;
    	}
    	
    	return dp[target];
    }

    private static int getMinCoinDenominationWithoutRecursion(int[] coins, int target) {
        int dp[] = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if ((i - coin) >= 0 && dp[i - coin] + 1 < dp[i]) {
                    dp[i] = dp[i - coin] + 1;
                }
            }
        }

        return dp[target];
    }

    /**
     * This recursive method is not good, for the time-complexity appears to be
     * bad.
     * 
     * @param coins
     * @param target
     * @return
     */
    @SuppressWarnings("unused")
    private static int getMinCoinDenomination(int[] coins, int target) {

        if (target == 0) {
            return 0;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= target) {

                int subResult = getMinCoinDenomination(coins, target - coins[i]);

                if (subResult + 1 < result) {
                    result = subResult + 1;
                }
            }
        }

        return result;
    }

}
