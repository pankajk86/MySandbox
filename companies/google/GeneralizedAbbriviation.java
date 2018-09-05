package google;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbriviation {

	public static void main(String[] args) {
		String s = "word";
		List<String> result = generateAbbriviations(s);
		for(String e: result)
			System.out.print(e + " ");
	}

	private static List<String> generateAbbriviations(String s) {

		List<String> result = new ArrayList<>();
		dfs(result, s, 0, "", 0);
		return result;
	}

	private static void dfs(List<String> result, String s, int pos, String current, int count) {
		
		if(pos == s.length()) {
			if(count > 0)
				current += count;
			result.add(current);
			return;
		}
		
		// Abbreviate the current letter
		dfs(result, s, pos + 1, current, count + 1);
		
		if(count > 0)
			current += count;
		current += s.charAt(pos);
		dfs(result, s, pos + 1, current, 0);
	}

}
