package linkedin;

public class PaintHouseII {

	public static void main(String[] args) {
		int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
		int result = minCost(costs);
		System.out.println(result);
	}

	/**
	 * 
	 * @param costs it is n x k matrix, instead of n x 3 matrix. 
	 * @return
	 */
	private static int minCost(int[][] a) {
		if(a == null || a.length == 0) return 0;
		int min1 = 0, min2 = 0, index1 = 0;
		
		for(int i = 0; i < a.length; i++) {
			int m1 = Integer.MAX_VALUE, m2 = Integer.MAX_VALUE, idx = -1;
			for(int j = 0; j < a[0].length; j++) {
				int cost = a[i][j] + (j != index1 ? min1 : min2);
				
				if(cost < m1) {
					m2 = m1; m1 = cost; idx = j;
				} else if(cost < m2) {
					m2 = cost;
				}
			}
			min1 = m1; min2 = m2; index1 = idx;
		}
		
		return min1;
	}

}
