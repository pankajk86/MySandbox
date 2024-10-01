package linkedin;

import java.util.ArrayList;
import java.util.List;

public class KClosestElements {

	public static void main(String[] args) {
		int[] a = {1, 3, 5, 7, 9};
		int k = 4, x = 10;
		
		List<Integer> result = kClosestElements(a, k, x);
		System.out.println(result);
	}

	/*
	 * Time: O(n)
	 */
	private static List<Integer> kClosestElements(int[] a, int k, int x) {
		List<Integer> result = new ArrayList<>();
		if(a == null || a.length == 0) return result;
		
		int left = 0, right = a.length - 1;
		while(right - left + 1 > k) {
			if(Math.abs(a[left] - x) > Math.abs(a[right] - x)) left++;
			else right--;
		}
		
		for(int i = left; i <= right; i++) result.add(a[i]);
		return result;
	}
}
