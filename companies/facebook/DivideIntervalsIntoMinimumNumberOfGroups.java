package facebook;

import java.util.Arrays;

public class DivideIntervalsIntoMinimumNumberOfGroups {

    public static void main(String[] args) {
        int[][] a = {{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}};
        int result = minimumGroups(a);
        System.out.println(result);
    }

    private static int minimumGroups(int[][] a) {
       int n = a.length;
       int[] start = new int[n], end = new int[n];

       for (int i = 0; i < n; i++) {
           start[i] = a[i][0];
           end[i] = a[i][1];
       }

       Arrays.sort(start); Arrays.sort(end);

       int result = 0;
       for (int i = 0, j = 0; i < n; i++) {
           if (start[i] < end[j]) result++;
           else j++;
       }

       return result;
    }
}
