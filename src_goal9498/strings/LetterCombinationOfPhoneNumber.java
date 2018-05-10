package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfPhoneNumber {
	
	private static List<String> result = new ArrayList<>();
	private static Map<String, String> map = new HashMap<>();

	public static void main(String[] args) {
		String digits = "23";
		
		map.put("2", "abc");
		map.put("3", "def");
		map.put("4", "ghi");
		map.put("5", "jkl");
		map.put("6", "mno");
		map.put("7", "pqrs");
		map.put("8", "tuv");
		map.put("9", "wxyz");
		
		getCombinations(digits, new StringBuilder());
		
		for(String s: result) {
			System.out.print(s + ", ");
		}
	}
	
	private static void getCombinations(String digits, StringBuilder temp) {
		
		if(digits.isEmpty()) {
			result.add(temp.toString());
			return;
		}
		
		String first = String.valueOf(digits.charAt(0));
		String letters = map.get(first);
		
		for(int i=0; i<letters.length(); i++) {
			temp.append(letters.charAt(i));
			getCombinations(digits.substring(1), temp);
			temp.deleteCharAt(temp.length()-1);
		}
	}
}
