package goal.phase.two.heap;

import java.util.PriorityQueue;

public class KthLargetElementInArray {

    public static void main(String[] args) {

        int a[] = { 4, 3, 1, 7, 5, 2, 18, 9, 10 };
        int k = 3;

        System.out.println("Kth largest in O(n): " + getKthLargest_O_n(a, k));
        System.out.println("Kth largest in O(k): " + getKthLargest_O_k(a, k));
    }

    private static int getKthLargest_O_k(int[] a, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int i : a) {

            if (pq.isEmpty()) {
                pq.add(i);
            } else {
                if (pq.size() == k) {
                    if (pq.peek() < i) {
                        pq.poll();
                        pq.add(i);
                    }
                } else {
                    pq.add(i);
                }
            }
        }

        return pq.peek();
    }

    private static int getKthLargest_O_n(int a[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i : a) {
            pq.add(i);
        }

        /*
         * sorted array: 1, 2, 3, 4, 5, 7, 9, 10, 18 we need to remove the (n-k)
         * values from the heap. Then, the root will be the kth largest value.
         */
        for (int i = pq.size() - k; i > 0; i--) {
            pq.poll();
        }

        return pq.peek();
    }

}
