package facebook;

import java.util.Stack;

public class MinimumAddToMakeParenthisisValid {

	public static void main(String[] args) {
		String s = "())((())(((";
		int result = minAdd(s);
		System.out.println(result);
	}
	
	private static int minAdd(String s) {
		int left = 0, right = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') right++;
			else if(right > 0) right--;
			else left++;
		}
		return left + right;
	}

}
