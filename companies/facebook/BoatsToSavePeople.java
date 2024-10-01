package facebook;

import java.util.Arrays;

public class BoatsToSavePeople {

    public static void main(String[] args) {
        int[] a = {3, 2, 2, 1};
        int limit = 3;

        int result = minimumBoats(a, limit);
        System.out.println(result);
    }

    private static int minimumBoats(int[] a, int limit) {
        Arrays.sort(a);
        int result = 0;

        for (int i = 0, j = a.length - 1; i <= j; ) {
            if (a[i] + a[j] <= limit) i++;
            j--;
            result++;
        }
        return result;
    }
}
