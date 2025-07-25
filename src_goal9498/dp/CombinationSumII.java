package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		int[] a = {10,1,2,7,6,1,5};//{2, 3, 6, 7};
		int target = 8;
		
		List<List<Integer>> result = getCombinationsWithoutDuplicates(a, target);
		System.out.println(result);
	}

	private static List<List<Integer>> getCombinationsWithoutDuplicates(int[] a, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(a);
		helper(a, target, result, new ArrayList<>(), 0);
		return result;
	}

	private static void helper(int[] a, int target, List<List<Integer>> result, List<Integer> temp, int start) {
		if(target < 0)
			return;
		
		if(target == 0)
			result.add(new ArrayList<>(temp));
		
		for(int i = start;  i < a.length; i++) {
			if(i > start && a[i] == a[i - 1])
				continue;
			temp.add(a[i]);
			helper(a, target - a[i], result, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

}
