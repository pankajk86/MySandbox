package goal9498.dp;

import java.util.ArrayList;
import java.util.List;

public class PalindromeSubstrings {

	public static void main(String[] args) {
		String s = "abcbadef";
		
		int count = countPalindromeSubstrings(s);
		System.out.println("\nTotal # of palindromes: " + count);
	}

	private static int countPalindromeSubstrings(String s) {
		
		int n = s.length(), ans = 0;
		List<String> list = new ArrayList<>();
		
		for(int i=0; i< 2*n - 1; i++) {
			int left = i/2;
			int right = left + i%2;
			
			while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				ans++;
				list.add(s.substring(left, right+1));
				left--;
				right++;
			}
		}
		
		for(String p: list) {
			System.out.print(p + ", ");
		}
		
		return ans;
	}

}
