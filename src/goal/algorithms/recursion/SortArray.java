package goal.algorithms.recursion;

public class SortArray {

    public static void main(String[] args) {
        int arr1[] = { 2, 4, 1, 6, 5, 9, 8 };
        int arr2[] = { -5, -3, 0, 1, 2, 3, 4, 5, 6, 7 };

        boolean isSorted1 = isArraySorted(arr1, arr1.length);
        boolean isSorted2 = isArraySorted(arr2, arr2.length);
        System.out.println(isSorted1 + "---" + isSorted2);
    }

    private static boolean isArraySorted(int[] arr, int length) {
        if (length == 1) {
            return true;
        }
        return (arr[length - 2] > arr[length - 1]) ? false : isArraySorted(arr, (length - 1));
    }

}
