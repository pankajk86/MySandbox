package goal.phase.two.arrays;

import java.util.PriorityQueue;

public class MergeTwoHeaps {

    public static void main(String[] args) {

        int a[] = { 10, 5, 8, 3, 4, 6, 7 };
        int b[] = { 20, 13, 18, 10, 11, 16 };

        PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>();
        PriorityQueue<Integer> pq3 = new PriorityQueue<Integer>();

        for (int i : a) {
            pq1.add(i);
        }

        for (int i : b) {
            pq2.add(i);
        }

        while (pq1.size() > 0 && pq2.size() > 0) {
            if (pq1.peek() > pq2.peek()) {
                pq3.add(pq1.poll());
            } else {
                pq3.add(pq2.poll());
            }
        }

        while (pq1.size() > 0) {
            pq3.add(pq1.poll());
        }

        while (pq2.size() > 0) {
            pq3.add(pq2.poll());
        }

        Integer val = null;

        while ((val = pq3.poll()) != null) {
            System.out.print(val + " ");
        }
    }

}
