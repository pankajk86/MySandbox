package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

	public static void main(String[] args) {
		String s = "eklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmou", p = "yqrbg";
		List<Integer> result = findAnagrams(s, p);
		System.out.println(result);
	}

	private static List<Integer> findAnagrams(String s, String p) {

		List<Integer> result = new ArrayList<>();
		Map<Integer, Long> map = new HashMap<>();
		int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
		char[] sarr = s.toCharArray();
		int n = p.length(); 
		long product = 1, targetProduct = 1;
		
		for(int i = 0; i < n; i++) {
			product *= prime[sarr[i] - 'a'];
			targetProduct *= prime[p.charAt(i) - 'a'];
		}
		
		map.put(0, product);
		
		for(int i = 1; i <= sarr.length - n; i++) {
			product /= prime[sarr[i - 1] - 'a'];
			product *= prime[sarr[i + n - 1] - 'a'];
			map.put(i, product);
		}
		
		for(Map.Entry<Integer, Long> entry: map.entrySet()) {
			if(entry.getValue() == targetProduct)
				result.add(entry.getKey());
		}
		
		return result;
	}

}
