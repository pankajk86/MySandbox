package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordPatternI {

	public static void main(String[] args) {
		String pattern = "abab", str = "dog cat cat dog";
		boolean result = wordPattern(pattern, str);
		System.out.println(result);
	}
	
	private static boolean wordPattern(String pattern, String str) {
		
		String[] parts = str.split(" ");
		
		if(parts.length != pattern.length()) {
			return false;
		}
		
		Map<Character, Integer> map1 = new HashMap<>();
		Map<String, Integer> map2 = new HashMap<>();
		
		for(int i = 0; i < parts.length; i++) {
			Integer prevPatternKey = map1.put(pattern.charAt(i), i);
			Integer prevPartKey = map2.put(parts[i], i);
			
			if(prevPatternKey != prevPartKey) 
				return false;
		}
		
		return true;
	}

	@SuppressWarnings("unused")
	private static boolean wordPattern2(String pattern, String str) {

		String[] parts = str.split(" ");
		
		if(parts.length != pattern.length()) {
			return false;
		}
		
		Map<Character, List<Integer>> map = getPatternMap(pattern);
		Set<String> set = new HashSet<>();
		
		for(String s: parts) {
			set.add(s);
		}
		
		if(set.size() != map.size()) {
			return false;
		}
		
		for(List<Integer> list: map.values()) {
			int firstIndex = list.get(0);
			for(int i = 1; i < list.size(); i++) {
				if(!parts[list.get(i)].equals(parts[firstIndex])) {
					return false;
				}
			}
		}
		
		return true;
	}

	private static Map<Character, List<Integer>> getPatternMap(String pattern) {

		Map<Character, List<Integer>> map = new HashMap<>();
		char[] carr = pattern.toCharArray();
		
		for(int i = 0; i < carr.length; i++) {
			List<Integer> list = null;
			if(!map.containsKey(carr[i])) {
				list = new ArrayList<>();
			} else {
				list = map.get(carr[i]);
			}
			list.add(i);
			map.put(carr[i], list);
		}
		
		return map;
	}

}
