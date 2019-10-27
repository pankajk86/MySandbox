package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSums {

	public static void main(String[] args) {
		int[] a = { 1, 7, 11 };
		int[] b = { 2, 4, 6 };
		int k = 3;
		
		List<List<Integer>> result = kSmallestPairs(a, b, k);
		System.out.println(result);
	}

	private static List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if(a.length == 0 || b.length == 0 || k == 0)
			return result;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0] + x[1]) - (y[0] + y[1]));
		for(int i = 0; i < a.length; i++)
			pq.add(new int[] {a[i], b[0], 0});
		
		while(k-- > 0 && !pq.isEmpty()) {
			int[] curr = pq.poll();
			result.add(Arrays.asList(curr[0], curr[1]));
			if(curr[2] == b.length - 1)
				continue;
			pq.add(new int[] {curr[0], b[curr[2] + 1], curr[2] + 1});
		}
		
		return result;
	}

}

