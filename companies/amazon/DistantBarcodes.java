package amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DistantBarcodes {

	public static void main(String[] args) {
		int[] a = {2, 2, 1, 3};//{ 1, 1, 1, 1, 2, 2, 3, 3 };
		int[] result = rearrangeBarcodes(a);
		
		for(int i: result) System.out.print(i + " ");
	}

	private static int[] rearrangeBarcodes(int[] a) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i: a) map.put(i, map.getOrDefault(i, 0) + 1);
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			// sort by descending order of the second element (freq)
			@Override
			public int compare(int[] a, int[] b) {
				return a[1] == b[1] ? a[0] - b[0] : b[1] - a[1] ;
			}
		});
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet())
			pq.add(new int[] {entry.getKey(), entry.getValue()});
		
		int[] result = new int[a.length];
		int i = 0;
		
		while(!pq.isEmpty()) {
			int[] first = pq.poll();
			result[i++] = first[0];
			
			if(!pq.isEmpty()) {
				int[] second = pq.poll();
				result[i++] = second[0];
				
				if(second[1] > 1)
					pq.add(new int[] {second[0], second[1] - 1});
			}
			
			if(first[1] > 1)
				pq.add(new int[] {first[0], first[1] - 1});
		}
		
		return result;
	}

}
