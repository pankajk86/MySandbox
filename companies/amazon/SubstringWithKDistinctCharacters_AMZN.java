package amazon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubstringWithKDistinctCharacters_AMZN {
	public static void main(String args[]) {
		String s = "awaglknagawunagwkwagl";
		int k = 3;
		List<String> result = find(s, k);
		System.out.println(result);
	}

	private static List<String> find(String s, int k) {
		List<String> list = new ArrayList<>();
		List<String> result = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			for(int j = i; j < s.length(); j++) {
				list.add(s.substring(i, j + 1));
			}
		}
		
		for(String ss: list) {
			Set<Character> set = new HashSet<>();
			for(char c: ss.toCharArray())
				set.add(c);
			
			if(set.size() == k && ss.length() == k && !result.contains(ss))
				result.add(ss);
		}
		
		return result;
	}
}
