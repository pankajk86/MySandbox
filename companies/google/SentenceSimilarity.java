package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SentenceSimilarity {

	public static void main(String[] args) {
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "painting", "talent"};
		
		String[][] pairs = {{"great", "fine"}, {"drama","acting"}, {"skills","talent"}};

		boolean result = areSimilarSentences(words1, words2, pairs);
		System.out.println(result);

	}

	private static boolean areSimilarSentences(String[] words1, String[] words2, String[][] pairs) {

		if (words1.length != words2.length)
			return false;

		Map<String, List<String>> map = new HashMap<>();

		for (String[] pair : pairs) {
			List<String> list = map.getOrDefault(pair[0], new ArrayList<>());
			list.add(pair[1]);
			map.put(pair[0], list);
		}
		
		for(int i = 0; i < words1.length; i++) {
			if(!words1[i].equals(words2[i])
					&& !map.getOrDefault(words1[i], new ArrayList<>()).contains(words2[i])
					&& !map.getOrDefault(words2[i], new ArrayList<>()).contains(words1[i])) 
				return false;
		}
		
//		if (map.isEmpty()) {
//			boolean result = true;
//			for (int i = 0; i < words1.length; i++) {
//				if (!words1[i].equals(words2[i]))
//					return false;
//			}
//			return result;
//		}
//
//		for (int i = 0; i < words1.length; i++) {
//			if (map.containsKey(words1[i])) {
//				List<String> list = map.get(words1[i]);
//				if (!list.contains(words2[i]))
//					return false;
//			} else if (map.containsKey(words2[i])) {
//				List<String> list = map.get(words2[i]);
//				if (!list.contains(words1[i]))
//					return false;
//			} else {
//				return false;
//			}
//		}

		return true;
	}

}
