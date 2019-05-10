package google;

public class LongestConsecutiveOnesInMatrix {

	public static void main(String[] args) {
		int[][] a = {
				{0, 1, 1, 0 },
				{0, 1, 1, 0 },
				{0, 0, 0, 1 }		
			};
		int result = longestOnes(a);
		System.out.println(result);
	}

	private static int longestOnes(int[][] a) {
		if(a == null || a.length == 0) return 0;
		
		int rows = a.length, cols = a[0].length;
		int result = 0;
		
		int[][] hor = new int[rows][cols];
		int[][] ver = new int[rows][cols];
		int[][] dia = new int[rows][cols];
		int[][] ant = new int[rows][cols];
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(a[i][j] == 1) {
					hor[i][j] = j > 0 ? hor[i][j - 1] + 1 : 1;
					ver[i][j] = i > 0 ? hor[i - 1][j] + 1 : 1;
					dia[i][j] = (i > 0 && j > 0) ? hor[i - 1][j - 1] + 1 : 1;
					ant[i][j] = (i > 0 && j + 1 < cols) ? hor[i - 1][j + 1] + 1 : 1;
					
					int x = Math.max(hor[i][j], ver[i][j]);
					int y = Math.max(dia[i][j], ant[i][j]);
					result = Math.max(result, Math.max(x, y));
				}
			}
		}
		
		return result;
	}

}
