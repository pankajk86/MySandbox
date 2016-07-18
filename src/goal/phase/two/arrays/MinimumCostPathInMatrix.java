package goal.phase.two.arrays;

import java.util.ArrayList;
import java.util.List;

public class MinimumCostPathInMatrix {

    private static int minCost = 0;

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3, 4 }, { 4, 2, 1, 3 }, { 3, 1, 4, 5 }, { 5, 2, 3, 1 } };
        List<Path> minPath = getMinPath(a);

        System.out.println("Min cost: " + minCost);
        System.out.println("(row, column): a[row][column]");
        for (int i = minPath.size() - 1; i >= 0; i--) {
            int r = minPath.get(i).row;
            int c = minPath.get(i).column;
            System.out.println("(" + r + ", " + c + "): " + a[r][c]);
        }
    }

    private static List<Path> getMinPath(int[][] a) {

        List<Path> minPath = new ArrayList<>();
        int numRows = a.length;
        int numColumns = a[0].length;
        
        int[][] path = new int[numRows][numColumns];
        path[0][0] = a[0][0];
        int i = 0, j = 0;

        for (i = 1; i < numRows; i++) {
            path[i][0] = path[i - 1][0] + a[i][0];
        }

        for (j = 1; j < numColumns; j++) {
            path[0][j] = path[0][j - 1] + a[0][j];
        }


        for (i = 1; i < numRows; i++) {
            for (j = 1; j < numColumns; j++) {
                path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + a[i][j];
            }
        }
        
        minCost = path[numRows - 1][numColumns - 1];

        Path p = new Path(numRows - 1, numColumns - 1);
        minPath.add(p);
        
        i = numRows-1;
        j = numColumns -1;

        while (i >= 0 && j >= 0) {

            if (i == 0) {
                p = new Path(i, j - 1);
                j--;
            } else if (j == 0) {
                p = new Path(i - 1, j);
                i--;
            } else {
                if (path[i - 1][j] < path[i][j - 1]) {
                    p = new Path(i - 1, j);
                    i--;
                } else {
                    p = new Path(i, j - 1);
                    j--;
                }
            }

            minPath.add(p);
            if (i == 0 && j == 0) {
                break;
            }

        }

        return minPath;
    }

    private static class Path {
        int row;
        int column;

        public Path(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

}
