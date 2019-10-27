package goal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		int arr[] = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
		List<List<Integer>> result = threeSum(arr);
		System.out.println(result);
	}
	
	private static List<List<Integer>> threeSum(int[] a) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(a);
		
		for (int i = 0; i < a.length - 2; i++) {
			if (i != 0 && a[i] == a[i - 1])
				continue;

			for (int j = i + 1, k = a.length - 1; j < k;) {
				int sum = a[i] + a[j] + a[k];
				if (sum == 0) {
					result.add(Arrays.asList(a[i], a[j], a[k]));
					j++;
					k--;
					while ((j < k) && (a[j] == a[j - 1])) j++;
					while ((j < k) && (a[k] == a[k + 1])) k--;
				} else if (sum > 0) k--;
				else j++;
			}
		}
		return result;
	}
}
