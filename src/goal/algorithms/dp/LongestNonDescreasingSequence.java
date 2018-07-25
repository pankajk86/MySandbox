package goal.algorithms.dp;

public class LongestNonDescreasingSequence {

    public static void main(String[] args) {

        int arr[] = { 1, 0, 3, 5, 3, 4, 8, 6, 5 };

        int result = getLongestNonDescreasingSequence(arr);
        System.out.println("# of longest non-decreasing sequence: " + result);
    }

    private static int getLongestNonDescreasingSequence(int[] arr) {

        int size = arr.length;
        int[] result = new int[size];
        int max = 0;

        for (int i = 0; i < size; i++) {
            result[i] = 1;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && result[j] + 1 > result[i]) {
                    result[i] = result[j] + 1;
                    max = Math.max(max, result[i]);
                }
            }
        }

        return max;
    }

}
