package goal.algorithms.dnc;

public class MergeSort {

    public static void main(String[] args) {
        int A[] = { 3, 1, 4, 2, 6, 5, 2, 8, 7 };
        mergeSort(A, 0, A.length - 1);

        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
    }

    public static void mergeSort(int A[], int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid + 1, right); // why did I do mid+1 here? A: that
                                            // is the beginning of second part
        }
    }

    private static void merge(int[] A, int left, int mid, int right) {
        int j = left, k = mid - 1;
        int temp[] = new int[A.length];
        int num = right - left + 1;

        while (left <= k && mid <= right) {
            if (A[left] <= A[mid]) {
                temp[j] = A[left];
                left++;
            } else {
                temp[j] = A[mid];
                mid++;
            }
            j++;
        }

        while (left <= k) {
            temp[j] = A[left];
            left++;
            j++;
        }

        while (mid <= right) {
            temp[j] = A[mid];
            mid++;
            j++;
        }

        // how this for loop works?
        /*
         * A: The idea is to move everything from temp to A array. now, we can't
         * rely on the length of the array A, because at a time we might be
         * working on a small part of that. So that's why, we are using
         * (right-left+1) to calculate the actual number of elements under
         * current split.
         * 
         * The reason, why we are using "right" is because that's the only
         * variable (out of all left, mid and right) which has been left
         * untouched until now. So, we use it to move elements from temp to A.
         */
        for (int i = 0; i < num; i++) {
            A[right] = temp[right];
            right--;
        }
    }
}
