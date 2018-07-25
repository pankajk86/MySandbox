package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbriviator {
	
	Map<String, Set<String>> map = new HashMap<>();
	
	public ValidWordAbbriviator(String[] dictionary) {
		for(String word: dictionary) {
			
			Set<String> set = null;
			String key = word.length() > 2 ? abbreviate(word) : word;
			
			if(!map.containsKey(key))
				set = new HashSet<>();
			else 
				set = map.get(key);
			
			set.add(word);
			map.put(key, set);
		}
	}
	
	private String abbreviate(String word) {
		StringBuilder sb = new StringBuilder();
		sb.append(word.charAt(0)).append(word.length() - 2).append(word.charAt(word.length() - 1));
		return sb.toString();
	}

	private boolean isUnique(String word) {
		String abbWord = word != null && word.length() > 2 ? abbreviate(word) : word;
		return !map.containsKey(abbWord) || (map.get(abbWord).size() == 1 && map.get(abbWord).contains(word));
	}

	public static void main(String[] args) {
		String[] dictionary = {"a", "a"}; //{"deer", "door", "cake", "card"}; //
		ValidWordAbbriviator vwa = new ValidWordAbbriviator(dictionary);
		String[] words = {"a"};//{"dear", "cart", "cane", "make"}; //
		
		for(String word: words) {
			boolean result = vwa.isUnique(word);
			System.out.println("word: " + result);
		}
	}
}
