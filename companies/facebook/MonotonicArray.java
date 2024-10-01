package facebook;

public class MonotonicArray {

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 4};
        boolean result = isMonotonic(a);
        System.out.println(result);
    }

    private static boolean isMonotonic(int[] a) {
        int n = a.length;

        if (a[0] < a[n - 1]) {
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) return false;
            }
        } else {
            for (int i = 0; i < n - 1; i++) {
                if (a[i] < a[i + 1]) return false;
            }
        }
        return true;
    }
}
