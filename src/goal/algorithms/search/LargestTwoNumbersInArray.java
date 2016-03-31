package goal.algorithms.search;

public class LargestTwoNumbersInArray {

    public static void main(String[] args) {
        int[] arr = { 3, 6, 4, 1, 5, 2, 10, 20, 30, 25, 29 };
        int largestTwo[] = getLargestTwoNumbers(arr);

        System.out.println(largestTwo[0] + ", " + largestTwo[1]);
    }

    private static int[] getLargestTwoNumbers(int[] arr) {
        // l1 will contain the largest, l2 will contain the second largest
        int l1 = arr[0], l2 = arr[0];

        for (int val : arr) {
            // if next "val" is largest than l1, we will update both l1 and l2.
            if (val > l1) {
                l2 = l1;
                l1 = val;
            }
            // but if next "val" is greater than only l2, we will update only
            // l2.
            else if (val > l2 && val < l1) {
                l2 = val;
            }
        }

        int newArr[] = { l1, l2 };

        return newArr;
    }

}
