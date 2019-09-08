package microsoft;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSums {

	public static void main(String[] args) {
		int[] a = { 1, 7, 11 };
		int[] b = { 2, 4, 6 };
		int k = 3;
		
		List<int[]> result = kSmallestPairs(a, b, k);
		for(int[] pair: result) 
			System.out.println(pair[0] + ", " + pair[1]);
	}

	private static List<int[]> kSmallestPairs(int[] a, int[] b, int k) {
		List<int[]> result = new ArrayList<>();
		if(a.length == 0 || b.length == 0 || k == 0)
			return result;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return (a[0] + a[1]) - (b[0] + b[1]);
			}
		});
		
		for(int i = 0; i < a.length; i++)
			pq.add(new int[] {a[i], b[0], 0});
		
		while(k-- > 0 && !pq.isEmpty()) {
			int[] curr = pq.poll();
			result.add(new int[] {curr[0], curr[1]});
			if(curr[2] == b.length - 1)
				continue;
			pq.add(new int[] {curr[0], b[curr[2] + 1], curr[2] + 1});
		}
		
		return result;
	}

}

