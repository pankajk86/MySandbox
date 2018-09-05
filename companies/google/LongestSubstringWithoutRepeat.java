package google;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		String s = "pqrstpqrstaqrs";
		int result = longestSubstring(s);
		System.out.println(result);
		
		result = longestSubstringShort(s);
		System.out.println(result);
	}
	
	// we may go for this
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

	private static int longestSubstring(String s) {
		
		if(s == null || s.isEmpty())
			return 0;

		int window = 0;
		Set<Character> set = new HashSet<>();
		
		for(int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if(!set.contains(current)) {
				set.add(current);
				window++;
			} else break;
		}
		
		for(int i = 1; i < s.length(); i++) {

			if(i + window > s.length())
				break;
			
			set = new HashSet<>();
			int j = i, currentWindow = 0;
			
			for(j = i; j < i + window + 1; j++) {
				if(j < s.length()) {
					char current = s.charAt(j);
					if(set.contains(current))
						break;
					else {
						currentWindow++;
						set.add(current);
					}
				} else break;
			}
			
			if(currentWindow > window) {
				window = currentWindow;
				
				if(j < s.length()) {
					while(!set.contains(s.charAt(j))) {
						window++;
						set.add(s.charAt(j));
						j++;
						if(j == s.length()) break;
					}
				}
			}
		}
		
		return window;
	}

}
