package google;

import java.util.HashMap;
import java.util.Map;

public class ThreeSumWithMultiplicity {

	public static void main(String[] args) {
		int[] a = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
		int target = 8;
		int result = threeSumMutli(a, target);
		System.out.println(result);
	}

	private static int threeSumMutli(int[] a, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		int result = 0, mod = 1000000007;
		
		for(int i = 0; i < a.length; i++) {
			result = (result + map.getOrDefault(target - a[i], 0)) % mod;
			for(int j = 0; j < i; j++) {
				int temp = a[i] + a[j];
				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}
		}
		
		return result;
	}

}
