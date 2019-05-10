package uber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberOfIslandsII {
	
	private static int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

	public static void main(String[] args) {
		int m = 3, n = 3;
		int[][] positions = { {0,1}, {1,2}, {2,1}, {1,0}, {0,2}, {0,0}, {1,1} };
		
		List<Integer> result = numOfIslands(m, n, positions);
		System.out.println(result);
	}
	
	private static List<Integer> numOfIslands(int m, int n, int[][] positions) {
		List<Integer> result = new ArrayList<>();
		if(m <= 0 || n <= 0) return result;
		
		int[] parents = new int[m * n];
		Arrays.fill(parents, -1);
		int count = 0;
		
		for(int[] p: positions) {
			int curr = n * p[0] + p[1];
			parents[curr] = curr;
			count++;
			
			for(int[] dir: dirs) {
				int x = p[0] + dir[0], y = p[1] + dir[1];
				int next = n * x + y;
				
				if(x >= 0 && x < m && y >= 0 && y < m && parents[next] != -1) {
					int parentNext = find(parents, next);
					
					if(curr != parentNext) {
						parents[curr] = parentNext;
						curr = parentNext;
						count--;
					}
				}
			}
			result.add(count);
		}
		return result;
	}

	private static int find(int[] parents, int next) {
		if(parents[next] == next) return next;
		parents[next] = find(parents, parents[next]);
		return parents[next];
	}
}
