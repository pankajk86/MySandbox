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

	private static void helper(List<List<Integer>> result, List<Integer> temp, int[] a) {
		
		if(temp.size() == a.length) {
			result.add(new ArrayList<>(temp));
		} else {
            for (int j : a) {
                if (!temp.contains(j)) {
                    temp.add(j);
                    helper(result, temp, a);
                    temp.remove(temp.size() - 1);
                }
            }
		}
	}

}
