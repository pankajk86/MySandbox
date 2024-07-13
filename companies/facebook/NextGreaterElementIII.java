package facebook;

public class NextGreaterElementIII {
    private static int result = 0;
    public static void main(String[] args) {
        int n = 12;
        result = nextGreater(n);
        System.out.println(result);
    }

    private static int nextGreater(int n) {
        char[] carr = String.valueOf(n).toCharArray();
        nextPermutation(carr);
        if (result != -1) {
            try {
                result = Integer.parseInt(String.valueOf(carr));
            } catch (NumberFormatException e) {
                result = -1;
            }
        }
        return result;
    }

    private static void nextPermutation(char[] a) {
        int minIndex = -1, n = a.length;
        for (int i = n - 1; i >= 0; i--) {
            if (i > 0 && a[i] > a[i - 1]) {
                minIndex = i - 1;
                break;
            }
        }

        int swapIndex = minIndex;
        if (minIndex != -1) {
            for (int i = n - 1; i > minIndex; i--) {
                if (a[i] > a[minIndex]) {
                    swapIndex = i;
                    break;
                }
            }
            swap(a, minIndex, swapIndex);
        } else {
            result = -1;
            return;
        }
        reverse(a, minIndex + 1);
    }

    private static void swap(char[] a, int i, int j) {
        char t = a[i]; a[i] = a[j]; a[j] = t;
    }

    private static void reverse(char[] a, int start) {
        for (int i = start, j = a.length - 1; i < j; i++, j--)
            swap(a, i, j);
    }
}
