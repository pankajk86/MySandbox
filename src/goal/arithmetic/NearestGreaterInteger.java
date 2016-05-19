package goal.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class NearestGreaterInteger {

    public static void main(String[] args) {

        int a[] = { 1, 6, 3, 5, 2, 7, 10 };
        // int b[] = { 1, 3, 5, 7 };
        int i = 3;

        int j = getNearestGreaterInteger(a, i);
        System.out.println("Nearest Greater Integer Index: " + j);
    }

    private static int getNearestGreaterInteger(int[] a, int targetIndex) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int target = -1;
        int result = Integer.MAX_VALUE, resultIndex = -1;

        for (int i = 0; i < a.length; i++) {
            map.put(i, a[i]);

            if (targetIndex == i) {
                target = a[i];
            }
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();

            if (value > target && (value - target) < result) {
                result = value - target;
                resultIndex = entry.getKey();
            }
        }

        return (resultIndex > 0) ? resultIndex : 1;
    }

}
