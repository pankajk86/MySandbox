package facebook;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

	public static void main(String[] args) {
		int[] a = {23, 2, 4, 6, 7};
		int k = 6;
		
		boolean result = checkSubarraySum(a, k);
		System.out.println(result);
	}

	private static boolean checkSubarraySum(int[] a, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int total = 0;

		for (int i = 0; i < a.length; i++) {
			total += a[i];
			int rem = total % k;
			if (!map.containsKey(rem)) map.put(rem, i);
			else if (i - map.get(rem) > 1) return true;
		}
		return false;
	}

}
