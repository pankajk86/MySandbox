package dp;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public static void main(String[] args) {
		int n = 7, k = 3;
		int[] num = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<List<Integer>> result = new ArrayList<>();
		helper(result, new ArrayList<Integer>(), n, k, num, 0);

		for (List<Integer> list : result) {
			System.out.println(list.toString());
		}
	}

	private static void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int[] num, int start) {
		if (n == 0 && k == 0) {
			result.add(new ArrayList<Integer>(list));
		} else {
			for (int i = start; i < num.length && n > 0 && k > 0; i++) {
				list.add(num[i]);
				helper(result, list, n - num[i], k - 1, num, i+1);
				list.remove(list.size() - 1);
			}
		}
	}

}
