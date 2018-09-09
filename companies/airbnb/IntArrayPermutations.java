package airbnb;

import java.util.ArrayList;
import java.util.List;

public class IntArrayPermutations {

	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		List<List<Integer>> result = permute(a);
		System.out.println(result);
	}

	private static List<List<Integer>> permute(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		
		helper(result, new ArrayList<>(), a);
		return result;
	}

	private static void helper(List<List<Integer>> result, List<Integer> cache, int[] a) {
		
		if(cache.size() == a.length) {
			result.add(new ArrayList<>(cache));
		} else {
			for(int i = 0; i < a.length; i++) {
				if(!cache.contains(a[i])) {
					cache.add(a[i]);
					helper(result, cache, a);
					cache.remove(cache.size() - 1);
				}
			}
		}
	}

}
