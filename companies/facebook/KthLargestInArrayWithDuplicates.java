package facebook;

import java.util.PriorityQueue;

public class KthLargestInArrayWithDuplicates {

	public static void main(String[] args) {
		int[] a = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
		int k = 4;
		int result = kthLargest(a, k);
		System.out.println(result);
	}

	private static int kthLargest(int[] a, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < a.length; i++) {
			int curr = a[i];
			if (pq.size() == k) {
				if (pq.peek() < curr) {
					pq.poll();
					pq.add(curr);
				}
			} else {
				pq.add(curr);
			}
		}
		return pq.peek();
	}

}
