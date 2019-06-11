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
		List<String> originalList = new ArrayList<>();
		originalList.addAll(Arrays.asList(words));

		Collections.sort(originalList, new Comparator<String>() {
			@Override
			public int compare(String s, String t) {
				int i = 0, j = 0;
				for (; i < s.length() && j < t.length(); i++, j++) {
					int i1 = order.indexOf(s.charAt(i)), i2 = order.indexOf(t.charAt(j));
					if (i1 < i2)
						return -1;
					else if (i1 > i2)
						return 1;
				}
				if(i < s.length() || j < t.length()) return -1;
				return 0;
			}
		});

		for (int i = 0; i < originalList.size(); i++) {
			if (!originalList.get(i).equals(words[i]))
				return false;
		}

		return true;
	}

}
