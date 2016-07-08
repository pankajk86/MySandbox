package goal.algorithms.bit.manipulation;

public class SingleIntegerInDuplicatesArray {

    public static void main(String[] args) {
        int a[] = { 2, 1, 3, 2, 1, 5, 5, 6, 6 };
        int result = 0;

        for (int i = 0; i < a.length; i++) {
            result ^= a[i];
        }

        System.out.println(result);
    }

}
