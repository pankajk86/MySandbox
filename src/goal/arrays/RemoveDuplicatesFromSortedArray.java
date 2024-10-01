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
        int index = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] != a[i - 1]) {
                a[index++] = a[i];
            }
        }
        return index;
    }

}
