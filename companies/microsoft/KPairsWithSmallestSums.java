package microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class KPairsWithSmallestSums {

	public static void main(String[] args) {
		int[] a = { 1, 1, 2 };
		int[] b = { 1, 2, 3 };
		int k = 2;
		
		List<int[]> result = kSmallestPairs(a, b, k);
		for(int[] pair: result) 
			System.out.println(pair[0] + ", " + pair[1]);
	}

	private static List<int[]> kSmallestPairs(int[] a, int[] b, int k) {

		List<int[]> result = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Map<Integer, List<int[]>> map = new HashMap<>();
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				int[] pair = {a[i], b[j]};
				int sum = a[i] + b[j];
				
				if(pq.size() < k) {
					pq.add(sum);
					List<int[]> list = map.getOrDefault(sum, new ArrayList<>());
					list.add(pair);
					map.put(sum, list);
				} else {
					if(sum < pq.peek()) {
						int val = pq.poll();
						pq.add(sum);
						map.remove(val);
						List<int[]> list = map.getOrDefault(sum, new ArrayList<>());
						list.add(pair);
						map.put(sum, list);
					}
				}
			}
		}

		for(List<int[]> pair: map.values()) {
			result.addAll(pair);
		}
		
		return result;
	}

}

