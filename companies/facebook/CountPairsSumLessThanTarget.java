package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountPairsSumLessThanTarget {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(List.of(-6, 2, 5, -2, -7, -1, 3));
        int target = -2;

        int result = findPairs(a, target);
        System.out.println(result);
    }

    private static int findPairs(List<Integer> a, int target) {
        Collections.sort(a);
        int left = 0, right = a.size() - 1;
        int result = 0;

        while (left < right) {
            if (a.get(left) + a.get(right) < target) {
                result += right - left;
                left++;
            } else right--;
        }
        return result;
    }
}
