package google;

import java.util.HashMap;
import java.util.Map;

public class SentenceSimilarityII {

	public static void main(String[] args) {
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};
		String[][] pairs = {{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}};
		
		boolean result = areSimilarSentences(words1, words2, pairs);
		System.out.println(result);
	}

	private static boolean areSimilarSentences(String[] words1, String[] words2, String[][] pairs) {

		if(words1.length != words2.length)
			return false;
		
		Map<String, String> map = new HashMap<>();
		
		for(String[] pair: pairs) {
			String s1 = findRoot(map, pair[0]);
			String s2 = findRoot(map, pair[1]);
			
			if(!s1.equals(s2))
				map.put(s1, s2);
		}
		
		for(int i = 0; i < words1.length; i++) {
			String s1 = findRoot(map, words1[i]);
			String s2 = findRoot(map, words2[i]);
			
			if(!s1.equals(s2))
				return false;
		}
		
		return true;
	}

	private static String findRoot(Map<String, String> map, String word) {
		
		if(!map.containsKey(word)) 
			map.put(word, word);
		
		while(!map.get(word).equals(word)) {
			word = map.get(word);
		}
		
		return word;
	}

}
