package amazon;

import java.util.Arrays;
import java.util.Comparator;

public class TwoCityScheduling {

	public static void main(String[] args) {
		int[][] costs = {
			{ 10, 20 },
			{ 30, 200 },
			{ 400, 50 },
			{ 30, 20 }
		};
		
		int result = minCost(costs);
		System.out.println(result);
	}

	private static int minCost(int[][] costs) {
		int n = costs.length / 2;
		
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[0] - a[1]) - (b[0] - b[1]);
			}
		});
		
		int result = 0;
		for(int i = 0; i < n; i++)
			result += costs[i][0] + costs[i + n][1]; 
		
		return result;
	}

}
