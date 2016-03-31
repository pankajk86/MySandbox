package goal.arithmetic;

public class SmallestElementGreaterThanTheKey {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 4, 5, 6, 8, 9, 13, 15, 16 };
        int key = 14;

        int result = getSmallestElementGreaterThanTheKey(arr, 0, arr.length - 1, key);
        System.out.println(result);
    }

    private static int getSmallestElementGreaterThanTheKey(int[] arr, int begin, int end, int key) {

        while (begin < end) {
            int mid = begin + (end - begin) / 2;

            if (arr[mid] > key && arr[mid - 1] < key) {
                return arr[mid];
            }

            if (key < arr[mid]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }

        return 0;
    }

}
