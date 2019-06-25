package amazon;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

	public static void main(String[] args) {
		int[][] a = {
				{ 2, 1, 1 },
				{ 1, 1, 0 },
				{ 0, 1, 1 }
		};
		
		int result = timeToRot(a);
		System.out.println(result);
	}

	private static int timeToRot(int[][] a) {
		if(a == null || a.length == 0) return -1;
		int rows = a.length, cols = a[0].length;
		int result = 0;
		
		Queue<int[]> q = new LinkedList<>();
		int fresh = 0;
		
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if(a[i][j] == 2) q.add(new int[] {i, j});
				else if(a[i][j] == 1) fresh++;
			}
		}
		
		if(fresh == 0) return 0;
		int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
		
		while(!q.isEmpty()) {
			result++;
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] p = q.poll();
				
				for(int[] dir: dirs) {
					int x = p[0] + dir[0], y = p[1] + dir[1];
					if(x >= 0 && x < rows && y >= 0 && y < cols && a[x][y] == 1) {
						a[x][y] = 2;
						q.add(new int[] {x, y});
						fresh--;
					}
				}
			}
		}
		
		return fresh == 0 ? result - 1 : -1;
	}

}
