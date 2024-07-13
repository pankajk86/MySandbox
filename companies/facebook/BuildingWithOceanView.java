package facebook;

import java.util.ArrayList;
import java.util.List;

public class BuildingWithOceanView {
    public static void main(String[] args) {
        int[] a = {4, 2, 3, 1};
        int[] result = findBuildings(a);
        for (int i : result) System.out.print(i + " ");
    }

    private static int[] findBuildings(int[] a) {
        List<Integer> list = new ArrayList<>();
        int n = a.length, max = a[n - 1];
        list.add(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > max) {
                list.add(i);
                max = a[i];
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0, j = list.size() - 1; j >= 0; i++, j--)
            result[i] = list.get(j);

        return result;
    }
}
