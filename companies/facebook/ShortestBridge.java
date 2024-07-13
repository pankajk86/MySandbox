package facebook;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {

    private static int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};


    public static void main(String[] args) {
        int[][] a = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1}
        };
        int result = shortestBridge(a);
        System.out.println(result);
    }

    private static int shortestBridge(int[][] a) {
        int n = a.length;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    dfs(a, i, j, visited);
                    return bfs(a, visited);
                }
            }
        }
        return 0;
    }

    private static boolean isInvalid(int[][] a, int i, int j) {
        return i < 0 || j < 0 || i >= a.length || j >= a[0].length;
    }

    private static void dfs(int[][] a, int i, int j, boolean[][] visited) {
        if (isInvalid(a, i, j) || a[i][j] == 0 || visited[i][j]) return;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            dfs(a, i + dir[0], j + dir[1], visited);
        }
    }

    private static int bfs(int[][] a, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int result = 0, n = a.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    q.add(new int[]{i, j});
                }
            }
        }
        int size = q.size();

        while (!q.isEmpty()) {
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0], c = cur[1];

                for (int[] dir : dirs) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (isInvalid(a, nr, nc) || visited[nr][nc]) continue;
                    if (a[nr][nc] == 1) return result;
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            result++;
            size = q.size();
        }
        return 0;
    }


}
