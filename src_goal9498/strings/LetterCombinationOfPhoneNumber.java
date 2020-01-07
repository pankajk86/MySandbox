package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
	
	public static void main(String[] args) {
		String digits = "23";
		List<String> result = getCombinations(digits);
		System.out.println(result);
	}
	
	private static List<String> getCombinations(String digits) {
		Map<Integer, String> map = new HashMap<>();
		map.put(2, "abc"); map.put(3, "def"); map.put(4, "ghi"); map.put(5, "jkl");
		map.put(6, "mno"); map.put(7, "pqrs"); map.put(8, "tuv"); map.put(9, "wxyz");
		
		List<String> result = new ArrayList<>();
		helper(digits, map, result, new StringBuilder());
		return result;
	}

	private static void helper(String s, Map<Integer, String> map, List<String> result, StringBuilder sb) {
		if(s.isEmpty()) {
			result.add(sb.toString());
			return;
		}
		
		String letters = map.get(s.charAt(0) - '0');
		
		for(int i = 0; i < letters.length(); i++) {
			sb.append(letters.charAt(i));
			helper(s.substring(1), map, result, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
