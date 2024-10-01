package goal.algorithms.dp;

public class MaximumSubArray {

    public static void main(String[] args) {

        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4, 9 };
        int result = getMaxSubArraySum(arr);
        System.out.println(result);
    }

    private static int getMaxSubArraySum(int[] arr) {
        int maxEndingHere = arr[0], maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

//    private static int[] getMaxSubArraySum(int[] arr) {
//        int maxEndingHere = arr[0], maxSoFar = arr[0], maxEndIndex = 0;
//
//        for (int i = 1; i < arr.length; i++) {
//            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
//            if (maxEndingHere > maxSoFar) {
//                maxEndIndex = i;
//                maxSoFar = maxEndingHere;
//            }
//        }
//
//        return new int[] { maxEndIndex, maxSoFar }; // maxSoFar is the final result.
//    }

}
