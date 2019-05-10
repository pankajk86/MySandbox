package microsoft;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

	private static int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public static void main(String[] args) {
		int[][] matrix = {
				{1,2,2,3,5},
				{3,2,3,4,4},
				{2,4,5,3,1},
				{6,7,1,4,5},
				{5,1,1,2,4}
		};
		
		List<int[]> result = pacificAtlantic(matrix);
		
		for(int[] r: result)
			System.out.println(r[0] + ", " + r[1]);
	}

	private static List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> result = new ArrayList<>();
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return result;
		
		int m = matrix.length, n = matrix[0].length;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		
		for(int i = 0; i < m; i++) {
			dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
			dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
		}
		
		for(int i = 0; i < n; i++) {
			dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
			dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
		}
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(pacific[i][j] && atlantic[i][j])
					result.add(new int[] {i, j});
			}
		}
		return result;
	}

	private static void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j) {
		int m = matrix.length, n = matrix[0].length;
		
		if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || matrix[i][j] < height)
			return;
		
		visited[i][j] = true;
		
		for(int [] d: dir) {
			dfs(matrix, visited, matrix[i][j], i + d[0], j + d[1]);
		}
	}

}
