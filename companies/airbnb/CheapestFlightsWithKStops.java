package airbnb;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CheapestFlightsWithKStops {

	public static void main(String[] args) {
		int n = 3;
		int[][] flights = {
				{0, 1, 100},
				{1, 2, 100},
				{0, 2, 500},
		};
		int src = 0, dst = 2, k = 0;
		
		int result = findCheapestPrice(n, flights, src, dst, k);
		System.out.println(result);
	}

	private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		
		Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
		
		for(int[] f: flights) {
			if(!prices.containsKey(f[0]))
				prices.put(f[0], new HashMap<>());
			prices.get(f[0]).put(f[1], f[2]);
		}
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return Integer.compare(a[0], b[0]);
			}
		});
		
		pq.add(new int[] {0, src, k + 1});
		
		while(!pq.isEmpty()) {
			int[] top = pq.remove();
			int price = top[0], city = top[1], stops = top[2];
			
			if(city == dst) return price;
			
			if(stops > 0) {
				Map<Integer, Integer> map = prices.getOrDefault(city, new HashMap<>());
				for(int neighbor: map.keySet()) 
					pq.add(new int[] {price + map.get(neighbor), neighbor, stops - 1});
			}
		}
		
		return -1;
	}

}
