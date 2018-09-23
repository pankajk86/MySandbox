package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestWordDistanceIII {

	public static void main(String[] args) {
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		int result = findShortestDistance(words, "makes", "coding");
		System.out.println(result);
	}

	private static int findShortestDistance(String[] words, String w1, String w2) {

		Map<String, List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < words.length; i++) {
			List<Integer> list = map.getOrDefault(words[i], new ArrayList<>());
			list.add(i);
			map.put(words[i], list);
		}
		
		int result = Integer.MAX_VALUE;
		
		if(w1.equals(w2)) {
			List<Integer> list = map.get(w1);
			for(int i = 0; i < list.size(); i++) {
				for(int j = 0; j < list.size(); j++) {
					if(i != j) {
						result = Math.min(result, Math.abs(list.get(i) - list.get(j)));
					}
				}
			}
		} else {
			List<Integer> l1 = map.get(w1);
			List<Integer> l2 = map.get(w2);
			for(int i = 0; i < l1.size(); i++) {
				for(int j = 0; j < l2.size(); j++) {
					result = Math.min(result, Math.abs(l1.get(i) - l2.get(j)));
				}
			}
		}
		
		return result;
	}

}
