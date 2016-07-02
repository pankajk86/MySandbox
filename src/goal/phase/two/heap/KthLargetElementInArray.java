package goal.phase.two.heap;

import java.util.PriorityQueue;

public class KthLargetElementInArray {

    public static void main(String[] args) {

        int a[] = { 4, 3, 1, 7, 5, 2, 18, 9, 10 };
        int k = 3;

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

        System.out.println(pq.peek());
    }

}
