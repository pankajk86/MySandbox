package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTreesForGolfEvent {
	
	private static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public static void main(String[] args) {

		List<List<Integer>> forest = new ArrayList<>();
		forest.add(Arrays.asList(1, 2, 3));
		forest.add(Arrays.asList(0, 0, 4));
		forest.add(Arrays.asList(7, 6, 5));

		int result = cutOffTreeMinSteps(forest);
		System.out.println(result);
	}

	private static int cutOffTreeMinSteps(List<List<Integer>> forest) {
		if(forest == null || forest.size() == 0) return 0;
		int m = forest.size(), n = forest.get(0).size();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(forest.get(i).get(j) > 1)
					pq.add(new int[] {i, j, forest.get(i).get(j)});
			}
		}
		
		int[] start = new int[2];
		int result = 0;
		
		while(!pq.isEmpty()) {
			int[] tree = pq.poll();
			int step = minStep(forest, start, tree, m, n);
			
			if(step < 0) return -1;
			result += step;
			
			start[0] = tree[0]; start[1] = tree[1];
		}
		return result;
	}

	private static int minStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
		int result = 0;
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> q = new LinkedList<>();
		
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i = 0; i < size; i++) {
				int[] curr = q.poll();
				
				if(curr[0] == tree[0] && curr[1] == tree[1]) 
					return result;
				
				for(int[] dir: dirs) {
					int nr = curr[0] + dir[0], nc = curr[1] + dir[1];
					if(nr >= 0 && nr < m && nc >= 0 && nc < n && forest.get(nr).get(nc) != 0 && !visited[nr][nc]) {
						q.add(new int[] {nr, nc});
						visited[nr][nc] = true;
					}
				}
			}
			result++;
		}
		return -1;
	}

}
