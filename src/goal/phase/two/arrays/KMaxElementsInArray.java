package goal.phase.two.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KMaxElementsInArray {

    public static void main(String[] args) {

        int a[] = { 4, 3, 1, 7, 5, 2, 18, 9, 10 };
        int k = 5;

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
