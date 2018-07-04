package arrays;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

	public static void main(String[] args) {
		int n = 4, k = 9;
		
		String result = calculatePermutation(n, k);
		System.out.println(result);
	}

	private static String calculatePermutation(int n, int k) {

		StringBuilder result = new StringBuilder();
		int factorial = 1;
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1; i<=n; i++) {
			list.add(i);
			factorial *= i;
		}
		
		k--;
		
		for(int i=0; i<n; i++) {
			factorial = factorial / (n-i);
			
			int currentIndex = k / factorial;
			k = k % factorial;
			
			result.append(list.get(currentIndex));
			list.remove(currentIndex);
		}
		
		return result.toString();
	}

}
