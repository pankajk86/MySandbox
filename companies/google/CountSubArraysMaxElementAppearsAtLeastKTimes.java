package google;

public class CountSubArraysMaxElementAppearsAtLeastKTimes {

    public static void main(String[] args) {
        int[] a = {1, 3, 2, 3, 3};
        int k = 2;

        long result = countSubArrays(a, k);
        System.out.println(result);
    }

    private static long countSubArrays(int[] a, int k) {
        int target = 0, start = 0, count = 0;

        for (int i : a) target = Math.max(target, i);

        long result = 0;
        for (int i : a) {
            if (i == target) count++;

            while (count == k) {
                if (a[start] == target) count--;
                start++;
            }

            result += start;
        }
        return result;
    }
}
