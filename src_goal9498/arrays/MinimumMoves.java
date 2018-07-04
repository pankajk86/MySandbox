package arrays;

import java.util.Arrays;

public class MinimumMoves {

	public static void main(String[] args) {
		int[] a = { 1, 2, 4, 6 };
		int count = minimumMoves(a);
		System.out.println("Approach 1: " + count);

		count = minimumMoves2(a);
		System.out.println("Approach 2: " + count);
	}

	/*
	 * This one can have (n-1) moves at a time, where n = number of elements. For
	 * example: if n = 4, we can increase (n-1) = 3 elements at a time.
	 * 
	 * In the solution proposed, increasing (n-1) elements can also be interpreted
	 * as decreasing one element.
	 */
	private static int minimumMoves(int[] a) {

		Arrays.sort(a);
		int sum = 0;

		for (int i = a.length - 1; i >= 1; i--) {
			sum += (a[i] - a[0]);
		}
		return sum;
	}

	private static int minimumMoves2(int[] a) {

		Arrays.sort(a);
		int sum = 0;
		int median = a[a.length/2];

		for (int i = 0; i < a.length; i++) {
			if (a[i] < median) {
				sum += (median - a[i]);
			} else {
				sum += (a[i] - median);
			}
		}
		return sum;
	}
}
