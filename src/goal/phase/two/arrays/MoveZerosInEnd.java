package goal.phase.two.arrays;

public class MoveZerosInEnd {

    public static void main(String[] args) {
        int[] a = { 1, 0, 2, 3, 0, 4, 1, 0, 0, 5, 9, 7, 0 };

        moveZeros(a);

        for (int j : a) {
            System.out.print(j + " ");
        }
    }

    private static void moveZeros(int[] a) {
        int index = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                a[index++] = a[i];
            }
        }

        for (int i = index; i < a.length; i++) {
            a[i] = 0;
        }
    }

}
