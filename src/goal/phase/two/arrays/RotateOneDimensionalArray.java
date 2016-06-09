package goal.phase.two.arrays;

public class RotateOneDimensionalArray {

    public static void main(String[] args) {

        int a[] = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 6;

        int[] newA = rotateArray(a, k);

        for (int i = 0; i < newA.length; i++) {
            System.out.print(newA[i] + " ");
        }
    }

    private static int[] rotateArray(int a[], int k) {
        int n = a.length; // 7

        int temp[] = new int[k];

        for (int i = (n - k), j = 0; i < n; i++, j++) { // n-k = 4
            temp[j] = a[i];
        }

        for (int i = (n - k - 1); i >= 0; i--) { // i = 3->0
            a[i + k] = a[i];
        }

        for (int i = 0; i < k; i++) {
            a[i] = temp[i];
        }

        return a;
    }
}
