package uber;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {

	public static void main(String[] args) {
		int n = 32;
		List<List<Integer>> result = getFactorCombinations(n);
		
		for(List<Integer> list: result) {
			for(Integer i: list)
				System.out.print(i + ", ");
			System.out.println();
		}
	}

	private static List<List<Integer>> getFactorCombinations(int n) {

		List<List<Integer>> result = new ArrayList<>();
		
		if(n <= 3)
			return result;
		
		List<Integer> path  = new ArrayList<>();
		getFactors(2, n, path, result);
		return result;
	}

	private static void getFactors(int start, int n, List<Integer> path, List<List<Integer>> result) {

		for(int i = start; i <= Math.sqrt(n); i++) {
			if(n % i == 0 && n / i >= i) {
				path.add(i);
				path.add(n / i);
				result.add(new ArrayList<>(path));
				path.remove(path.size() - 1);
				getFactors(i, n / i, path, result);
				path.remove(path.size() - 1);
			}
		}
	}

}
