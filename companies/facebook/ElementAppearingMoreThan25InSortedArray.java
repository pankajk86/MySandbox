package facebook;

public class ElementAppearingMoreThan25InSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int result = findSpecialInteger(a);
        System.out.println(result);
    }

    private static int findSpecialInteger(int[] a) {
        int n = a.length, block = n / 4;

        for (int i = 0; i < n - block; i++) {
            if (a[i] == a[i + block]) return a[i];
        }
        return -1;
    }
}
