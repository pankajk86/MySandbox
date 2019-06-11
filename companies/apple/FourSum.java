package apple;

import java.util.Arrays;
import java.util.List;

//TODO
public class FourSum {

	public static void main(String[] args) {
		int[] a = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		List<List<Integer>> result = fourSum(a, target);
		System.out.println(result);
	}

	private static List<List<Integer>> fourSum(int[] a, int target) {
		int[][] dp = new int[a.length][a.length];
		
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++) {
			for(int j = i; j < a.length; j++) {
				dp[i][j] = i == j ? a[i] : dp[i][j - 1] + a[j];
			}
		}
		
		return null;
	}

}
