package goal.algorithms.dp;

public class CoinDenomination {

    public static void main(String[] args) {

        int coins[] = { 1, 3, 5 };
        int target = 11;

        // int minCoinDenomination = getMinCoinDenomination(coins, target);

        long start = System.currentTimeMillis();
        int minCoinDenomination = getMinCoinDenominationWithoutRecursion(coins, target);
        long end = System.currentTimeMillis();
        System.out.println("Minimum # of coins: " + minCoinDenomination);
        System.out.println("Time taken (in ms): " + (end - start));
    }

    private static int getMinCoinDenominationWithoutRecursion(int[] coins, int target) {
        int coinsCache[] = new int[target + 1];

        for (int i = 0; i <= target; i++) {
            coinsCache[i] = Integer.MAX_VALUE;
        }

        coinsCache[0] = 0;

        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if ((i - coin) >= 0 && coinsCache[i - coin] + 1 < coinsCache[i]) {
                    coinsCache[i] = coinsCache[i - coin] + 1;
                }
            }
        }

        return coinsCache[target];
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
