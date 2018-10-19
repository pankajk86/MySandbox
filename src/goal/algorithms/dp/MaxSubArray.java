package goal.algorithms.dp;

public class MaxSubArray {

    public static void main(String[] args) {

        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4, 9 };
        int[] maxSum = getMaxSubArraySum(arr);
        int sum = 0, i = maxSum[0];

        while (sum != maxSum[1]) {
            sum += arr[i];
            i--;
        }

        System.out.println("Begin Index: " + (i + 1) + ", End Index: " + maxSum[0] + ", Max Sum: " + maxSum[1]);
    }

    private static int[] getMaxSubArraySum(int[] arr) {
        int maxEndingHere = arr[0], maxSoFar = arr[0], maxEndIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            if (maxEndingHere > maxSoFar) {
                maxEndIndex = i;
                maxSoFar = maxEndingHere;
            }
        }

        return new int[] { maxEndIndex, maxSoFar };
    }

}
