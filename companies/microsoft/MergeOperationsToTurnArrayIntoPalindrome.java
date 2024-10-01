package microsoft;

public class MergeOperationsToTurnArrayIntoPalindrome {

    public static void main(String[] args) {
        int[] a = {4, 3, 2, 1, 2, 3, 1};
        int result = mergeOperationsCount(a);
        System.out.println(result);
    }

    private static int mergeOperationsCount(int[] a) {
        int left = 0, right = a.length - 1;
        int leftSum = a[left], rightSum = a[right];
        int result = 0;

        while (left < right) {
            if (leftSum == rightSum) {
                left++; right--;
                leftSum = a[left];
                rightSum = a[right];
            } else if (leftSum < rightSum) {
                result++;
                left++;
                leftSum += a[left];
            } else {
                result++;
                right--;
                rightSum += a[right];
            }
        }

        return result;
    }
}
