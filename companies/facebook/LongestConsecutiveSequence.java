package facebook;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        int result = longestConsecutiveSequence(a);
        System.out.println(result);
    }

    private static int longestConsecutiveSequence(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) set.add(i);

        int result = 0;

        for (int i : a) {
            if (set.contains(i - 1)) continue;
            int temp = 0, j = i;
            while (set.contains(j)) {
                temp++; j++;
            }

            result = Math.max(result, temp);
        }

        return result;
    }
}
