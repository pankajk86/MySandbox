package amazon;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

	public static void main(String[] args) {
		String[] a = { "bella", "label", "roller" };
		List<String> result = commonChars(a);
		System.out.println(result);
	}

	private static List<String> commonChars(String[] a) {
		int[][] cache = new int[a.length][26];

		for (int i = 0; i < a.length; i++) {
			for (char c : a[i].toCharArray())
				cache[i][c - 'a']++;
		}

		List<String> result = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			int j = 0, val = cache[0][i];
			while (j < a.length) {
				if (cache[j][i] == 0)
					break;
				val = Math.min(val, cache[j][i]);
				j++;
			}

			if (j == a.length) {
				for (int k = 0; k < val; k++) {
					char c = (char) ('a' + i);
					result.add(String.valueOf(c));
				}
			}
		}

		return result;
	}

}
