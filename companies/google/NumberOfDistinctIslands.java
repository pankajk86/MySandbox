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
		
		int result = countDistinctIslandsII(grid);
		System.out.println(result);
	}

	private static int countDistinctIslandsII(int[][] a) {
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(a[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					helper(a, i, j, sb, "o");
					set.add(sb.toString());
					a[i][j] = 0;
				}
			}
		}
		System.out.println(set);
		return set.size();
	}

	private static void helper(int[][] a, int i, int j, StringBuilder sb, String dir) {
		if(i < 0 || i >= a.length || j < 0 || j >= a[0].length || a[i][j] == 0) return;
		
		sb.append(dir);
		a[i][j] = 0;
		
		helper(a, i - 1, j, sb, "u");
		helper(a, i + 1, j, sb, "d");
		helper(a, i, j - 1, sb, "l");
		helper(a, i, j + 1, sb, "r");
		
		sb.append("b"); // back
	}

	@SuppressWarnings("unused")
	private static int countDistinctIslands(int[][] a) {
		if(a == null || a.length == 0) return 0;
		Set<String> set = new HashSet<>();
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[0].length; j++) {
				if(a[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					dfs(a, i, j, 0, 0, sb);
					set.add(sb.toString());
					a[i][j] = 0;
				}
			}
		}
		return set.size();
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
