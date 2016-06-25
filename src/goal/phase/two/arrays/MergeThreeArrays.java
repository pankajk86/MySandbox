package goal.phase.two.arrays;

public class MergeThreeArrays {

    public static void main(String[] args) {

        int a[] = { 1, 5, 8, 9 };
        int b[] = { 2, 3, 7, 10 };
        int c[] = { 4, 6, 11, 15 };

        int result[] = merge(a, b, c);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] merge(int[] a, int[] b, int[] c) {

        int temp[] = merge(a, b);
        int result[] = merge(temp, c);

        return result;
    }

    private static int[] merge(int[] a, int[] b) {

        int temp[] = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {
            temp[k] = a[i];
            i++;
            k++;
        }

        while (j < b.length) {
            temp[k] = b[j];
            j++;
            k++;
        }

        return temp;
    }

}
