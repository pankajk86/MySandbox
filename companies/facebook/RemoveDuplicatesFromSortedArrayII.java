package facebook;

public class RemoveDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 2, 3, 3};
        int result = removeDuplicates(a);
        System.out.println(result);
    }

    private static int removeDuplicates(int[] a) {
        int index = 0;
        for (int i : a) {
            if (index == 0 || index == 1 || a[index - 2] != i) {
                a[index] = i;
                index++;
            }
        }
        return index;
    }
}
