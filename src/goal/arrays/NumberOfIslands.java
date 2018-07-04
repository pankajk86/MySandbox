package goal.arrays;

public class NumberOfIslands {

    public static void main(String[] args) {

        int arr[][] = {
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0}     
        };

        int count = getNumberOfIslands(arr);
        System.out.println("# of islands: " + count);
    }

    private static int getNumberOfIslands(int[][] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {  // updated arr[0] to arr[i]
                if (arr[i][j] == 1) {
                    count++;
                    merge(arr, i, j);
                }
            }
        }

        return count;
    }

    private static void merge(int[][] arr, int i, int j) {

        if (i < 0 || j < 0 || i > arr.length - 1 || j > arr[0].length - 1) {
            return;
        }

        if (arr[i][j] != 1) {
            return;
        }

        arr[i][j] = 0;

        merge(arr, i - 1, j);
        merge(arr, i + 1, j);
        merge(arr, i, j - 1);
        merge(arr, i, j + 1);
    }

}
