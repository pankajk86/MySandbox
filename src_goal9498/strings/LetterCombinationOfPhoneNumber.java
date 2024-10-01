package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {

	private static String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static void main(String[] args) {
		String digits = "23";
		List<String> result = getCombinations(digits);
		System.out.println(result);
	}

	private static List<String> getCombinations(String digits) {
		List<String> result = new ArrayList<>();
		dfs(digits, result, new StringBuilder());
		return result;
	}

	private static void dfs(String s, List<String> result, StringBuilder sb) {
		if (s.isEmpty()) {
			result.add(sb.toString());
			return;
		}

		String curr = map[s.charAt(0) - '2'];
		for (char c : curr.toCharArray()) {
			sb.append(c);
			dfs(s.substring(1), result, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
