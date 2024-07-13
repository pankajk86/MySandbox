package facebook;

public class MergeSortedArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] b = {2, 5, 6};
        int n = 3;

        mergeSortedArrays(a, m, b, n);

        for (int i : a) System.out.print(i + " ");
    }

    private static void mergeSortedArrays(int[] a, int m, int[] b, int n) {
        int index = a.length - 1;
        int i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) a[index--] = a[i--];
            else a[index--] = b[j--];
        }

        while (j >= 0) {
            a[index--] = b[j--];
        }
    }
}
