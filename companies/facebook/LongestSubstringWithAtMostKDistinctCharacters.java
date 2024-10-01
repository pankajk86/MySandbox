package facebook;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		String s = "ababbc";
		int k = 2;
		
		int result = longestSubstrKDistinct(s, k);
		System.out.println(result);
	}

	private static int longestSubstrKDistinct(String s, int k) {
		if(s == null || s.isEmpty()) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int result = 0;
		
		for(int i = 0, j = 0; j < s.length(); ) {
			if(map.size() <= k) {
				map.put(s.charAt(j), j);
				j++;
			}
			
			if(map.size() > k) {
				int left = s.length();
				for(int index: map.values())
					left = Math.min(left, index);
				map.remove(s.charAt(left));
				i = left + 1;
			}
			result = Math.max(result, j - i);
		}
		return result;
	}

}
