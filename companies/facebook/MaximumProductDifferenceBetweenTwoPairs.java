package facebook;

public class MaximumProductDifferenceBetweenTwoPairs {

    public static void main(String[] args) {
        int[] a = {4, 2, 5, 9, 7, 4, 8};
        int result = maxProductDifference(a);
        System.out.println(result);
    }

    private static int maxProductDifference(int[] a) {
        int maxA = 0, maxB = 0, minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE;

        for (int i : a) {
            if (i < minA) {
                minB = minA;
                minA = i;
            } else if (i < minB) {
                minB = i;
            }

            if (i > maxA) {
                maxB = maxA;
                maxA = i;
            } else if (i > maxB) {
                maxB = i;
            }
        }
        return (maxA * maxB) - (minA * minB);
    }
}
