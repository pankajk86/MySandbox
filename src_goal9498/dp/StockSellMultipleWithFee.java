package dp;

public class StockSellMultipleWithFee {

	public static void main(String[] args) {
		int[] a = {3, 10, 4, 1, 15, 7, 8, 5, 20, 13}; // { 1, 3, 2, 8, 4, 9 }; // 
		int fee = 2;

		int profit = getMaxProfit(a, fee);
		System.out.println(profit);
	}

	private static int getMaxProfit(int[] prices, int fee) {

		if (prices.length < 2) {
			return 0;
		}

		int sell = 0, buy = -prices[0];

		for (int i = 1; i < prices.length; i++) {
			sell = Math.max(sell, buy + prices[i] - fee);
			buy = Math.max(buy, sell - prices[i]);
		}
		
		return sell;
	}

}
