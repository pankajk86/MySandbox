package dp;

import goal.phase.two.arrays.MaxHistogramArea;

public class MaximalRectangle {

	public static void main(String[] args) {
		
		char[][] a = {
				{'1', '0', '1', '1', '1', '1', '0', '1', '1'}, 
				{'0', '1', '0', '1', '0', '0', '0', '0', '0'}, 
				{'0', '0', '0', '0', '1', '0', '1', '1', '0'}, 
				{'1', '1', '1', '0', '1', '0', '1', '0', '1'}
			};
		
		int result = maximalRectangle(a);
		System.out.println(result);
	}

	private static int maximalRectangle(char[][] matrix) {

		int numRow = matrix.length;
		
		if(matrix.length == 0) {
			return 0;
		}
		
		int numCol = matrix[0].length;
		int[][] a = new int[numRow][numCol];
		
		for(int i= 0; i < numRow; i++) {
			for(int j = 0; j < numCol; j++) {
				a[i][j] = matrix[i][j] - '0';
			}
		}
		
		int[] dp = new int[numCol];
		
		for(int i = 0; i< numCol; i++) {
			dp[i] = a[0][i];
		}
		
		int max = MaxHistogramArea.getMaxArea(dp);
		
		for(int i = 1; i < numRow; i++) {
			for(int j = 0; j < numCol; j++) {
				dp[j] = a[i][j] == 0 ? 0 : dp[j] + a[i][j];
			}
			
			int currentMax = MaxHistogramArea.getMaxArea(dp);
			max = Math.max(max, currentMax);
		}
		
		
		return max;
	}

}
