package google;

import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

	private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) {
		int[][] grid = {
				{ 1, 1, 0, 1, 1 },
				{ 1, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 1 },
				{ 1, 1, 0, 1, 1 }
		};
		
		int result = countDistinctIslands(grid);
		System.out.println(result);
	}

	private static int countDistinctIslands(int[][] grid) {
		int rows = grid.length;
		int result = 0;
		if(rows == 0) return result;
		int cols = grid[0].length;
		
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					dfs(grid, i, j, 0, 0, sb);
					String s = sb.toString();
					if(!set.contains(s)) {
						set.add(s);
						result++;
					}
				}
			}
		}
		return result;
	}

	private static void dfs(int[][] grid, int i, int j, int ipos, int jpos, StringBuilder sb) {
		grid[i][j] = 0;
		sb.append(ipos + "" + jpos);
		
		for(int[] dir: dirs) {
			int x = i + dir[0], y = dir[1];
			int xpos = ipos + dir[0], ypos = ipos + dir[1];
			if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1)
				dfs(grid, x, y, xpos, ypos, sb);
		}
	}

}
