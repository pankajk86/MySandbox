package google;

public class LongestLineOfConsecutiveOneInMatrix {

	public static void main(String[] args) {
		int[][] a = {
				{0, 1, 1, 0},
				{0, 1, 1, 0},
				{0, 0, 0, 1}
			};
		int result = longestLine(a);
		System.out.println(result);
	}

	private static int longestLine(int[][] a) {
		if(a == null || a.length == 0 || a[0].length == 0) return 0;
		
		int rows = a.length, cols = a[0].length, result = 0;
		int[] col = new int[cols];
		int[] diag = new int[rows + cols];
		int[] antiD = new int[rows + cols];
		
		for(int i = 0; i < rows; i++) {
			int row = 0;
			for(int j = 0; j < cols; j++) {
				if(a[i][j] == 1) {
					row++;
					col[j]++;
					diag[j + i]++;
					antiD[j - i + rows]++;
					// max of all the above four elements and result
					result = Math.max(result, Math.max(row, Math.max(col[j], Math.max(diag[j + i], antiD[j - i + rows]))));
				} else {
					row = 0; col[j] = 0; diag[j + i] = 0; antiD[j - i + rows] = 0;
				}
			}
		}
		return result;
	}

}
