package goal.algorithms.search;

public class SearchInRotatedArray {

    public static void main(String[] args) {
        int arr[] = { 12, 13, 14, 15, 1, 2, 3, 4, 5, 6 };
        int searchItem = 15;
        int index = search(arr, 0, arr.length - 1, searchItem);
        System.out.println("Index of " + searchItem + " is: " + index);
    }

    private static int search(int[] arr, int left, int right, int data) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == data) {
            return mid;
        }

        // if the left half [arr[left], arr[mid]] is sorted.
        if (arr[left] <= arr[mid]) {

            // arr[left] <= data < arr[mid]
            if (data >= arr[left] && data < arr[mid]) {
                return search(arr, left, mid - 1, data);
            }

            // arr[mid] < data <= arr[right]
            else {
                return search(arr, mid + 1, right, data);
            }
        }
        // if the right half [arr[mid], arr[right]] is sorted.
        else {

            // arr[mid] < data <= arr[right]
            if (data > arr[mid] && data <= arr[right]) {
                return search(arr, mid + 1, right, data);
            }

            // arr[left] <= data < arr[mid]
            else {
                return search(arr, left, mid - 1, data);
            }
        }
    }

}
