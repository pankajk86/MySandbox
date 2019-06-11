package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

	public static void main(String[] args) {
		String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };
		int result = longestChain(words);
		System.out.println(result);
	}

	private static int longestChain(String[] words) {
		if(words == null || words.length == 0) return 0;
		int result = 0;
		
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		Map<String, Integer> map = new HashMap<>();
		for(String word: words) {
			if(map.containsKey(word)) continue;
			map.put(word, 1);
			
			for(int i = 0; i < word.length(); i++) {
				StringBuilder sb = new StringBuilder(word);
				sb.deleteCharAt(i);
				String next = sb.toString();
				
				if(map.containsKey(next) && map.get(next) + 1 > map.get(word))
					map.put(word, map.get(next) + 1);
			}
			if(map.get(word) > result)
				result = map.get(word);
		}
		
		return result;
	}

}
