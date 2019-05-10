package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class CountSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		int[] a = {-1, -1};
		List<Integer> result = countSmaller(a);
		System.out.println(result);
	}

	private static List<Integer> countSmaller(int[] a) {
		List<Integer> result = new ArrayList<>();
		if(a == null || a.length == 0) return result;
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i = a.length - 1; i >= 0; i--) {
			List<Integer> temp = new ArrayList<>();
			while(!pq.isEmpty() && pq.peek() >= a[i]) {
				temp.add(pq.poll());
			}
			
			result.add(0, pq.size());
			pq.add(a[i]);
			if(temp.size() > 0) {
				for(int j = 0; j < temp.size(); j++)
					pq.add(temp.get(j));
			}
		}
		return result;
	}

	private static List<Integer> countSmaller2(int[] a) {
		List<Integer> result = new ArrayList<>();
		
		if(a == null || a.length == 0) return result;
		result.add(0);
		
		for(int i = a.length - 2; i >= 0; i--) {
			if(a[i] > a[i + 1])
				result.add(0, result.get(0) + 1);
			else result.add(0, result.get(0));
		}
		
		return result;
	}

}
