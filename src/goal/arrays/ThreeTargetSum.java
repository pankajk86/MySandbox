package goal.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeTargetSum {

    public static void main(String[] args) {

        int a[] = { 1, 2, 3, 3 };
        int b[] = { 2, 3, 3, 4 };
        int c[] = { 1, 2, 2, 2 };
        int target = 7;

        List<List<Integer>> list = getThreeTargetSumList(a, b, c, target);

        for (List<Integer> sub : list) {
            for (int n : sub) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> getThreeTargetSumList(int[] a, int[] b, int[] c, int target) {

        Set<Integer> set = new HashSet<Integer>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for (int n : c) {
            set.add(n);
        }
        
        for (int na : a) {
            for (int nb : b) {
                int value = target - (na + nb);
                if (set.contains(value)) {
                    List<Integer> setFound = new ArrayList<Integer>();
                    setFound.add(na);
                    setFound.add(nb);
                    setFound.add(value);
                    list.add(setFound);
                }
            }
        }

        return list;
    }

}
