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
	
	int[][] t = null;
	
	public NumMatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = rows > 0 ? matrix[0].length : 0;

		if(rows > 0 && cols > 0) {
			t = new int[rows + 1][cols + 1];
			for(int i = 1; i < t.length; i++)
				t[i][1] = t[i - 1][1] + matrix[i - 1][0];
			
			for(int i = 1; i < t[0].length; i++)
				t[1][i] = t[1][i - 1] + matrix[0][i - 1];
			
			for(int i = 2; i < t.length; i++) {
				for(int j = 2; j < t[0].length; j++) {
					t[i][j] = t[i - 1][j] + t[i][j - 1] + matrix[i - 1][j - 1] - t[i - 1][j - 1];
				}
			}
		}
	}
	
	public int sumRegion(int row1, int col1, int row2, int col2) {
		row1++; col1++; row2++; col2++;
		
		int total = t[row2][col2];
		int topVal = t[row1 - 1][col2];
		int sideVal = t[row2][col1 - 1];
		int diagVal = t[row1 - 1][col1 - 1];
		
		return total - topVal - sideVal + diagVal;
	}
}
