package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

	public static void main(String[] args) {
		String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc", "deedp" };
		String pattern = "abbac";
		
		List<String> result = findAndReplacePatterns(words, pattern);
		System.out.println(result);
	}

	private static List<String> findAndReplacePatterns(String[] words, String pattern) {
		List<String> result = new ArrayList<>();
		String ePattern = encode(pattern);
		
		for(String word: words) {
			String eWord = encode(word);
			if(ePattern.startsWith(eWord))
				result.add(word);
		}
		
		return result;
	}
	
	private static String encode(String s) {
		Map<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		int count = 1;
		
		for(char c: s.toCharArray()) {
			if(!map.containsKey(c))
				map.put(c, count++);
			
			sb.append(map.get(c));
		}
		return sb.toString();
	}

}
