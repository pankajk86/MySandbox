package facebook;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 4, 2 };
		nextPermutation(a);
		
		System.out.println(Arrays.toString(a));
	}

	private static void nextPermutation(int[] a) {
		int minIndex = -1, n = a.length;

		// 1, 3, 5, 4, 2 -> 1, 4, 5, 3, 2 -> 1, 4, 2, 3, 5

		for (int i = n - 1; i > 0; i--) {
			if (a[i - 1] < a[i]) {
				minIndex = i - 1;
				break;
			}
		}

		if (minIndex != -1) {
			int swapIndex = minIndex;
			for (int i = n - 1; i > minIndex; i--) {
				if (a[i] > a[minIndex]) {
					swapIndex = i;
					break;
				}
			}
			swap(a, minIndex, swapIndex);
		}
		reverse(a, minIndex + 1);
	}

	private static void swap(int[] a, int i, int j) {
		int t = a[i]; a[i] = a[j]; a[j] = t;
	}

	private static void reverse(int[] a, int start) {
		for (int i = start, j = a.length - 1; i < j; i++, j--)
			swap(a, i, j);
	}

}
