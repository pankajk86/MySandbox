package facebook;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortedArrays {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5},
                a2 = {1, 2, 5, 7, 9},
                a3 = {1, 3, 4, 5, 8};

        List<Integer> result = findIntersections(a1, a2, a3);
        System.out.println(result);

        result = findIntersectionsSimpler(a1, a2, a3);
        System.out.println(result);
    }

    private static List<Integer> findIntersectionsSimpler(int[] a1, int[] a2, int[] a3) {
        List<Integer> result = new ArrayList<>();
        int[] freq = new int[2001];

        for (int i : a1) freq[i]++;
        for (int i : a2) freq[i]++;
        for (int i : a3) freq[i]++;

        for (int i = 1; i < 2001; i++) {
            if (freq[i] == 3) result.add(i);
        }

        return result;
    }

    private static List<Integer> findIntersections(int[] a1, int[] a2, int[] a3) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0, j = 0, k = 0; i < a1.length && j < a2.length && k < a3.length; ) {
            int x = a1[i], y = a2[j], z = a3[k];
            if (x == y && y == z) {
                result.add(x);
                i++; j++; k++;
            } else {
                int min = Math.min(x, Math.min(y, z));
                if (min == x) i++;
                if (min == y) j++;
                if (min == z) k++;
            }
        }
        return result;
    }
}
