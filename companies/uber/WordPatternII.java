package uber;

import java.util.HashMap;
import java.util.Map;

public class WordPatternII {

	public static void main(String[] args) {
		String pattern = "abab", str = "redblueredblue";
		boolean result = wordPatternMatch(pattern, str);
		System.out.println(result);
	}

	private static boolean wordPatternMatch(String pattern, String str) {

		if(pattern.length() == 0 && str.length() == 0)
			return true;
		
		if(pattern.length() == 0)
			return false;
		
		Map<Character, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		
		boolean result = helper(pattern, str, 0, 0, map1, map2);
		return result;
	}

	private static boolean helper(String pattern, String str, int i, int j, Map<Character, Integer> map1,
			Map<String, Integer> map2) {

		if(i == pattern.length() && j == str.length())
			return true;
		
		if(i >= pattern.length() || j >= str.length())
			return false;
		
		for(int k = j+1; k <= str.length(); k++) {
			String temp = str.substring(j, k);
			char c = pattern.charAt(i);
			Integer prevPatternKey = map1.put(c, i);
			Integer prevTempKey = map2.put(temp, i);
			
			if(prevPatternKey == prevTempKey) {
				if(helper(pattern, str, i+1, k, map1, map2)) {
					return true;
				}
			}
			map1.put(c, prevPatternKey);
			map2.put(temp, prevTempKey);
		}
		
		return false;
	}

}
