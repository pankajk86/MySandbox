package goal.arrays;

public class MergeTwoSortedArrays {

    public static void main(String[] args) {
        int arr1[] = { 1, 3, 5, 7 };
        int arr2[] = { 2, 4, 6, 8, 9, 10 };

        int arr[] = mergeArrays(arr1, arr2);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] mergeArrays(int arr1[], int arr2[]) {
        int i = 0, j = 0, k = 0;
        int[] arr = new int[arr1.length + arr2.length];

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        if (i == arr1.length) {
            for (int l = j; l < arr2.length; l++, k++) {
                arr[k] = arr2[l];
            }
        }

        if (j == arr2.length) {
            for (int l = i; l < arr1.length; l++, k++) {
                arr[k] = arr2[l];
            }
        }

        return arr;
    }

}
