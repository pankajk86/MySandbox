package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

	private static int dirs[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, 
												{ 1, -1 }, { -1, 1 }, { -1, -1 }, { 1, 1 } };
	
	public static void main(String[] args) {
		int[][] a = { { 0, 0, 0 }, 
				      { 1, 1, 0 }, 
				      { 1, 1, 0 } 
				    };
		
		int result = shortestPath(a);
		System.out.println(result);
	}

	private static int shortestPath(int[][] a) {
		if(a == null || a.length == 0) return -1;
		int n = a.length;
		if(a[0][0] == 1 || a[n - 1][n - 1] == 1) return -1;
		
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> q = new LinkedList<>();
		visited[0][0] = true;
		q.add(new int[] {0, 0});
		int size = q.size(), result = 0;
		
		while(!q.isEmpty()) {
			for(int i = 0; i < size; i++) {
				int[] curr = q.poll();
				
				if(curr[0] == n - 1 && curr[1] == n - 1) 
					return result + 1;
				
				for(int[] dir: dirs) {
					int x = curr[0] + dir[0], y = curr[1] + dir[1];
					if(x >= 0 && x < n && y >= 0 && y < n && a[x][y] == 0 && !visited[x][y]) {
						q.add(new int[] {x, y});
						visited[x][y] = true;
					}
				}
			}
			result++;
			size = q.size();
		}
		return -1;
	}

}
