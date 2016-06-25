package goal.phase.two.arrays;

public class LargestTwoNumbers {

    public static void main(String args[]) {
        int a[] = { 3, 6, 4, 1, 5, 2, 10 };

        int l1 = a[0], l2 = a[0];

        for (int i : a) {
            if (i > l1) {
                l2 = l1;
                l1 = i;
            }
            if (i > l2 && i < l1) {
                l2 = i;
            }
        }
        System.out.println("Result: " + l1 + ", " + l2);
    }
}
