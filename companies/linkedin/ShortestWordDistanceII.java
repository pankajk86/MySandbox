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
	
	public int shortest(String word1, String word2) {
		int result = Integer.MAX_VALUE;
		
		List<Integer> l1 = map.get(word1), l2 = map.get(word2);
		
		for(int i = 0, j = 0; i < l1.size() && j < l2.size(); ) {
			int index1 = l1.get(i), index2 = l2.get(j);
			if(index1 < index2) {
				result = Math.min(result, index2 - index1);
				i++;
			} else {
				result = Math.min(result, index1 - index2);
				j++;
			}
		}		
		return result;
	}
}
