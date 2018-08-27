package google;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

	public static void main(String[] args) {
		String s = "2*3-4*5";
		List<Integer> result = waysToCompute(s);
		System.out.println(result);
	}

	private static List<Integer> waysToCompute(String s) {

		List<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == '+' || c == '-' || c == '*') {
				String a = s.substring(0, i);
				String b = s.substring(i + 1);
				List<Integer> al = waysToCompute(a);
				List<Integer> bl = waysToCompute(b);
				
				for(int x: al) {
					for(int y: bl) {
						if (c == '+') result.add(x + y);
						else if (c == '-') result.add(x - y);
						else if(c == '*') result.add(x * y);
					}
				}
			}
		}
		
		if(result.size() == 0) result.add(Integer.valueOf(s));
		return result;
	}

}
