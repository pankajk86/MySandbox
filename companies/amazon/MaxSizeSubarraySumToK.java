package amazon;

import java.util.HashMap;
import java.util.Map;

public class MaxSizeSubarraySumToK {

	public static void main(String[] args) {
		int[] a = { 1, -1, 5, -2, 3 };
		int k = 3;
		
		int result = maxSubArrayLen(a, k);
		System.out.println(result);
	}

	private static int maxSubArrayLen(int[] a, int k) {
		int sum = 0, result = 0;
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];
			if(sum == k) result = i + 1;
			else if(map.containsKey(sum - k))
				result = Math.max(result, i - map.get(sum - k));
			if(!map.containsKey(sum))
				map.put(sum, i);
		}
		
		return result;
	}

}
