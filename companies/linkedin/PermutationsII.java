package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

	public static void main(String[] args) {
		int[] a = {3, 3, 0, 3};
		List<List<Integer>> result = permuteUnique(a);
		System.out.println(result);
	}

	private static List<List<Integer>> permuteUnique(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		if(a == null || a.length == 0) return result;
		
		Arrays.sort(a);
		boolean[] used = new boolean[a.length];
		dfs(a, result, new ArrayList<Integer>(), used);
		
		return result;
	}

	private static void dfs(int[] a, List<List<Integer>> result, List<Integer> temp, boolean[] used) {
		if(temp.size() == a.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i = 0; i < a.length; i++) {
			if(used[i]) continue;
			if(i > 0 && a[i] == a[i - 1] && !used[i - 1]) continue;
			
			used[i] = true;
			temp.add(a[i]);
			dfs(a, result, temp, used);
			used[i] = false;
			temp.remove(temp.size() - 1);
		}
	}

}
