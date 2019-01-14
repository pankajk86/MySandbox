package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

	public static void main(String[] args) {
		String s = "catsanddog";
		List<String> dict = new ArrayList<>();
		dict.addAll(Arrays.asList("cat", "cats", "and", "sand", "dog"));
		
		List<String> result = wordBreak(s, dict);
		System.out.println(result);
	}

	private static List<String> wordBreak(String s, List<String> dict) {
		return dfs(s, dict, new HashMap<String, List<String>>());
	}

	private static List<String> dfs(String s, List<String> dict, Map<String, List<String>> map) {
		if(map.containsKey(s))
			return map.get(s);
		
		List<String> result = new ArrayList<>();
		if(s.length() == 0) {
			result.add("");
			return result;
		}
		
		for(String word: dict) {
			if(s.startsWith(word)) {
				List<String> subList = dfs(s.substring(word.length()), dict, map);
				for(String sub: subList)
					result.add(word + (sub.isEmpty() ? "" : " ") + sub);
			}
		}
		
		map.put(s,  result);
		return result;
	}

}
