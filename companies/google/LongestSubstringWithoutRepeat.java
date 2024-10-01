package google;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		String s = "pwwkew";
		int result = longestSubstring(s);
		System.out.println(result);
	}
	
	private static int longestSubstring(String s) {
//		Set<Character> set = new HashSet<>();
		int[] set = new int[256];

		int result = 0;

		for (int i = 0, j = 0; j < s.length(); j++) {
			char c = s.charAt(j);

//			while (set.contains(c)) {
//				set.remove(s.charAt(i++));
//			}
			while (set[c] == 1) {
				set[s.charAt(i++)] = 0;
			}

//			set.add(s.charAt(j));
			set[c] = 1;

			result = Math.max(result, j - i + 1);
		}
		return result;
	}
}
