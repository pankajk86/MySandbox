package arrays;

import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

	public static void main(String[] args) {
		int n = 100000000;
		
		long start = System.currentTimeMillis();
		int result = countReplacement(n);
		System.out.println("Time taken: " + (System.currentTimeMillis() - start) + ", result: " + result);
		
		// very bad performance
		start = System.currentTimeMillis();
		result = countReplacement2(n);
		System.out.println("Time taken: " + (System.currentTimeMillis() - start) + ", result: " + result);
	}

	private static int countReplacement(int n) {
		Map<Long, Integer> map = new HashMap<>();
		return helper(n, 0, map);
	}

	private static int helper(long n, int count, Map<Long, Integer> map) {
		if(map.containsKey(n))
			return count + map.get(n);
		
		if(n == 1) return count;
		if(n <= 0) return Integer.MAX_VALUE;
		
		int min = 0;
		if(n % 2 == 0)
			min = helper(n / 2, count + 1, map);
		else
			min = Math.min(helper(n - 1, count + 1, map), (helper(n + 1, count + 1, map)));
		
		map.put(n, min - count);
		return min;
	}


	private static int countReplacement2(int n) {
		int[] a = new int[n + 2];

		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				a[i] = a[i / 2] + 1;
			} else {
				a[i + 1] = a[(i + 1) / 2] + 1;
				a[i] = Math.min(a[i-1] + 1, a[i + 1] + 1);
			}
		}

		return a[n];
	}
}
