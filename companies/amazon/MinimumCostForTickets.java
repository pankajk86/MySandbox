package amazon;

public class MinimumCostForTickets {

	public static void main(String[] args) {
		int[] days = { 1, 4, 6, 7, 8, 20 };
		int[] costs = { 2, 7, 15 };
		
		int result = mincostTickets(days, costs);
		System.out.println(result);
	}

	private static int mincostTickets(int[] days, int[] costs) {
		int[] dp = new int[366];
		int index = 0;
		
		for(int i = 1; i <= 365; i++) {
			if(index == days.length) break;
			if(i != days[index]) {
				dp[i] = dp[i - 1];
				continue;
			}
			
			dp[i] = dp[i - 1] + costs[0]; // for 1 day pass
			dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]); // for 7 days pass
			dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]); // for 30 days pass
			
			index++;
		}
		
		return dp[days[days.length - 1]];
	}

}
