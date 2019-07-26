package amazon;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {

	public static void main(String[] args) {
		String[] queries = { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" };
		String pattern = "FB";
		
		List<Boolean> result = camelMatch(queries, pattern);
		System.out.println(result);
		
	}

	private static List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		if(queries == null || queries.length == 0) return result;
		
		for(String q: queries) {
			boolean isMatch = match(q.toCharArray(), pattern.toCharArray());
			result.add(isMatch);
		}
		return result;
	}

	private static boolean match(char[] s, char[] p) {
		int j = 0;
		for(int i = 0; i < s.length; i++) {
			if(j < p.length && s[i] == p[j])
				j++;
			else if(s[i] >= 'A' && s[i] <= 'Z')
				return false;
		}
		return j == p.length;
	}

}
