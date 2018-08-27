package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MyMagicDictionary {
	public static void main(String[] args) {
		MagicDictionary dict = new MagicDictionary();
		String[] words = { "hello", "leetcode" };
		dict.buildDict(words);
		System.out.println("hello: " + dict.search("hello"));
		System.out.println("hhllo: " + dict.search("hhllo"));
		System.out.println("hell: " + dict.search("hell"));
		System.out.println("leetcoded: " + dict.search("leetcoded"));
	}
}

class MagicDictionary {

	Map<String, List<int[]>> map = null;

	public MagicDictionary() {
		map = new HashMap<>();
	}

	public void buildDict(String[] dict) {
		for (String word : dict) {
			for (int i = 0; i < word.length(); i++) {
				String key = word.substring(0, i) + word.substring(i + 1);
				List<int[]> values = map.getOrDefault(key, new ArrayList<>());
				values.add(new int[] { i, word.charAt(i) });
				map.put(key, values);
			}
		}
	}

	public boolean search(String word) {
		for (int i = 0; i < word.length(); i++) {
			String key = word.substring(0, i) + word.substring(i + 1);
			if (map.containsKey(key)) {
				for (int[] pair : map.get(key)) {
					if (pair[0] == i && pair[1] != word.charAt(i))
						return true;
				}
			}
		}
		return false;
	}
}
