package facebook;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumOfDistinctSubArraysWithLengthK {

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 2, 9, 9, 9};
        int k = 3;

        long result = maximumSubArraySum(a, k);
        System.out.println(result);
    }

    private static long maximumSubArraySum(int[] a, int k) {
        Set<Integer> set = new HashSet<>();
        long temp = 0, result = 0;

        for (int i = 0, j = 0; i + k <= a.length; i++) {
            while (j < a.length && !set.contains(a[j]) && set.size() < k) {
                set.add(a[j]);
                temp += a[j];
                j++;
            }

            if (set.size() == k) {
                result = Math.max(result, temp);
            }

            set.remove(a[i]);
            temp -= a[i];
        }
        return result;
    }
}
