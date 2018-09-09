package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceII {

	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		WordDistance wd = new WordDistance(words);
		
		int result = wd.shortest("makes", "coding");
		System.out.println(result);
	}

}

class WordDistance {
	
	private Map<String, List<Integer>> map = null;
	
	public WordDistance(String[] words) {
		map = new HashMap<>();
		
		for(int i = 0; i < words.length; i++) {
			List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
			list.add(i);
			map.put(words[i], list);
		}
	}
	
	// NOT CORRECT for all test cases
	public int shortest(String word1, String word2) {
		int result = 0;
		
		List<Integer> l1 = map.get(word1), l2 = map.get(word2);
		
		for(int i = 0; i < l1.size(); i++) {
			for(int j = 0; j < l2.size(); j++) {
				int val = Math.abs(l1.get(i) - l2.get(j));
				result = result == 0 ? val : Math.min(result, val);
			}
		}
		
		return result;
	}
}
