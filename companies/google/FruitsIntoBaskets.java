package google;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets {

	public static void main(String[] args) {
		int[] a = { 4, 1, 1, 1, 3, 1, 7, 5 };// { 1, 2, 3, 2, 2 };
		int result = totalFruit(a);
		System.out.println(result);
	}

	private static int totalFruit(int[] a) {
		int result = Integer.MIN_VALUE;
		int i = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for(int j = 0; j < a.length; j++) {
			map.put(a[j], map.getOrDefault(a[j], 0) + 1);
			
			while(map.size() > 2) {
				map.put(a[i], map.get(a[i]) - 1);
				if(map.get(a[i]) == 0) 
					map.remove(a[i]);
				i++;
			}
			result = Math.max(result, j - i + 1);
		}

		return result;
	}

}