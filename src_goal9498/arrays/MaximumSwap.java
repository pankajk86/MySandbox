package arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumSwap {

	public static void main(String[] args) {

		int n = 2736;
		int result = maxSwap(n);
		System.out.println(result);

		result = maxSwapMoreIntuitive(n);
		System.out.println(result);
	}

	private static int maxSwapMoreIntuitive(int a) {
		char[] carr = String.valueOf(a).toCharArray();
		int[] lastIndex = new int[10];
		for (int i = 0; i < carr.length; i++) {
			lastIndex[carr[i] - '0'] = i;
		}

		for (int i = 0; i < carr.length; i++) {
			/*
			 * Iterate from 9 to num(carr[i]),
			 * and find the first (largest) number with index greater than i.
			 */
			for (int j = 9; j > carr[i] - '0'; j--) {
				if (lastIndex[j] > i) {		// it means 'j' is on the right side of i
					swap(carr, i, lastIndex[j]);
					return Integer.parseInt(String.valueOf(carr));
				}
			}
		}
		return a;
	}

	private static void swap(char[] a, int i, int j) {
		char t = a[i]; a[i] = a[j]; a[j] = t;
	}

	private static int maxSwap(int a) {
		char[] carr = String.valueOf(a).toCharArray();
		int n = carr.length;
		int[] maxSeen  = new int[n];
		int maxSeenAt = n - 1;
		maxSeen[maxSeenAt] = maxSeenAt;

		for (int i = n - 2; i >= 0; i--) {
			if (carr[i] > carr[maxSeenAt]) {
				maxSeenAt = i;
			}
			maxSeen[i] = maxSeenAt;
		}

		for (int i = 0; i < n; i++) {
			if (carr[i] < carr[maxSeen[i]]) {
				char t = carr[i];
				carr[i] = carr[maxSeen[i]];
				carr[maxSeen[i]] = t;
				return Integer.parseInt(new String(carr));
			}
		}

		return a;
	}


}
