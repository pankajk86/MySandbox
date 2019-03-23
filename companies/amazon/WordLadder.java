package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

	public static void main(String[] args) {
		String start = "leet", end = "code";
		List<String> dict = new ArrayList<>();
		dict.addAll(Arrays.asList("lest", "leet", "lose", "code", "lode", "robe", "lost"));
		
		long begin = System.currentTimeMillis();
		int result = countLadder(start, end, dict);
		System.out.println(result + ", time taken: " + (System.currentTimeMillis() - begin));
		
		begin = System.currentTimeMillis();
		result = countLadderBFS(start, end, dict);
		System.out.println(result + ", time taken: " + (System.currentTimeMillis() - begin));
	}

	private static int countLadderBFS(String start, String end, List<String> dict) {
		Queue<String> q = new LinkedList<>();
		q.add(start); q.add(null);
		
		Set<String> visited = new HashSet<>();
		visited.add(start);
		
		int result = 1;
		
		while(!q.isEmpty()) {
			String curr = q.poll();
			
			if(curr != null) {
				for(int i = 0; i < curr.length(); i++) {
					char[] carr = curr.toCharArray();
					for(char c = 'a'; c <= 'z'; c++) {
						carr[i] = c;
						
						String str = String.valueOf(carr);
						if(end.equals(str)) return result + 1;
						
						if(dict.contains(str) && !visited.contains(str)) {
							q.add(str);
							visited.add(str);
						}
					}
				}
			} else {
				result++;
				if(!q.isEmpty())
					q.add(null);
			}
		}
		
		return 0;
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
