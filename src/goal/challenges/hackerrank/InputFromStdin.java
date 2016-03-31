package goal.challenges.hackerrank;

import java.util.Scanner;

public class InputFromStdin {

    public static void main(String[] args) {
        int arr[][] = new int[6][6];

        @SuppressWarnings("resource")
        Scanner stdin = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            String line = stdin.nextLine();
            String[] tokens = line.split(" ");
            arr[i][0] = Integer.parseInt(tokens[0]);
            arr[i][1] = Integer.parseInt(tokens[1]);
            arr[i][2] = Integer.parseInt(tokens[2]);
            arr[i][3] = Integer.parseInt(tokens[3]);
            arr[i][4] = Integer.parseInt(tokens[4]);
            arr[i][5] = Integer.parseInt(tokens[5]);
        }

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