package uber;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

	public static void main(String[] args) {
		String s = "mallyaaam";
		boolean result = canPermutePalindrome(s);
		System.out.println(result);
	}

	private static boolean canPermutePalindrome(String s) {

		Map<Character, Integer> map = new HashMap<>();
		
		for(char c: s.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		int countOdd = 0;
		
		for(int value: map.values()) {
			if(value % 2 != 0) countOdd++;
			if(countOdd > 1) return false;
		}
		return true;
	}

}
