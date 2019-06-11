package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class CampusBikes {

	public static void main(String[] args) {
		int[][] workers = { { 0, 0 }, { 2, 1 } };
		int[][] bikes = { { 1, 2 }, { 3, 3 } };

		int[] result = assignBikes(workers, bikes);
		for(int i: result) System.out.print(i + " ");
	}

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
