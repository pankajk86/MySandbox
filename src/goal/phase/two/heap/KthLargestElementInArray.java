package goal.phase.two.heap;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInArray {

    public static void main(String[] args) {

        int[] a = { 4, 3, 1, 7, 5, 2, 18, 9, 10 };
        int k = 3;

        int result = getKthLargest_nLogK(a, k);
        System.out.println(result);

        result = getKthLargest(a, k);
        System.out.println(result);

        result = getKthLargestConciseQuickSelect(a, k);
        System.out.println(result);
    }

    private static int getKthLargestConciseQuickSelect(int[] a, int k) {
        int n = a.length;
        return quickSelect(a, 0, n - 1, n - k);
    }

    private static int quickSelect(int[] a, int left, int right, int k) {
        int pivot = a[right], p = left;

        for (int i = left; i < right; i++) {
            if (a[i] <= pivot) {
                swap(a, p, i);
                p++;
            }
        }
        swap(a, p, right);

        if (p > k) return quickSelect(a, left, p - 1, k);
        else if (p < k) return quickSelect(a, p + 1, right, k);
        else return a[p];
    }

    /**
     * Tme: Average: O(n), Worst : O(n^2)
     * Space: O(1)
     */
    private static int getKthLargest(int[] a, int k) {
        int n = a.length, left = 0, right = n - 1;
        k = n - k;
        Random rand = new Random();

        while (true) {
            int pivotIndex = left + rand.nextInt(right - left + 1);
            int newPivotIndex = partition(a, left, right, pivotIndex);
            if (newPivotIndex == k) return a[newPivotIndex];
            else if (newPivotIndex < k) left = newPivotIndex + 1;
            else right = newPivotIndex - 1;
        }
    }

    private static int partition(int[] a, int left, int right, int pivotIndex) {
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, right);
        int p = left;

        for (int i = left; i < right; i++) {
            if (a[i] < pivot) {
                swap(a, p, i);
                p++;
            }
        }

        swap(a, p, right);
        return p;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static int getKthLargest_nLogK(int[] a, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : a) {
            if (pq.size() < k) pq.add(i);
            else {
                if (!pq.isEmpty() && pq.peek() < i) {
                    pq.poll();
                    pq.add(i);
                }
            }
        }

        return pq.peek();
    }

}
