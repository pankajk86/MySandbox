package google;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {

	public static void main(String[] args) {
		int[] quality = { 10, 20, 5 };
		int[] wage = { 70, 50, 30 };
		int k = 2;
		
		double result = minCost(quality, wage, k);
		System.out.println(result);
	}

	private static double minCost(int[] quality, int[] wage, int k) {
		int n = quality.length;
		double[][] workers = new double[n][2];
		
		for(int i = 0; i < n; i++)
			workers[i] = new double[] {(double) wage[i] / quality[i], (double) quality[i]};
		
		Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0])); // sorted by minimum ratio
		PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder()); // max heap for quality 
		double result = Double.MAX_VALUE;
		int totalQuality = 0;
		
		for(double[] w: workers) {
			totalQuality += w[1];
			pq.add(w[1]);
			
			if(pq.size() > k) totalQuality -= pq.poll();
			if(pq.size() == k) result = Math.min(result, w[0] * totalQuality);
		}
		
		return result;
	}

}
