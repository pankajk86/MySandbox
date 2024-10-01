package facebook;

public class MajorityElement {

    public static void main(String[] args) {
        int[] a = {2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(a);
        System.out.println(result);
    }

    private static int majorityElement(int[] a) {
        int result = 0, count = 0;

        for (int i : a) {
            if (count == 0) result = i;
            count += i == result ? 1 : -1;
        }
        return result;
    }
}
