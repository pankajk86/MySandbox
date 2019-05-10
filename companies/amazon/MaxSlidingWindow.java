package amazon;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

	public static void main(String[] args) {
		int[] nums = { 1, -1 };
		int k = 2;
		int[] result = maxSlidingWindow(nums, k);

		for (int i = 0; i < result.length; i++)
			System.out.print(result[i] + " ");
	}

	private static int[] maxSlidingWindow(int[] a, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		int[] result = new int[a.length - k + 1];

		for (int i = 0; i < k; i++)
			pq.add(a[i]);

		result[0] = pq.peek();
		pq.remove(a[0]);
		int j = 1;

		for (int i = k; i < a.length; i++) {
			pq.add(a[i]);
			result[j++] = pq.peek();
			pq.remove(a[i - k + 1]);
		}

		return result;
	}

}
