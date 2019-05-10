package linkedin;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

	public static void main(String[] args) {
		int n = 32;
		List<List<Integer>> result = factorCombinations(n);
		System.out.println(result);
	}

	private static List<List<Integer>> factorCombinations(int n) {
		List<List<Integer>> result = new ArrayList<>();
		helper(result, new ArrayList<>(), n, 2);
		return result;
	}

	private static void helper(List<List<Integer>> result, List<Integer> temp, int n, int start) {
		if(n <= 1) {
			if(temp.size() > 1)
				result.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i = start; i <= n; i++) {
			if(n % i == 0) {
				temp.add(i);
				helper(result, temp, n / i, i);
				temp.remove(temp.size() - 1);
			}
		}
	}

}
