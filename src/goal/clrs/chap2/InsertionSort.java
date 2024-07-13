package goal.clrs.chap2;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 4, 6, 1, 3 };

        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int k = i - 1;

            while (arr[k] > current) {
                arr[k + 1] = arr[k];
                k--;
                if (k < 0)
                    break;
            }

            arr[k + 1] = current;
        }

        print(arr);
    }

    private static void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
