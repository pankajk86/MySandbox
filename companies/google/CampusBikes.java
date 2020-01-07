package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class CampusBikes {

	public static void main(String[] args) {
		int[][] workers = { { 0, 0 }, { 2, 1 } };
		int[][] bikes = { { 1, 2 }, { 3, 3 } };

		int[] result = assignBikes(workers, bikes);
		System.out.println(Arrays.toString(result));
		
		result = assignBikes2(workers, bikes);
		System.out.println(Arrays.toString(result));
	}

	/**
	 * Time Complexity: O(n * m)
	 * 
	 * Here, we are leveraging the constraints provided in the question, i.e.
	 * 0 <= workers[i][j], bikes[i][j] < 1000. Hence, the maximum Manhatten distance
	 * between a worker and a bike can be 2000.
	 * 
	 * @param workers
	 * @param bikes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private static int[] assignBikes2(int[][] workers, int[][] bikes) {
		int n = workers.length, m = bikes.length;
		int[] result = new int[n];
		boolean[] assigned = new boolean[n], occupied = new boolean[m];
		List<int[]>[] list = new ArrayList[2001];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				int d = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
				
				if(list[d] == null) list[d] = new ArrayList<>();
				list[d].add(new int[] {i, j});
			}
		}
		
		for(int i = 0; i < 2001; i++) {
			List<int[]> curr = list[i];
			if(curr != null) {
				for(int j = 0; j < curr.size(); j++) {
					int w = curr.get(j)[0], b = curr.get(j)[1];
					if(!assigned[w] && !occupied[b]) {
						result[w] = b;
						assigned[w] = true;
						occupied[b] = true;
					}
				}
			}
		}
		
		return result;
	}

	/**
	 * Time Complexity: O((n * m) * log (n * m))
	 * 
	 * @param workers
	 * @param bikes
	 * @return
	 */
	private static int[] assignBikes(int[][] workers, int[][] bikes) {
		int n = workers.length;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			/*
			 * int [] a or b: [distance, workerIndex, bikeIndex]
			 * sort order: distance, workerIndex, bikeIndex  
			 */
			@Override
			public int compare(int[] a, int[] b) {
				if(a[0] != b[0]) return a[0] - b[0];
				else return a[1] == b[1] ? a[2] - b[2] : a[1] - b[1];
			}
		});
		
		for(int i = 0; i < workers.length; i++) {
			int[] worker = workers[i];
			for(int j = 0; j < bikes.length; j++) {
				int[] bike = bikes[j];
				int distance = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
				pq.add(new int[] {distance, i, j});
			}
		}
		
		int[] result = new int[n];
		Arrays.fill(result, -1);
		Set<Integer> assignedBikes = new HashSet<>();
		int count = 0;
		
		while(assignedBikes.size() < n && count < n) {
			int[] pair = pq.poll();
			if(result[pair[1]] == -1 && !assignedBikes.contains(pair[2])) {
				result[pair[1]] = pair[2];
				assignedBikes.add(pair[2]);
				count++;
			}
		}
		return result;
	}

}
