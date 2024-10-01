package google;

import java.util.Arrays;
import java.util.List;

public class RegionCutBySlashes {

    public static void main(String[] args) {
        String[] grid = {
                "/\\",
                "\\/"
        };

        int result = regionsBySlashes(grid);
        System.out.println(result);
    }

    private static int regionsBySlashes(String[] grid) {
        int row1 = grid.length, col1 = grid[0].length();
        int row2 = grid.length * 3, col2 = grid[0].length() * 3;
        int[][] grid2 = new int[row2][col2];

        /*
        "/":
            [
                [0, 0, 1],
                [0, 1, 0],
                [1, 0, 0]
             ]

         "\":
            [
                [1, 0, 0],
                [0, 1, 0],
                [0, 0, 1]
             ]

          " ":
            [
                [0, 0, 0],
                [0, 0, 0],
                [0, 0, 0]
             ]
              01
             [/\]0
             [\/]1

              0  1  2    3  4  5
             [0, 0, 1], [1, 0, 0], 0
             [0, 1, 0], [0, 1, 0], 1
             [1, 0, 0], [0, 0, 1], 2
             [1, 0, 0], [0, 0, 1], 3
             [0, 1, 0], [0, 1, 0], 4
             [0, 0, 1], [1, 0, 0]  5
         */
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                int r2 = i * 3, c2 = j * 3;

                if (grid[i].charAt(j) == '/') {
                    grid2[r2][c2 + 2] = 1;
                    grid2[r2 + 1][c2 + 1] = 1;
                    grid2[r2 + 2][c2] = 1;
                } else if (grid[i].charAt(j) == '\\') {
                    grid2[r2][c2] = 1;
                    grid2[r2 + 1][c2 + 1] = 1;
                    grid2[r2 + 2][c2 + 2] = 1;
                }
            }
        }

        return countRegions(grid2);
    }

    private static int countRegions(int[][] a) {
        int m = a.length, n = a[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 0) {
                    count++;
                    merge(a, i, j);
                }
            }
        }
        return count;
    }

    private static void merge(int[][] a, int i, int j) {
        if (i < 0 || j < 0 || i >= a.length || j >= a[0].length || a[i][j] == 1) return;
        a[i][j] = 1;

        merge(a, i - 1, j);
        merge(a, i + 1, j);
        merge(a, i, j - 1);
        merge(a, i, j + 1);
    }
}
