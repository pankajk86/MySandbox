package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordInDictionary {

	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> d = new ArrayList<>();
		d.addAll(Arrays.asList("ale","apple","monkey","plea"));
		String result = longestWordInDictThroughDeletion(s, d);
		System.out.println(result);
	}

	private static String longestWordInDictThroughDeletion(String s, List<String> d) {

		String longest = "";
		
		for(String word: d) {
			int i = 0;
			
			for(char c: s.toCharArray()) {
				if(i < word.length() && c == word.charAt(i))
					i++;
			}
			
			if(i == word.length() && word.length() >= longest.length()) {
				if(word.length() > longest.length() || word.compareTo(longest) < 0) {
					longest = word;
				}
			}
		}
		
		return longest;
	}

}
