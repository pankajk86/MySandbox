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
