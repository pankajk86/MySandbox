package microsoft;

public class MinimizingArrayAfterReplacingPairsWithProduct {

    public static void main(String[] args) {
        int[] a = {2, 3, 3, 7, 3, 5};
        int k = 20;

        int result = minArrayLength(a, k);
        System.out.println(result);
    }

    private static int minArrayLength(int[] a, int k) {
        int n = a.length;
        int result = 0;

        for (int i = 0; i < n; ) {
            int j = i;
            long t = 1;
            while (j < n && (t *= a[j]) <= k) {
                if (a[j] == 0) return 1;
                j++;
            }
            result++;
            i = Math.max(i + 1, j);
        }

        return result;
    }
}
