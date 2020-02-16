package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

	public static void main(String[] args) {
		//String s = "eklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmou", p = "yqrbg";
		String s = "acbaebabacd", p = "aabc";
		List<Integer> result = findAnagrams(s, p);
		System.out.println(result);
		
		result = findAnagramsII(s, p);
		System.out.println(result);
	}

	/**
	 * BETTER PERFORMANCE.
	 * 
	 * The algorithm is similar to the other solution. Usage of integer array (instead of Map),
	 * improves space complexity.
	 * 
	 * @param s
	 * @param p
	 * @return
	 */
	private static List<Integer> findAnagramsII(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int[] map = new int[26];
		for(char c: p.toCharArray()) map[c - 'a']++;
		int count = 0;
		
		for(int left = 0, right = 0; right < s.length(); ) {
			char r = s.charAt(right++);
			map[r - 'a']--;
			if(map[r - 'a'] >= 0) count++;
			
			while(right - left > p.length()) {
				char l = s.charAt(left++);
				map[l - 'a']++;
				if(map[l - 'a'] > 0) count--;
			}
			
			if(count == p.length()) result.add(left);
		}
		return result;
	}

	private static List<Integer> findAnagrams(String s, String p) {
		if(s == null || s.isEmpty() || p == null || p.isEmpty())
			return null;
		
		Map<Character, Integer> map = new HashMap<>();
		for(char c: p.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		int left = 0, count = map.size();
		List<Integer> result = new ArrayList<>();
		
		for(int right = 0; right < s.length(); right++) {
			char r = s.charAt(right);
			
			if(map.containsKey(r)) {
				map.put(r, map.get(r) - 1);
				if(map.get(r) == 0) count--;
			}
			
			while(count == 0) {
				char l = s.charAt(left);
				
				if(map.containsKey(l)) {
					map.put(l, map.getOrDefault(l, 0) + 1);
					if(map.get(l) > 0) count++;
				}
				
				if(right - left + 1 == p.length())
					result.add(left);
				
				left++;
			}
		}
		return result;
	}
}
