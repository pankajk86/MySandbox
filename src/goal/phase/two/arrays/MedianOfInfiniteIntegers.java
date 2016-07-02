package goal.phase.two.arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfInfiniteIntegers {

    public static void main(String[] args) {

        int[] a = { 3, 2, 1, 7, 9, 18, 10, 6, 15, 4, 5 };
        float median = getMedian(a);
        System.out.println("Median: " + median);
    }

    private static float getMedian(int[] a) {

        PriorityQueue<Integer> min = new PriorityQueue<Integer>();
        PriorityQueue<Integer> max = new PriorityQueue<Integer>(10, Collections.reverseOrder());

        for (int i : a) {
            if (max.isEmpty()) {
                max.add(i);
            } else if (max.size() > min.size()) {
                if (i > max.peek()) {
                    min.add(i);
                } else {
                    min.add(max.poll());
                    max.add(i);
                }
            } else {
                if (i <= min.peek()) {
                    max.add(i);
                } else {
                    max.add(min.poll());
                    min.add(i);
                }
            }
        }

        return (a.length % 2 == 0 ? (max.peek() + min.peek()) / 2f : max.peek());
    }

}
