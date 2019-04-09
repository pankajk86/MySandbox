package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome {

	public static void main(String[] args) {
		String s = "abccccddeeefffffggggggghhh";
		int result = longestPalindrome(s);
		System.out.println(result);
		
		String result2 = longestPalindromeString(s);
		System.out.println(result2);
	}
	
	private static int longestPalindrome(String s) {
		if(s == null || s.isEmpty()) return 0;
		
		Set<Character> set = new HashSet<>();
		for(char c: s.toCharArray()) {
			if(set.contains(c)) set.remove(c);
			else set.add(c);
		}
		
		return set.size() == 0 ? s.length() : (s.length() - set.size() + 1);
	}

	/**
	 * This one, I was just fiddling with getting the longest palindrome String.
	 * Not sure, if this the best way to do that, though.
	 * 
	 * @param s
	 * @return
	 */
	private static String longestPalindromeString(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c: s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		Set<Character> set = new HashSet<>(); 
		for(char c: s.toCharArray()) {
			if(set.contains(c)) set.remove(c);
			else set.add(c);
		}
		
		char singleChar = '\0';
		for(char c: set) {
			singleChar = c;
			map.put(c, map.get(c) - 1);
			if(map.get(c) == 0) map.remove(c);
		}
		
		StringBuilder sb = new StringBuilder();
		int start = 0;
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			if(start == 0) {
				for(int i = 0; i < entry.getValue(); i++)
					sb.append(entry.getKey());
				start++;
			} else {
				for(int i = 0; i < entry.getValue() / 2; i++)
					sb.insert(0, entry.getKey());
				for(int i = 0; i < entry.getValue() / 2; i++)
					sb.append(entry.getKey());
			}
		}
		
		sb.insert(sb.length() / 2, singleChar);
		return sb.toString();
	}
}
