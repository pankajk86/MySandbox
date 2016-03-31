package goal.algorithms.search;

public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int item = 2;
        int index = binarySearch(arr, item);
        System.out.println("Item " + item + " found at index: " + index);
    }

    public static int binarySearch(int arr[], int item) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = (low + (high - low) / 2);
            if (arr[mid] == item) {
                return mid;
            } else if (arr[mid] < item) {
                low = mid++;
            } else {
                high = mid--;
            }
        }
        return -1;
    }
}
