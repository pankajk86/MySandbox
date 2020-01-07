package amazon;

import java.util.Arrays;

public class TwoSumLessThanK {

	public static void main(String[] args) {
		int[] a = { 34, 23, 1, 24, 75, 33, 54, 8 };
		int k = 60;
		int result = twoSumLessThanK(a, k);
		System.out.println(result);
	}

	private static int twoSumLessThanK(int[] a, int k) {
		if(a == null || a.length == 0) return 0;
		Arrays.sort(a);
		int result = -1;
		
		for(int i = 0, j = a.length - 1; i < j; ) {
			int sum = a[i] + a[j];
			if(sum < k) {
				result = Math.max(result, sum);
				i++;
			} else j--;
		}
		
		return result;
	}

}
