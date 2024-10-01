package facebook;

public class JumpGameII {

    public static void main(String[] args) {
        int[] a = {2, 3, 1, 1, 4};
        int result = minimumJump(a);
        System.out.println(result);
    }

    private static int minimumJump(int[] a) {
        int result = 0, left = 0, right = 0;

        // left, right is the current window.

        while (right < a.length - 1) {
            int farthest = 0;
            // we check to find out the farthest index, we can reach from the current window.
            for (int i = left; i <= right; i++)
                farthest = Math.max(farthest, i + a[i]);

            // for the next iteration
            // left will be the first index outside the current window.
            // right will be the farthest we can reach from the current window.
            left = right + 1;
            right = farthest;

            // until we reach the end, we will keep increasing the count.
            result++;
        }
        return result;
    }
}
