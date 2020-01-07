package apple;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public static void main(String[] args) {
		int n = 4, k = 3;
		List<List<Integer>> result = combine(n, k);
		System.out.println(result);
	}

	private static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		dfs(n, k, 1, result, new ArrayList<>());
		return result;
	}

	private static void dfs(int n, int k, int start, List<List<Integer>> result, List<Integer> temp) {
		if(temp.size() == k) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i = start; i <= n; i++) {
			temp.add(i);
			dfs(n, k, i + 1, result, temp);
			temp.remove(temp.size() - 1);
		}
	}
}
