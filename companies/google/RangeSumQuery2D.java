package google;

public class RangeSumQuery2D {

	public static void main(String[] args) {
		int[][] matrix = {
				  {3, 0, 1, 4, 2},
				  {5, 6, 3, 2, 1},
				  {1, 2, 0, 1, 5},
				  {4, 1, 0, 1, 7},
				  {1, 0, 3, 0, 5}
				};
		
		NumMatrix nm = new NumMatrix(matrix);
		int result = nm.sumRegion(1, 2, 2, 4);
		System.out.println(result);
	}

}


class NumMatrix {
	
	int[][] map = null;
	
	public NumMatrix(int[][] a) {
		int m = a.length, n = a[0].length;
		map = new int[m + 1][n + 1];
		for(int i = 1; i <= m ; i++)
			map[i][1] = map[i - 1][1] + a[i - 1][0];

		for(int i = 1; i <= n; i++)
			map[1][i] = map[1][i - 1] + a[0][i - 1];

		for(int i = 2; i <= m; i++) {
			for(int j = 2; j <= n; j++) {
				map[i][j] = map[i - 1][j] + map[i][j - 1] + a[i - 1][j - 1] - map[i - 1][j - 1];
			}
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		row1++; col1++; row2++; col2++;
		
		int total = map[row2][col2];
		int topVal = map[row1 - 1][col2];
		int sideVal = map[row2][col1 - 1];
		int diagVal = map[row1 - 1][col1 - 1];
		
		return total - topVal - sideVal + diagVal;
	}
}
