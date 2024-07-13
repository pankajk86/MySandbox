package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VerifyingAlienDictionary {

	public static void main(String[] args) {
		String order = "abcdefghijklmnopqrstuvwxyz";
		String[] words = { "apple", "app" };

		boolean result = isSorted(words, order);
		System.out.println(result);
	}

	private static boolean isSorted(String[] words, String order) {
		int[] map = new int[26];
		for (int i = 0; i < order.length(); i++)
			map[order.charAt(i) - 'a'] = i;

		for (int i = 0; i < words.length - 1; i++) {
			if (!isInOrder(words[i], words[i + 1], map)) return false;
		}
		return true;
	}

	private static boolean isInOrder(String s1, String s2, int[] map) {
		for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
			char c1 = s1.charAt(i), c2 = s2.charAt(j);
			if (c1 == c2) continue;
			return map[c1 - 'a'] < map[c2 - 'a'];
		}
		return s1.length() <= s2.length();
	}

}
