package facebook;

public class ValidPalindromeII {

	public static void main(String[] args) {
		String s = "aguokepatgbnvfqmgmlcupuuffuupuculmgmqfvnbgtapekouga";
		boolean result = validPalindrome(s);
		System.out.println(result);
	}

	private static boolean validPalindrome(String s) {
		return isPalindrome(s, 0, s.length() - 1, 0);
	}

	private static boolean isPalindrome(String s, int start, int end, int count) {
		if (count > 1) return false;

		for (int i = start, j = end; i <= j; i++, j--) {
			if (s.charAt(i) == s.charAt(j)) continue;
			return isPalindrome(s, i + 1, j, count + 1) || isPalindrome(s, i, j - 1, count + 1);
		}
		return true;
	}

}
