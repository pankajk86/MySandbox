package google;

public class LongestIncreasingPathInMatrix {

	private static final int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) {
		int[][] a = { 
				{ 9, 9, 4 }, 
				{ 6, 6, 8 },
				{ 2, 1, 1 } 
			};

		int result = getLongestIncreasingPath(a);
		System.out.println(result);
	}

	private static int getLongestIncreasingPath(int[][] a) {
		if (a.length == 0)
			return 0;

		int result = 0;
		int rows = a.length, cols = a[0].length;
		int[][] cache = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int len = dfs(a, i, j, rows, cols, cache);
				result = Math.max(result, len);
			}
		}
		return result;
	}

	private static int dfs(int[][] a, int i, int j, int rows, int cols, int[][] cache) {
		if(cache[i][j] != 0) return cache[i][j];
		int result = 1;
		
		for(int[] dir: dirs) {
			int x = i + dir[0], y = j + dir[1];
			
			if(x < 0 || x >= rows || y < 0 || y >= cols || a[x][y] <= a[i][j])
				continue;
			
			int len = 1 + dfs(a, x, y, rows, cols, cache);
			result = Math.max(result, len);
		}
		cache[i][j] = result;
		return result;
	}

}
