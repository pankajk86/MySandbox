package arrays;

public class ClosestPairToTargetInArray {

    public static void main(String[] args) {
        int[] a = {3, 5, 6, 8, 9, 12, 13, 17};
        int target = 10;
        int[] result = findClosest(a, target);
        System.out.println(result[0] + ", " + result[1]);
    }

    private static int[] findClosest(int[] a, int target) {
        int[] result = new int[2];
        int n = a.length, diff = Integer.MAX_VALUE;

        for (int i = 0, j = n - 1; i < j;) {
            int sum = a[i] + a[j];
            int currDiff = Math.abs(sum - target);
            if (currDiff < diff) {
                diff = currDiff;
                result = new int[]{a[i], a[j]};
            }
            if (sum < target) i++;
            else j--;
        }
        return result;
    }
}
