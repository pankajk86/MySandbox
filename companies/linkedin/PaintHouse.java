package linkedin;

public class PaintHouse {

	public static void main(String[] args) {
		int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		int result = minCost(costs);
		System.out.println(result);
		
		result = minCostBetter(costs);
		System.out.println(result);
	}
	
	private static int minCostBetter(int[][] a) {
		if(a == null || a.length == 0) return 0;
        
        int r = a[0][0], g = a[0][1], b = a[0][2];
        
        for(int i = 1; i < a.length; i++) {
            int newR = Math.min(g, b) + a[i][0];
            int newG = Math.min(r, b) + a[i][1];
            int newB = Math.min(r, g) + a[i][2];
            r = newR; g = newG; b = newB;
        }
        
        return Math.min(r, Math.min(g, b));
	}

	private static int minCost(int[][] costs) {
		
		if(costs == null || costs.length == 0)
			return 0;
		
		int n = costs.length - 1;
		
		for(int i = 1; i <= n; i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		}
		
		return Math.min(costs[n][0], Math.min(costs[n][1], costs[n][2]));
	}

}
