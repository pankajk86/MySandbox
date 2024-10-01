package google;

public class ShortestUnsortedSubArray {

    public static void main(String[] args) {
        int[] a = {2, 6, 4, 8, 10, 9, 15};
        int result = unsortedSubArray(a);
        System.out.println(result);
    }

    private static int unsortedSubArray(int[] a) {
        int n = a.length;

        int start = 0, min = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (a[i] > min) start = i;
            else min = a[i];
        }

        int end = -1, max = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] < max) end = i;
            else max = a[i];
        }

        return end - start + 1;
    }
}
