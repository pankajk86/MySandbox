package goal.phase.two.arrays;

public class MinsizeSubarraySum {

    public static void main(String[] args) {

        int[] a = { 2, 3, 1, 2, 4, 3 };
        int sum = 7;

        int minSize = getMinSizeSubarraySum(a, sum);
        System.out.println("Result: " + minSize);
    }

    private static int getMinSizeSubarraySum(int[] a, int sum) {

        int i = 0, j = 0, temp = 0, size = Integer.MAX_VALUE;

        while (j < a.length) {
            temp += a[j];

            while (temp > sum) {
                temp -= a[i];
                i++;
            }

            if (temp == sum && (j - i + 1) < size) {
                size = j - i + 1;
            }

            j++;
        }

        return size;
    }

}
