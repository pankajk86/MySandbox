package dp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		int[] a = {2, 3, 6, 7};
		int target = 7;
		
		List<List<Integer>> result = getCombinations(a, target);
		System.out.println(result);
	}

	private static List<List<Integer>> getCombinations(int[] a, int target) {

		List<List<Integer>> result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		//Arrays.sort(a);
		
		helper(a, target, result, temp, 0);
		return result;
	}

	private static void helper(int[] a, int target, List<List<Integer>> result, List<Integer> temp, int start) {

		if(target < 0)
			return;
		
		if(target == 0)
			result.add(new ArrayList<>(temp));
		
		for(int i = start; i < a.length; i++) {
			temp.add(a[i]);
			helper(a, target - a[i], result, temp, i);
			temp.remove(temp.size() - 1);
		}
	}

}
