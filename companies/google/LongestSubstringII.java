package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestSubstringII {

	public static void main(String[] args) {
		String s = "ccaabbb"; //"cabbad";
		int result = longestSubstringWithAtMostTwoDistinctCharacters(s);
		System.out.println(result);
		
		result = lengthOfLongestSubstringTwoDistinct(s);
		System.out.println(result);
	}
	
	// CORRECT
	private static int lengthOfLongestSubstringTwoDistinct(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		int i = 0, j = 0, result = 0;
		
		while(j < s.length()) {
			if(map.size() <= 2) {
				map.put(s.charAt(j), j);
				j++;
			}
			
			if(map.size() > 2) {
			   int left = s.length();
			   for(int idx: map.values()) {
				   left = Math.min(left, idx);
			   }
			   map.remove(s.charAt(left));
			   i = left + 1;
			}
			result = Math.max(result, j - i);
		}
		
		return result;
	}

	private static int longestSubstringWithAtMostTwoDistinctCharacters(String s) {

		int i = 0, j = 0, result = 0;
		Set<Character> set = new HashSet<>();
		List<String> list = new ArrayList<>();
		
		while(j < s.length()) {
			set.add(s.charAt(j));
			j++;
			
			if(j == s.length()) break;
			
			if(set.size() == 2 && !set.contains(s.charAt(j))) {
				list.add(s.substring(i, j));
				char curr = s.charAt(j - 1);
				while(i != j - 1) {
					if(s.charAt(i) != curr)
						set.remove(s.charAt(i));
					i++;
				}
			}
		}
		
		list.add(s.substring(i, j));
		
		for(String str: list)
			result = Math.max(result, str.length());
		
		return result;
	}

}
