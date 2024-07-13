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

		int[] map = new int[26];
		for (char c : s.toCharArray()) map[c - 'a']++;
		
		int countOdd = 0;
		
		for(int value: map) {
			if(value % 2 != 0) countOdd++;
			if(countOdd > 1) return false;
		}
		return true;
	}

}
