package linkedin;

import java.util.ArrayList;
import java.util.List;

public class Operators {

	public static void main(String[] args) {
		String s = "2011051945";
		int target = 196;
		
		List<String> result = addOperators(s, target);
		System.out.println(result.size());
	}

	private static List<String> addOperators(String s, int target) {
		List<String> result = new ArrayList<>();
		if(s == null || s.length() < 2) return result;
		dfs(s, target, "", 0, 0, 0, result);
		return result;
	}

	private static void dfs(String s, int target, String curr, int pos, double eval, double last, List<String> result) {
		int len = s.length();
		if(len == pos) {
			if(Double.compare(eval, target) == 0) result.add(curr);
			return;
		}
		
		for(int i = pos; i < s.length(); i++) {
			if(s.charAt(pos) == '0' && i != pos) break; // don't allow 05, 051
			String prefix = s.substring(pos, i + 1);
			long n = Long.parseLong(prefix);
			
			// for first digit
			if(pos == 0) dfs(s, target, curr + prefix, i + 1, n, n, result);
			else {
				dfs(s, target, curr + "+" + prefix, i + 1, eval + n, n, result);
				dfs(s, target, curr + "-" + prefix, i + 1, eval - n, -n, result);
				dfs(s, target, curr + "*" + prefix, i + 1, eval - last + (last * n), last * n, result);
				dfs(s, target, curr + "/" + prefix, i + 1, eval - last + (last / n), last / n, result);
			}
		}
	}

}
