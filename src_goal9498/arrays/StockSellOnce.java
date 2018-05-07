package arrays;

public class StockSellOnce {

	public static void main(String[] args) {
		int a[] = {10, 2, 19, 3, 8, 1, 9, 7, 15, 13};
		int maxProfit = getMaxProfit(a);
		System.out.println(maxProfit);
	}

	private static int getMaxProfit(int[] a) {
		int profit = 0;
		int minPriceSoFar = Integer.MAX_VALUE;
		
		for(int currentPrice: a) {
			profit = Math.max(profit, currentPrice - minPriceSoFar);
			minPriceSoFar = Math.min(minPriceSoFar, currentPrice);
		}
		
		return profit;
	}

}
