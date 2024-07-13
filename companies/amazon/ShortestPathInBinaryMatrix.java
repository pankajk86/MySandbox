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
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0, 0, 1});
		a[0][0] = 1;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0], c = curr[1];

			if (r == n - 1 && c == n - 1) return curr[2];

			for(int[] dir : dirs) {
				int nr = r + dir[0], nc = c + dir[1];
				if (nr >= 0 && nr < n && nc >= 0 && nc < n && a[nr][nc] == 0) {
					q.add(new int[]{nr, nc, curr[2] + 1});
					a[nr][nc] = 1;
				}
			}
		}
		return -1;
	}

}
