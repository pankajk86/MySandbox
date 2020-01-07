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
		int[] start = { 0, 4 }, dest = { 4, 4 };
		
		boolean result = hasPath(maze, start, dest);
		System.out.println(result);
	}

	private static boolean hasPath(int[][] m, int[] start, int[] dest) {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[m.length][m[0].length];
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			if(curr[0] == dest[0] && curr[1] == dest[1]) return true;
			
			for(int[] dir: dirs) {
				int x = curr[0], y = curr[1];
				while(isValid(m, x + dir[0], y + dir[1])) {
					x += dir[0]; y += dir[1];
				}
				
				if(!visited[x][y]) {
					q.add(new int[] {x, y});
					visited[x][y] = true;
				}
			}
		}
		return false;
	}

	private static boolean isValid(int[][] m, int i, int j) {
		return i >= 0 && i < m.length && j >= 0 && j < m[0].length && m[i][j] != 1;
	}

}
