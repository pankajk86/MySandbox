package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StrobogrammaticNumberII {

	public static void main(String[] args) {
		int n = 3;
		List<String> result = findStrobogrammatic(n);
		System.out.println(result);
	}

	private static List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	private static List<String> helper(int n, int m) {
		if(n == 0) return Arrays.asList("");
		if(n == 1) return Arrays.asList("0", "1", "8");
		
		List<String> list = helper(n - 2, m);
		List<String> result = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			if(n != m) result.add("0" + s + "0");
			result.addAll(Arrays.asList(
					"1" + s + "1", 
					"6" + s + "9", 
					"8" + s + "8", 
					"9" + s + "6"));
		}
		
		return result;
	}

}
