package facebook;

import java.util.*;

public class MakingALargeIsland {

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        int[][] a = {
                {1, 0}, {0, 1}
        };
        int result = largestIsland(a);
        System.out.println(result);
    }

    private static int largestIsland(int[][] a) {
        int n = a.length;
        Map<Integer, Integer> map = new HashMap<>();
        int label = 2;

        // 1. Pre-compute the existing island's size
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (a[r][c] == 1) {
                    map.put(label, dfs(a, r, c, label));
                    label++;
                }
            }
        }

        int result = map.isEmpty() ? 0 : Collections.max(map.values());

        // 2. Maximize the size if we flip a '0' cell with any existing islands.
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (a[r][c] == 0) {
                    result = Math.max(result, connect(a, r, c, map));
                }
            }
        }

        return result;
    }

    private static int connect(int[][] a, int r, int c, Map<Integer, Integer> map) {
        Set<Integer> visited = new HashSet<>();
        int size = 1, n = a.length;

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            if (!outOfBounds(nr, nc, n) && !visited.contains(a[nr][nc])) {
                size += map.getOrDefault(a[nr][nc], 0);
                visited.add(a[nr][nc]);
            }
        }
        return size;
    }

    private static int dfs(int[][] a, int r, int c, int label) {
        int n = a.length;
        if (outOfBounds(r, c, n) || a[r][c] != 1) return 0;

        a[r][c] = label;
        int size = 1;

        for (int[] dir : dirs) {
            int nr = r + dir[0], nc = c + dir[1];
            size += dfs(a, nr, nc, label);
        }

        return size;
    }

    private static boolean outOfBounds(int r, int c, int n) {
        return r < 0 || r == n || c < 0 || c == n;
    }

}
