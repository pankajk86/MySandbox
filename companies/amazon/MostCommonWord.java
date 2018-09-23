package amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	public static void main(String[] args) {
		String sentence = "a, a, a, a, b,b,b,c, c";
		String[] banned = { "a" };
		String result = mostCommonWord(sentence, banned);
		System.out.println(result);
	}

	private static String mostCommonWord(String sentence, String[] banned) {

		sentence = sentence.replaceAll("[!?',;.]", "").toLowerCase();
		Map<String, Integer> map = new HashMap<>();
		Set<String> bannedSet = new HashSet<>();

		for (String word : sentence.split(" ")) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		for (String word : banned)
			bannedSet.add(word);

		String result = null;
		int maxFreq = 0;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String word = entry.getKey();
			int count = entry.getValue();

			if (!bannedSet.contains(word) && count > maxFreq) {
				result = word;
				maxFreq = count;
			}
		}

		return result;
	}

}
