package goal.phase.two.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KMaxElementsInArray {

    public static void main(String[] args) {

        int a[] = { 4, 3, 1, 7, 5, 2, 18, 9, 10 };
        int k = 5;

        // getMaxByCreatingAndDeletingInHeap(a, k);

        getMaxByMaintainingSizeOfHeap(a, k);
    }

    private static void getMaxByMaintainingSizeOfHeap(int[] a, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);

        for (int i : a) {
            if (pq.size() == k) {
                pq.poll();
            }
            pq.add(i);
        }

        Integer val = null;

        while ((val = pq.poll()) != null) {
            System.out.print(val + " ");
        }
    }

    private static void getMaxByCreatingAndDeletingInHeap(int a[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int i : a) {
            pq.add(i);
        }

        // remove the (n-k) smallest elements.
        for (int i = pq.size() - k; i > 0; i--) {
            pq.poll();
        }

        List<Integer> kMaxElements = new ArrayList<Integer>();
        int count = pq.size();

        for (int i = 0; i < count; i++) {
            kMaxElements.add(pq.poll());
        }

        for (int i : kMaxElements) {
            System.out.print(i + " ");
        }
    }

}
