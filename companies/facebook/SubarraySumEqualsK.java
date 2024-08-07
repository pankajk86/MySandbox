package facebook;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 2, 1, 2 }; // { 1, 3, 5, 2, 1, 1 };
		int target = 5;

		int result = subArraySum(a, target);
		System.out.println(result);
	}

	private static int subArraySum(int[] a, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, result = 0;
		map.put(0, 1);

		for (int i : a) {
			sum += i;
			result += map.getOrDefault(sum - k, 0);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return result;
	}
}
