package google;

public class RangeSumQueryMutable2D {

	public static void main(String[] args) {
		int[][] matrix = {
				  {3, 0, 1, 4, 2},
				  {5, 6, 3, 2, 1},
				  {1, 2, 0, 1, 5},
				  {4, 1, 0, 1, 7},
				  {1, 0, 3, 0, 5}
				};
		
		NumMatrixII nm = new NumMatrixII(matrix);
		System.out.println(nm.sumRegion(2, 1, 4, 3));
		nm.update(3, 2, 2);
		System.out.println(nm.sumRegion(2, 1, 4, 3));
	}

}

class NumMatrixII {
	
	int rows = 0, cols = 0;
	private int[][] t = null;
	private int[][] matrix = null;
	
	public NumMatrixII(int[][] matrix) {
		this.matrix = matrix;
        rows = matrix.length; 
        cols = rows > 0 ? matrix[0].length : 0;
        
        if(rows > 0 && cols > 0) {
        	t = new int[rows + 1][cols + 1];
        	
        	for(int i = 1; i <= rows; i++)
        		t[i][1] = matrix[i - 1][0] + t[i - 1][1];
        	
        	for(int j = 1; j <= cols; j++)
        		t[1][j] = matrix[0][j - 1] + t[1][j - 1];
        	
        	for(int i = 2; i <= rows; i++) {
        		for(int j = 2; j <= cols; j++) 
        			t[i][j] = t[i - 1][j] + t[i][j - 1] + matrix[i - 1][j - 1] - t[i - 1][j - 1];
        	}
        }
    }
    
    public void update(int row, int col, int val) {
        int diff = val - this.matrix[row][col];
        
        for(int i = row + 1; i <= rows; i++) {
        	for(int j = col + 1; j <= cols; j++)
        		t[i][j] += diff;
        }
        this.matrix[row][col] = val;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	
    	row1 += 1; col1 += 1; row2 += 1; col2 += 1;
    	
    	int total = t[row2][col2];
    	int topVal = t[row1 - 1][col2];
    	int sideVal = t[row2][col1 - 1];
    	int diagVal = t[row1 - 1][col1 - 1];
    	
        return total - topVal - sideVal + diagVal;
    }
}
