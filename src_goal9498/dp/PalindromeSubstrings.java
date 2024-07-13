package dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubstrings {

	public static void main(String[] args) {
		String s = "aaa";
		
		int count = countPalindromeSubstrings(s);
		System.out.println("\nTotal # of palindromes: " + count);
	}

	private static int countPalindromeSubstrings(String s) {

		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result += helper(s, i, i);
			result += helper(s, i, i + 1);
		}
		return result;
	}

	private static int helper(String s, int i, int j) {
		int result = 0;
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--; j++;
			result++;
		}
		return result;
	}

}
