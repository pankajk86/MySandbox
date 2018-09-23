package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		String start = "leet", end = "code";
		List<String> dict = new ArrayList<>();
		dict.addAll(Arrays.asList("lest", "leet", "lose", "code", "lode", "robe", "lost"));
		
		int result = countLadder(start, end, dict);
		System.out.println(result);
	}

	private static int countLadder(String start, String end, List<String> wordList) {

		Set<String> dict = new HashSet<>(wordList);
		Set<String> reached = new HashSet<>();
		reached.add(start); dict.remove(start);
		int count = 1;
		
		while(!reached.isEmpty()) {
			Set<String> reachedNext = new HashSet<>();
			for(String s: reached) {
				for(int i = 0; i < s.length(); i++) {
					char[] c = s.toCharArray();
					for(char j = 'a'; j <= 'z'; j++) {
						c[i] = j;
						String newS = String.valueOf(c);
						if(dict.remove(newS)) {
							reachedNext.add(newS);
							if(end.equals(newS))
								return count + 1;
						}
					}
				}
			}
			reached = reachedNext;
			count++;
		}
		
		return 0;
	}


}
