package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {

	private static char[][] pairs = {{'0', '0'}, {'1', '1'}, {'6', '9'}, {'8', '8'}, {'9', '6'}};

	public static void main(String[] args) {
		int n = 3;
		List<String> result = findStrobogrammatic(n);
		System.out.println(result);

		result = findStrobogrammaticMoreIntuitive(n);
		System.out.println(result);
	}

	private static List<String> findStrobogrammaticMoreIntuitive(int n) {
		List<String> result = new ArrayList<>();
		dfs(0, n - 1, new char[n], result);
		return result;
	}

	private static void dfs(int l, int r, char[] carr, List<String> result) {
		if (l > r) {
			result.add(String.valueOf(carr));
			return;
		}

		for (char[] pair : pairs) {
			carr[l] = pair[0];
			carr[r] = pair[1];

			// for odd length strings, like 619. the middle element must be 0, 1, or 8.
			// if it is 6, or 9, then it'd not be valid.
			if (l == r && pair[0] != pair[1]) continue;

			// we avoid strings with leading zeros.
			if (carr.length > 1 && carr[0] == '0') continue;

			dfs(l + 1, r - 1, carr, result);
		}
	}

	private static List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	private static List<String> helper(int n, int m) {
		if(n == 0) return Arrays.asList("");
		if(n == 1) return Arrays.asList("0", "1", "8");
		
		List<String> list = helper(n - 2, m);
		List<String> result = new ArrayList<>();

		for (String s : list) {
			for (char[] pair : pairs) {
				if (pair[0] != '0' || n != m) {
					result.add(pair[0] + s + pair[1]);
				}
			}
		}
		return result;
	}

}
