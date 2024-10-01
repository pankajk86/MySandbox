package facebook;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> result = generate(n);
        System.out.println(result);
    }

    private static List<List<Integer>> generate(int n) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) temp.add(1);
            result.add(temp);
        }

        for (int i = 2; i < n; i++) {
            for (int j = 1; j < result.get(i).size() - 1; j++) {
                int val = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
                result.get(i).set(j, val);
            }
        }

        return result;
    }
}
