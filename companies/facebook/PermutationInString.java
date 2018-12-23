package facebook;

import java.util.Arrays;

public class PermutationInString {

	public static void main(String[] args) {
		String s1 = "cbab", s2 = "eidbacobo";
		
		long start = System.currentTimeMillis();
		boolean result = checkInclusion(s1, s2);
		System.out.println("Time: " + (System.currentTimeMillis() - start) + "---" + result);
		
		start = System.currentTimeMillis();
		result = checkInclusionII(s1, s2);
		System.out.println("Time: " + (System.currentTimeMillis() - start) + "---" + result);
	}
	
	private static boolean checkInclusionII(String s1, String s2) {
		
		if(s1.isEmpty()) return true;
		if(s1.length() > s2.length()) return false;
		
		int count = 0, p = 0;
		int[] cache = new int[26];
		
		for(int i = 0; i < s1.length(); i++)
			cache[s1.charAt(i) - 'a']++;
		
		for(int i = 0; i < s2.length(); i++) {
			if(cache[s2.charAt(i) - 'a']-- > 0 && ++count == s1.length())
				return true;
			if(i >= s1.length() - 1 && cache[s2.charAt(p++) - 'a']++ >= 0)
				count--;
		}
		
		return false;
	}

	private static boolean checkInclusion(String s1, String s2) {
		
		if(s1.isEmpty()) return true;
		if(s1.length() > s2.length()) return false;
		
		s1 = sort(s1);
		
		for(int i = 0; i < s2.length() - s1.length() + 1; i++) {
			String s = s2.substring(i, i + s1.length());
			s = sort(s);
			if(s.equals(s1)) return true;
		}
			
		return false;
	}

	private static String sort(String s1) {
		char[] c = s1.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

}
