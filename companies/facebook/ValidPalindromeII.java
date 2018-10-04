package facebook;

public class ValidPalindromeII {

	public static void main(String[] args) {
		String s = "aguokepatgbnvfqmgmlcupuuffuupuculmgmqfvnbgtapekouga";
		boolean result = validPalindrome(s);
		System.out.println(result);
	}

	private static boolean validPalindrome(String s) {

		if(s == null) return false;
		if(s.isEmpty()) return true;
		
		int start = 0, end = s.length() - 1;
		
		while(start < end) {
			if(s.charAt(start) == s.charAt(end)) {
				start++; end--;
			} else {
				if(isPalindrome(s, start + 1, end) || isPalindrome(s, start, end - 1))
					return true;
				else return false;
			}
		}
		return true;
	}

	private static boolean isPalindrome(String s, int start, int end) {

		while(start < end) {
			if(s.charAt(start) != s.charAt(end))
				return false;
			start++; end--;
		}
		return true;
	}

}
