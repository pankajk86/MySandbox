package google;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		String s = "pqrstpqrstaqrs";
		int result = longestSubstringShort(s);
		System.out.println(result);
		
		result = longestSubstring(s);
		System.out.println(result);
	}
	
	// go for this
	private static int longestSubstring(String s) {
		if(s == null || s.isEmpty()) return 0;
		int[] map = new int[256];
		int result = 0, left = 0;
		
		for(int right = 0; right < s.length(); right++) {
			char c = s.charAt(right);
			left = Math.max(map[c], left);
			map[c] = right + 1;
			result = Math.max(result, right - left + 1);
		}
		
		return result;
	}
	
	private static int longestSubstringShort(String s) {
		int result = 0, i = 0, j = 0;
		Set<Character> set = new HashSet<>();
		
		while(j < s.length()) {
			if(!set.contains(s.charAt(j))) {
				set.add(s.charAt(j));
				j++;
				result = Math.max(result, j - i);
			} else {
				set.remove(s.charAt(i));
				i++;
			}
		}
		return result;
	}
}
