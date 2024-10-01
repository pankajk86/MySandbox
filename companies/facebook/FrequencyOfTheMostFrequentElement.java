package facebook;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public static void main(String[] args) {
        int[] a = {1, 2, 4};
        int k = 5;

        int result = maxFrequency(a, k);
        System.out.println(result);
    }

    private static int maxFrequency(int[] a, int k) {
        Arrays.sort(a);
        int result = 0;
        long total = 0;

        for (int i = 0, j = 0; j < a.length; j++) {
            total += a[j];

            while ((long) a[j] * (j - i + 1) > total + k)
                total -= a[i++];

            result = Math.max(result, j - i + 1);
            j++;
        }
        return result;
    }
}
