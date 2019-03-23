package google;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtmostTwoDistinctCharacters {

	public static void main(String[] args) {
		String s = "abaccc";
		int result = longestSubstring(s);
		System.out.println(result);
	}

	private static int longestSubstring(String s) {
		String result = "";
		Map<Character, Integer> map = new HashMap<>();
		
		for(int i = 0, j = 1; j <= s.length(); ) {
			String temp = s.substring(i, j);
			char c = s.charAt(j - 1);
			
			if(map.containsKey(c) || map.size() < 2) {
				map.put(c, map.getOrDefault(c, 0) + 1);
				if(temp.length() > result.length()) {
					result = temp;
				}
				j++;
			} else {
				while(map.size() == 2) {
					char ch = s.charAt(i);
					int freq = map.get(ch);
					if(freq > 1)
						map.put(ch, freq - 1);
					else map.remove(ch);
					i++;
				}
			}
		}
		
		return result.length();
	}

}
