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

	private static int subArraySum(int[] a, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0, result = 0;
		map.put(0, 1);
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
			
			if(map.containsKey(sum - target))
				result += map.get(sum - target);
			
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return result;
	}
}
