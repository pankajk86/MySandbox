package facebook;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicateII {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 1};
        int k = 3;

        boolean result = containsDuplicate(a, k);
        System.out.println(result);

        result = containsDuplicate2(a, k);
        System.out.println(result);
    }

    private static boolean containsDuplicate(int[] a, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(a[i]) && Math.abs(i - map.get(a[i])) <= k) return true;
            map.put(a[i], i);
        }
        return false;
    }

    private static boolean containsDuplicate2(int[] a, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0, j = 0; j < a.length; j++) {
            if (j - i > k) set.remove(a[i++]);
            if (set.contains(a[j])) return true;
            set.add(a[j]);
        }
        return false;
    }
}
