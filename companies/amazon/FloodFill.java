package amazon;

import java.util.ArrayList;
import java.util.List;

public class FloodFill {
	
	private static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

	public static void main(String[] args) {
		int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		int sr = 1, sc = 1, newColor = 2;
		
		int[][] result = floodFill(image, sr, sc, newColor);
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[0].length; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}
	}

	private static int[][] floodFill(int[][] a, int sr, int sc, int newColor) {
		int rows = a.length, cols = a[0].length;
		boolean[][] visited = new boolean[rows][cols];
		List<int[]> list = new ArrayList<>();
		list.add(new int[] {sr, sc});
		visited[sr][sc] = true;
		
		for(int i = 0; i < list.size(); i++) {
			int[] curr = list.get(i);
			
			for(int[] dir: dirs) {
				int x = curr[0] + dir[0], y = curr[1] + dir[1];
				if(x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y] && a[x][y] == a[sr][sc]) {
					visited[x][y] = true;
					list.add(new int[] {x, y});
				}
			}
		}
		
		for(int[] p: list) {
			a[p[0]][p[1]] = newColor;
		}
		
		return a;
	}

}
