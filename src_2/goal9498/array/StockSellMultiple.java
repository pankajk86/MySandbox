package goal9498.array;

import java.util.ArrayList;
import java.util.List;

public class StockSellMultiple {

	public static void main(String[] args) {
		int[] a = { 4, 1, 3, 5, 8, 6, 9, 7, 10 };
		System.out.println("Max Profit: " + maxProfit(a));
	}

	private static int maxProfit(int[] a) {

		List<Interval> intervalList = new ArrayList<>();
		int i = 0, n = a.length;
		int maxProfit = 0;

		while (i < n - 1) {
			Interval interval = new Interval();

			while (i < (n - 1) && a[i] > a[i + 1])
				i++;

			if (i == n - 1)
				break;

			interval.buy = a[i++];

			while (i < n && a[i] > a[i - 1]) {
				i++;
			}
			
			interval.sell = a[i-1];
			intervalList.add(interval);
		}
		
		for(Interval interval: intervalList) {
			maxProfit += (interval.sell - interval.buy);
		}

		return maxProfit;
	}

}

class Interval {
	int buy, sell;
}