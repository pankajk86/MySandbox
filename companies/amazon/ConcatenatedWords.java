package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
		Set<String> dict = new HashSet<>();
		
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s1.length() - s2.length();
			}
		});
		
		for(int i = 0; i < words.length; i++) {
			if(canFormWord(words[i], dict))
				result.add(words[i]);
			dict.add(words[i]);
		}
		
		return result;
	}

	private static boolean canFormWord(String word, Set<String> dict) {
		boolean[] dp = new boolean[word.length() + 1];
		dp[0] = true;
		
		for(int i = 1; i <= word.length(); i++) {
			for(int j = 0; j < i; j++) {
				if(dp[j] && dict.contains(word.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[word.length()];
	}

}
