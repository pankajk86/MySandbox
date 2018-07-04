package dp;

public class MaximalSquare {

	public static void main(String[] args) {
		
		int[][] a = {
				{1, 0, 1, 0, 0},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0}
		};
		
		int result = getMaxArea(a);
		System.out.println(result);
	}

	private static int getMaxArea(int[][] a) {

		int side = 0;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				int currMax = 0;
				
				if(i==0 || j==0) {
					currMax = a[i][j];
				} else {
					currMax = a[i][j] == 0 ? 0 : min(a[i-1][j], a[i][j-1], a[i-1][j-1]) + 1;
				}
				
				a[i][j] = currMax;
				side = Math.max(currMax, side);
			}
		}
		
		return side * side;
	}
	
	private static int min(int a, int b, int c) {
		int min = Math.min(Math.min(a, b), c); 
		return min;
	}
}
