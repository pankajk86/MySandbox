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

	@SuppressWarnings("unused")
	private static int subArraySum2(int[] a, int target) {

		int i = 0, j = 0, count = 0, sum = a[0];
		
		for(j = 0; j < a.length; ) {
			if(sum < target) {
				j++;
				if(j == a.length) break;
				sum += a[j];
			} else {
				if(sum == target) count++;
				sum -= a[i];
				i++; 
				if(i > j) {
					j++;
					if(j == a.length) break;
					sum += a[j];
				}
			}
		}
		
		while(i < j - 1) {
			sum -= a[i];
			i++;
			if(sum == target) count++;
		}
		
		return count;
	}

}
