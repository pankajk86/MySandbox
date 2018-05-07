package dp;

import java.util.Arrays;

public class CheckSubsequence {

	public static void main(String[] args) {
		String s = "b", t = "c";
		boolean result = checkSubsequenceWithSort(s, t);

		result = checkSubsequence(s, t);
		System.out.println(result);
	}

	private static boolean checkSubsequence(String s, String t) {
		if (t == null) {
			return false;
		}
		
		if(s.isEmpty()) {
			return true;
		}

		boolean result = true;
		int n = s.length();
		int[] dp = new int[n];
		
		int index = t.indexOf(s.charAt(n - 1));
		
		if(index == -1) {
			return false;
		}
		
		dp[n-1] = index;

		for (int i = n - 2; i >= 0; i--) {
			index = t.indexOf(s.charAt(i));
			
			if(index == -1) {
				return false;
			}
			
			if(index > dp[i+1]) {
				result = false;
				break;
			} else {
				dp[i] = index;
			}
		}

		return result;
	}

	private static boolean checkSubsequenceWithSort(String s, String t) {

		if (t == null) {
			return false;
		}

		char[] ss = s.toCharArray();
		Arrays.sort(ss);
		s = String.valueOf(ss);

		char[] tt = t.toCharArray();
		Arrays.sort(tt);
		t = String.valueOf(tt);

		return (t.indexOf(s) != -1);
	}

}
