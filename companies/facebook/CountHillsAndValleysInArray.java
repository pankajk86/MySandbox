package facebook;

public class CountHillsAndValleysInArray {

    public static void main(String[] args) {
        int[] a = {2, 4, 1, 1, 6, 5};
        int result = countHillAndValley(a);
        System.out.println(result);
    }

    private static int countHillAndValley(int[] a) {
        int result = 0, n = a.length;
        int left = a[0];

        for (int i = 1; i < n - 1; i++) {
            if (a[i] == a[i + 1]) continue;
            if (helper(left, a[i], a[i + 1])) result++;
            left = a[i];
        }

        return result;
    }

    private static boolean helper(int left, int mid, int right) {
        return (mid > left && mid > right) || (mid < left && mid < right);
    }
}
