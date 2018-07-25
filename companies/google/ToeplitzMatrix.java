package google;

public class ToeplitzMatrix {

	public static void main(String[] args) {
		int[][] a = {
				  {1, 2, 3, 4, 7},
				  {5, 1, 2, 3, 4},
				  {9, 5, 1, 2, 3},
				  {6, 9, 5, 1, 2}
				};
		
		boolean result = isToeplitzMatrix(a);
		System.out.println(result);
	}

	private static boolean isToeplitzMatrix(int[][] a) {

		int rows = a.length, cols = rows > 0 ? a[0].length : 0;
		int starti = rows - 2, startj = 0;
		int endi = rows - 1, endj = 1;
		
		while(starti >= 0 && startj < cols && 
				endi >= 0 && endj < cols) {
			int val = a[starti][startj];
			
			for(int i = starti, j = startj; (i <= endi && j <= endj); i++, j++) {
				if(a[i][j] != val)
					return false;
			}
			
			if(starti > 0)
				starti--;
			else
				startj++;
			
			if(endj < cols - 1)
				endj++;
			else
				endi--;
		}
		
		return true;
	}

}
