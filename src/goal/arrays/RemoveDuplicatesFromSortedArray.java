package goal.arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 3, 4, 5, 6};
        int result = removeDuplicates(a);
        System.out.println(result);
        System.out.println(Arrays.toString(a));
    }

    private static int removeDuplicates(int[] a) {
        int i = 1;
        for (int j = 1; j < a.length; j++) {
            if (a[j] != a[j - 1]) {
                a[i++] = a[j];
            }
        }
        return i;
    }

}
