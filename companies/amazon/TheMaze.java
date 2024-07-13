package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {
	
	private static int[][] dirs = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) {
		int[][] maze = { 
				{ 0, 0, 1, 0, 0 }, 
				{ 0, 0, 0, 0, 0 }, 
				{ 0, 0, 0, 1, 0 }, 
				{ 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } 
			};
		int[] start = { 0, 4 }, dest = { 3, 2 };
		
		boolean result = hasPath(maze, start, dest);
		System.out.println(result);
	}

	private static boolean hasPath(int[][] a, int[] start, int[] dest) {
		boolean[][] visited = new boolean[a.length][a[0].length];
		return dfs(a, start, dest, visited);
	}

	private static boolean dfs(int[][] a, int[] curr, int[] dest, boolean[][] visited) {
		int r = curr[0], c = curr[1];
		if (r == dest[0] && c == dest[1]) return true;
		if (visited[r][c]) return false;

		visited[r][c] = true;

		for (int[] dir : dirs) {
			int r1 = r, c1 = c;
			while (r1 >= 0 && r1 < a.length && c1 >= 0 && c1 < a[0].length) {
				r1 += dir[0]; c1 += dir[1];
			}
			r1 -= dir[0]; c1 -= dir[1];

			if (dfs(a, new int[]{r1, c1}, dest, visited)) return true;
		}

		return false;
	}


}
