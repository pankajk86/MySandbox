package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(s);
		System.out.println(result);

		result = groupAnagramsBetter(s);
		System.out.println(result);
	}

	/**
	 * T : O(m * n) : m = size of the words array. n is avg. size of each word.
	 * S : O(m * 26)
	 * @param words
	 * @return
	 */
	private static List<List<String>> groupAnagramsBetter(String[] words) {
		Map<String, List<String>> map = new HashMap<>();

		for (String word : words) {
			char[] carr = new char[26];
			for (char c : word.toCharArray()) carr[c - 'a']++;

			String key = String.valueOf(carr);
			List<String> list = map.getOrDefault(key, new ArrayList<>());
			list.add(word);
			map.put(key, list);
		}

		return new ArrayList<>(map.values());
	}

	/**
	 * T : O(m * n log n) : m = size of the words array. n is avg. size of each word.
	 * @param words
	 * @return
	 */
	private static List<List<String>> groupAnagrams(String[] words) {
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s: words) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);

			String key = String.valueOf(arr);
			List<String> list = map.getOrDefault(key, new ArrayList<>());
			list.add(s);
			map.put(key, list);
		}
		
		return new ArrayList<>(map.values());
	}

}
