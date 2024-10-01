package google;

public class BinarySubArraysWithSum {

    public static void main(String[] args) {
        int[] a = {1, 0, 1, 0, 1};
        int goal = 2;

        int result = countSubArraysWithSum(a, goal);
        System.out.println(result);
    }

    private static int countSubArraysWithSum(int[] a, int goal) {
        return helper(a, goal) - helper(a,  goal - 1);
    }

    private static int helper(int[] a, int goal) {
        if (goal < 0) return 0;
        int result = 0, curr = 0;

        for (int l = 0, r = 0; r < a.length; r++) {
            curr += a[r];
            while (curr > goal) curr -= a[l++];
            result += r - l + 1;
        }
        return result;
    }
}
