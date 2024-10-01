package facebook;

public class RemoveElement {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;

        int result = removeElement(a, val);
        System.out.println(result);
    }

    private static int removeElement(int[] a, int val) {
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] == val) continue;
            a[index++] = a[i];
        }

        return index;
    }
}
