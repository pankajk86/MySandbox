package google;

public class DiagonalTraverse {

	public static void main(String[] args) {
//		int[][] a = {
//				{ 1, 2, 3, 4 },
//				{ 5, 6, 7, 8 },
//				{ 9, 10, 11, 12 }
//			};
		int[][] a = {
				{ 3 },
				{ 2 }
			};
		int[] result = diagonalTraverse(a);
		for(int i: result) System.out.print( i + " ");
	}

	private static int[] diagonalTraverse(int[][] a) {
		if(a == null || a.length == 0) return null;
		
		int rows = a.length, cols = a[0].length;
		int[] result = new int[rows * cols];
		result[0] = a[0][0];
		int i = 0, j = 1, k = 1, x = 0, y = 0;
		boolean flag = false;
		
		if(rows == 1 && cols == 1) 
			return result;
		else if(rows == 1) return a[0];
		else if(cols == 1) {
			for(i = 1; i < rows; i++)
				result[k++] = a[i][0];
			return result;
		}
		
		while(i < rows || j < cols) {
			if(i == rows - 1 && j == cols - 1) {
				result[k] = a[i][j];
				break;
			}
			
			if(!flag) {
				for(x = i, y = j; x < rows && y >= 0; x++, y--) {
					result[k++] = a[x][y];
					if(x == rows - 1) break;
				}
				i = x; j = y + 1;
				flag = true;
			} else {
				for(x = i, y = j; x >= 0 && y < cols; x--, y++) {
					result[k++] = a[x][y];
					if(y == cols - 1) break;
				}
				i = x + 1; j = y;
				flag = false;
			}
		}
		return result;
	}

}
