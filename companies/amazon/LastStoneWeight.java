package amazon;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

	public static void main(String[] args) {
		int[] a = { 1, 2, 1 };
		int result = lastStone(a);
		System.out.println(result);
	}

	private static int lastStone(int[] a) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i: a) pq.add(i);
		
		while(pq.size() > 1) {
			int s1 = pq.poll(), s2 = pq.poll();
			if(s1 != s2)
				pq.add(s1 < s2 ? s2 - s1 : s1 - s2);
		}
		return pq.isEmpty() ? 0 : pq.poll();
	}

}
