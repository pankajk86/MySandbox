package amazon;

public class MaxIncreaseToKeepCitySkyline {

	public static void main(String[] args) {
		int[][] a = { 
				{ 3, 0, 8, 4 }, 
				{ 2, 4, 5, 7 }, 
				{ 9, 2, 6, 3 }, 
				{ 0, 3, 1, 0 } 
			};
		int result = maxIncrease(a);
		System.out.println(result);
	}

	private static int maxIncrease(int[][] a) {
		if(a == null || a.length == 0) return 0;
		
		int result = 0;
		int rows = a.length, cols = a[0].length;
		int[] row = new int[rows];
		int[] col = new int[cols];
		
		for(int i = 0; i < rows; i++) {
			int max = a[i][0];
			for(int j = 0; j < cols; j++)
				max = Math.max(max, a[i][j]);
			row[i] = max;
		}
		
		for(int j = 0; j < cols; j++) {
			int max = a[0][j];
			for(int i = 0; i < rows; i++)
				max = Math.max(max, a[i][j]);
			col[j] = max;
		}
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++)
				result += Math.min(row[i], col[j]) - a[i][j];
		}
		return result;
	}

}
