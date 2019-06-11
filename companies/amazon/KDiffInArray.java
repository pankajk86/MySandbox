package amazon;

import java.util.HashMap;
import java.util.Map;

public class KDiffInArray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		int k = -1;

		int result = kDiff(a, k);
		System.out.println(result);
	}

	private static int kDiff(int[] a, int k) {
		
		if (a == null || a.length == 0 || k < 0)   return 0;
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		
		for (int i : a) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				// count how many elements in the array that appear more than twice.
				if (entry.getValue() >= 2) {
					count++;
				}
			} else {
				if (map.containsKey(entry.getKey() + k)) {
					count++;
				}
			}
		}

		return count;
	}

}
