package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PalindromePairs {

	public static void main(String[] args) {
		String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
		List<List<Integer>> result = palindromePairs(words);
		System.out.println(result);
	}

	private static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();

		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++)
			map.put(words[i], i);

		for (int i = 0; i < words.length; i++) {
			int l = 0, r = 0;
			while (l <= r) {
				String s = words[i].substring(l, r);
				Integer j = map.get(new StringBuilder(s).reverse().toString());
				if (j != null && i != j && isPalindrome(words[i].substring(l == 0 ? r : 0, l == 0 ? words[i].length() : l))) {
					result.add(Arrays.asList(l == 0 ? new Integer[]{i, j} : new Integer[] {j, i}));
				}
				if(r < words[i].length())
					r++;
				else
					l++;
			}
		}

		return result;
	}
	
	private static boolean isPalindrome(String s) {
		int start = 0, end = s.length() - 1;

		while (start <= end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else
				return false;
		}
		return true;
	}

	// TIME LIMIT EXCEEDED :(
	@SuppressWarnings("unused")
	private static List<List<Integer>> palindromePairs2(String[] words) {

		List<List<Integer>> result = new ArrayList<>();
		Set<Pair> set = new HashSet<>();

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words.length; j++) {
				if (i != j) {
					String a = words[i], b = words[j];
					String ab = a + b;
					Pair pair = new Pair(i, j);
					if (isPalindrome(ab) && !set.contains(pair)) {
						result.add(new ArrayList<>(Arrays.asList(i, j)));
						set.add(pair);
					}

					String ba = b + a;
					pair = new Pair(j, i);
					if (isPalindrome(ba) && !set.contains(pair)) {
						result.add(new ArrayList<>(Arrays.asList(j, i)));
						set.add(pair);
					}
				}
			}
		}

		return result;
	}

	

	public static void testPair() {
		Set<Pair> set = new HashSet<>();
		set.add(new Pair(1, 0));

		Pair p = new Pair(1, 0);
		System.out.println(set.contains(p));

		set.add(new Pair(0, 1));
		System.out.println();
	}

}

class Pair {
	int i, j;

	Pair(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Pair))
			return false;

		if (o == this)
			return true;

		Pair pair = (Pair) o;

		if (pair.i == this.i && pair.j == this.j)
			return true;

		return false;
	}

	@Override
	public int hashCode() {
		int result = 17;
		result = (int) (31 * i + j);
		return result;
	}
}
