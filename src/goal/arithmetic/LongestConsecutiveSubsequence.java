package goal.arithmetic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int arr[] = { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 };
        List<Integer> result = getLongestConsecutiveSubsequenceWithSorting(arr);

        for (int n : result) {
            System.out.println(n);
        }
    }

    private static List<Integer> getLongestConsecutiveSubsequenceWithSorting(int[] arr) {

        Arrays.sort(arr);
        int index = 0, localIndex = 0, count = 0, localCount = 0;
        List<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < arr.length - 1; i++) {
            localIndex = i;
            localCount = 1;

            while (arr[i + 1] - arr[i] == 1) {
                localCount++;
                i++;
            }

            if (localCount > count) {
                count = localCount;
                index = localIndex;
            }
        }

        for (int i = index; count > 0; i++, count--) {
            list.add(arr[i]);
        }

        return list;
    }

}
