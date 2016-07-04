package goal.phase.two.heap;

import java.util.PriorityQueue;

public class MergeStreamsOfNumbers {

    public static void main(String[] args) {

        int[] a = { 1, 2, 6, 11, 15, 19, 43 };
        int[] b = { 3, 5, 8, 10, 13, 18 };
        int[] c = { 4, 7, 9, 12, 31, 54, 85, 101 };

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length && k < c.length) {
            pq.add(a[i]);
            pq.add(b[j]);
            pq.add(c[k]);
            i++;
            j++;
            k++;
        }

        while (i < a.length) {
            pq.add(a[i]);
            i++;
        }

        while (j < b.length) {
            pq.add(b[j]);
            j++;
        }

        while (k < c.length) {
            pq.add(c[k]);
            k++;
        }

        Integer val = null;

        while ((val = pq.poll()) != null) {
            System.out.print(val + " ");
        }
    }

}
