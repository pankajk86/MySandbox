package uber;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

	private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public static void main(String[] args) {
		int inf = Integer.MAX_VALUE;
		int[][] a = {
				{ inf, -1, 0, inf },
				{ inf, inf, inf, -1 },
				{ inf, -1, inf, -1 },
				{ 0, -1, inf, inf }
		};
		
		populateArraysWithDFS(a);
		print(a);

		int[][] b = {
				{ inf, -1, 0, inf },
				{ inf, inf, inf, -1 },
				{ inf, -1, inf, -1 },
				{ 0, -1, inf, inf }
		};

		System.out.println("==============");
		populateArraysWithBFS(b);
		print(b);
	}

	private static void populateArraysWithBFS(int[][] a) {
		int m = a.length, n = a[0].length;
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0) {
					q.add(new int[]{i, j});
				}
			}
		}

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			for (int[] dir : dirs) {
				int x = curr[0] + dir[0], y = curr[1] + dir[1];
				if (x < 0 || x >= m || y < 0 || y >= n || a[x][y] != Integer.MAX_VALUE) continue;

				a[x][y] = a[curr[0]][curr[1]] + 1;
				q.add(new int[]{x, y});
			}
		}
	}

	private static void print(int[][] a) {
		for (int[] row : a) System.out.println(Arrays.toString(row));
	}

	private static void populateArraysWithDFS(int[][] a) {
		int rows = a.length;
		if(rows == 0) return;
		int cols = a[0].length;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(a[i][j] == 0)
					dfs(a, i, j, rows, cols, 0);
			}
		}
	}

	private static void dfs(int[][] a, int i, int j, int rows, int cols, int step) {
		if(i < 0 || i >= rows || j < 0 || j >= cols || a[i][j] < 0 || a[i][j] < step) return;

		a[i][j] = step;
		
		for(int[] dir: dirs) {
			int x = i + dir[0], y = j + dir[1];
			dfs(a, x, y, rows, cols, step + 1);
		}
	}

}
