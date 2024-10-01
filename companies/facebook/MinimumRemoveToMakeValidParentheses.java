package facebook;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {

	public static void main(String[] args) {
		String s = "lee(t(c)o)de)";
		String result = minRemoveToMakeValidWithStack(s);
		System.out.println(result);

		result = minRemoveToMakeValidWithoutStack(s);
		System.out.println(result);

		result = minRemoveToMakeValidWithDeleteCharAt(s);
		System.out.println(result);
	}

	/**
	 * T: O(3 * n) = O(n)
	 * S: O(n)
	 *
	 * @param s
	 * @return
	 */
	private static String minRemoveToMakeValidWithDeleteCharAt(String s) {
		char[] carr = s.toCharArray();
		int count = 0;

		// remove extra ) [by replacing it with *]
		for (int i = 0; i < carr.length; i++) {
			if (carr[i] == '(') count++;
			else if (carr[i] == ')') {
				if (count > 0) count--;
				else carr[i] = '*';
			}
		}

		// remove extra ( [by replacing it with *]
		count = 0;
		for  (int i = carr.length - 1; i >= 0; i--) {
			if (carr[i] == ')') count++;
			else if (carr[i] == '(') {
				if (count > 0) count--;
				else carr[i] = '*';
			}
		}

		StringBuilder sb = new StringBuilder();
        for (char c : carr) {
            if (c != '*') sb.append(c);
        }
		return sb.toString();
	}

	// T = O(n * m), m : # of ( and ).
	private static String minRemoveToMakeValidWithoutStack(String s) {
		int count = 0;
		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c == '(') count++;
			else if (c == ')') {
				if (count > 0) count--;
				else {
					sb.deleteCharAt(i);
					i--;
				}
			}
		}

		for (int i = sb.length() - 1; i >= 0; i--) {
			if (sb.charAt(i) == '(' && count > 0) {
				sb.deleteCharAt(i);
				count--;
			}
		}

		return sb.toString();
	}

	private static String minRemoveToMakeValidWithStack(String s) {
		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') stack.push(new int[]{c, i});
			else if (c == ')') {
				if (!stack.isEmpty() && (char)stack.peek()[0] == '(') stack.pop();
				else stack.push(new int[]{c, i});
			}
		}

		StringBuilder sb = new StringBuilder(s);
		while (!stack.isEmpty()) sb.deleteCharAt(stack.pop()[1]);
		return sb.toString();
	}

}
