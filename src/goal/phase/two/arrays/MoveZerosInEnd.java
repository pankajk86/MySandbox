package goal.phase.two.arrays;

public class MoveZerosInEnd {

    public static void main(String[] args) {
        int a[] = { 1, 0, 2, 3, 0, 4, 1, 0, 0, 5, 9, 7, 0 };

        for (int i = 0, j = a.length - 1; i < j; i++) {
            if (a[i] == 0) {
                while (a[j] == 0) {
                    j--;
                }
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                j--;
            }
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
