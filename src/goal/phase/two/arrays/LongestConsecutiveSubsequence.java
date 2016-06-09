package goal.phase.two.arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {

        int[] arr = { 10, 4, 20, 1, 3, 2 };
        int result = getLongestConsecutiveSubsequence(arr);

        System.out.println("Result: " + result);
    }

    private static int getLongestConsecutiveSubsequence(int[] arr) {

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int i : arr) {
            set.add(i);
        }

        for (int i : arr) {
            int left = i - 1;
            int right = i + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(max, count);
        }

        return max;
    }

}
