package goal.challenges.hackerrank;

public class MaxHourglassSumInTwoDArray {

    public static void main(String[] args) {
        int[][] arr = new int[][] { { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, -2, 6, 0, 5, 8 },
                { 3, 5, 1, 9, -9, 10 }, { 5, 3, 1, 6, 4, 4 }, { 7, 5, 2, 9, 5, 3 } };

        int maxSum = getMaxHourglassSum(arr);
        System.out.println("Max Hourglass Sum: " + maxSum);
    }

    private static int getMaxHourglassSum(int[][] arr) {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
                        + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                maxSum = (sum > maxSum) ? sum : maxSum;
            }
        }

        return maxSum;
    }

}
