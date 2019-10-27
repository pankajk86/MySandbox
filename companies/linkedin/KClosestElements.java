package linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {

	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 9};
		int k = 4, x = 10;
		
		List<Integer> result = kClosest(a, k, x);
		System.out.println(result);
		
		result = kClosestElements(a, k, x);
		System.out.println(result);
	}

	/*
	 * Time: O(n)
	 */
	private static List<Integer> kClosestElements(int[] a, int k, int x) {
		List<Integer> result = new ArrayList<>();
		if(a == null || a.length == 0) return result;
		
		int left = 0, right = a.length - 1;
		while(right - left >= k) {
			if(Math.abs(a[left] - x) > Math.abs(a[right] - x)) left++;
			else right--;
		}
		
		for(int i = left; i <= right; i++) result.add(a[i]);
		return result;
	}

	/*
	 * Time: O(nlogn)
	 */
	private static List<Integer> kClosest(int[] a, int k, int x) {
		List<Integer> result = new ArrayList<>();
		if(a == null || a.length == 0) return result;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
			if(a1[1] != a2[1]) return a1[1] - a2[1];
			else return a1[0] - a2[0];
		});
		
		for(int i = 0; i < a.length; i++)
			pq.add(new int[] {a[i], Math.abs(a[i] - x)});
		
		while(k-- > 0 && !pq.isEmpty())
			result.add(pq.poll()[0]);
		
		Collections.sort(result);
		return result;
	}
}
