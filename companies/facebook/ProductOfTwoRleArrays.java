package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductOfTwoRleArrays {

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 3}};
        int[][] b = {{6, 3}, {3, 3}};

        List<List<Integer>> result = findRleArray(a, b);
        System.out.println(result);
    }

    private static List<List<Integer>> findRleArray(int[][] a, int[][] b) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0, j = 0; i < a.length && j < b.length;) {
            int prod = a[i][0] * b[j][0];
            int freq = 0;

            if (a[i][1] == b[j][1]) {
                freq = a[i][1];
                i++; j++;
            } else {
                if (a[i][1] < b[j][1]) {
                    freq = a[i++][1];
                    b[j][1] -= freq;
                } else {
                    freq = b[j++][1];
                    a[i][1] -= freq;
                }
            }

            if (result.isEmpty() || result.get(result.size() - 1).get(0) != prod) {
                result.add(List.of(prod, freq));
            } else {
                List<Integer> list = result.remove(result.size() - 1);
                result.add(List.of(prod, freq + list.get(1)));
            }
        }

        return result;
    }
}
