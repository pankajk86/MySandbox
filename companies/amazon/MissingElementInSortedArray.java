package amazon;

import java.util.ArrayList;
import java.util.List;

public class MissingElementInSortedArray {

	public static void main(String[] args) {
		int[] a = { 4, 7, 9, 10 };
		int k = 10;
		
		int result = missingElement(a, k);
		System.out.println(result);
	}

	private static int missingElement(int[] a, int k) {
		int n = a.length;
		if (getMissingCount(a, n - 1) < k)
			return a[n - 1] + k - getMissingCount(a, n - 1);

		int left = 0, right = n - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (getMissingCount(a, mid) < k) left = mid + 1;
			else right = mid;
		}
		return a[right - 1] + k - getMissingCount(a, right - 1);
	}

	private static int getMissingCount(int[] a, int index) {
		return a[index] - a[0] - index;
	}

}
