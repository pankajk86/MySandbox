package goal.arrays;

public class RotateTwoDSquareArray {

    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 11, 21},
                {4, 5, 6, 12, 22},
                {7, 8, 9, 13, 23},
                {17, 18, 19, 20, 24},
                {27, 28, 29, 30, 25},
        };

        int n = arr.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < Math.ceil(((double) n) / 2); j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - j][i];
                arr[n - 1 - j][i] = arr[n - 1 - i][n - 1 - j];
                arr[n - 1 - i][n - 1 - j] = arr[j][n - 1 - i];
                arr[j][n - 1 - i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
