package goal.phase.two.arrays;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {

        int a[] = { 4, 5, 6, 7, -1, 1, 2 };
        int min = getMinimum(a, 0, a.length - 1);

        System.out.println("Result: " + min);
    }

    private static int getMinimum(int[] a, int begin, int end) {

        if (begin == end || a[begin] < a[end]) {
            return a[begin];
        }

        if (end - begin == 1) {
            return Math.min(a[begin], a[end]);
        }

        int mid = begin + (end - begin) / 2;

        if (a[mid] > a[begin]) {
            return getMinimum(a, mid, end);
        } else {
            return getMinimum(a, begin, mid);
        }
    }

}
