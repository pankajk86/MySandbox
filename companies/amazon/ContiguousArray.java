package amazon;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 0, 1, 0, 1, 0, 1 };
		int result = findMaxLength(a);
		System.out.println(result);
	}

	private static int findMaxLength(int[] a) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == 0) a[i] = -1;
		}
		
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		int result = 0, sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			sum += a[i];     // sum += a[i] == 0 ? -1 : 1; // if changing the input array is not allowed.
			if(map.containsKey(sum))
				result = Math.max(result, i - map.get(sum));
			else map.put(sum, i);
		}
		
		return result;
	}

}
