package amazon;

import java.util.ArrayList;
import java.util.List;

public class MissingElementInSortedArray {

	public static void main(String[] args) {
		int[] a = { 4, 7, 9, 10 };
		int k = 10;
		
		int result = missingElement(a, k);
		System.out.println(result);
	}

	private static int missingElement(int[] a, int k) {
		List<Integer> cache = new ArrayList<>();
		int val = a[0], i = 0;
		
		for(; val <= Integer.MAX_VALUE; val++) {
			if(a[i] == val) { 
				i++;
				if(i == a.length - 1) break;
			}
			else {
				cache.add(val);
				if(cache.size() == k) return cache.get(cache.size() - 1);
			}
		}
		
		int result = val + 1 + k - cache.size();
		return result;
	}

}
