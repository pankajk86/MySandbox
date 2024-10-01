package facebook;

public class KthMissingPositiveNumber {

    public static void main(String[] args) {
        int[] a = {2,3,4,7,11};
        int k = 5;

        int result = findKthPositive(a, k);
        System.out.println(result);
    }

    private static int findKthPositive(int[] a, int k) {
        int left = 0, right = a.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            // missing = a[mid] - (mid + 1)
            if (a[mid] - mid - 1 < k) left = mid + 1;
            else right = mid;
        }
        return left + k;
    }
}
