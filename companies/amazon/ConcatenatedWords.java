package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatenatedWords {

	public static void main(String[] args) {
		String[] words = { "cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat" };
		List<String> result = concatenatedWordsInDict(words);
		System.out.println(result);
	}

	private static List<String> concatenatedWordsInDict(String[] words) {
		List<String> result = new ArrayList<>();
		Set<String> dict = new HashSet<>(Arrays.asList(words));
		
		for(String word: words) {
			if(isConcatenated(word, dict))
				result.add(word);
		}
		return result;
	}

	private static boolean isConcatenated(String word, Set<String> dict) {
		for(int i = 1; i < word.length(); i++) {
			if(dict.contains(word.substring(0, i))) {
				String rest = word.substring(i);
				if(dict.contains(rest) || isConcatenated(rest, dict))
					return true;
			}
		}
		return false;
	}

}
