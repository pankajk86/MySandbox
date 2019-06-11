package google;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

	public static void main(String[] args) {
		int n = 24;
		List<Integer> result = lexicalOrder(n);
		System.out.println(result);
	}

	private static List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<>();
		for(int i = 1; i < 10; i++)
			dfs(i, n, result);
		
		return result;
	}

	private static void dfs(int curr, int n, List<Integer> result) {
		if(curr > n) return;
		
		result.add(curr);
		for(int i = 0; i< 10; i++) {
			if(10 * curr + i < n)
				dfs(10 * curr + i, n, result);
		}
	}

}
