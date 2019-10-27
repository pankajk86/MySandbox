package google;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		String s = "pqrstpqrstaqrs";
		int result = longestSubstringShort(s);
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
}
