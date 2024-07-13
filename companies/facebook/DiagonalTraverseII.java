package facebook;

import java.util.*;

public class DiagonalTraverseII {

    public static void main(String[] args) {
        List<List<Integer>> a = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7),
                Arrays.asList(8),
                Arrays.asList(9, 10, 11),
                Arrays.asList(12, 13, 14, 15, 16)
        );

        int[] result = findDiagonalOrder(a);
        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    private static int[] findDiagonalOrder(List<List<Integer>> a) {
        List<Integer> list = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            list.add(a.get(r).get(c));

            if (c == 0 && r + 1 < a.size()) q.add(new int[]{r + 1, c});
            if (c + 1 < a.get(r).size()) q.add(new int[]{r, c + 1});
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
}
