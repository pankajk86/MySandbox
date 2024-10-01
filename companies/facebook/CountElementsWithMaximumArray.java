package facebook;

public class CountElementsWithMaximumArray {

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 1, 4};
        int result = totalMaxFrequency(a);
        System.out.println(result);
    }

    private static int totalMaxFrequency(int[] a) {
        int[] map = new int[101];
        for (int i : a) map[i]++;

        int result = 0, max = 0;
        for (int i = 1; i <= 100; i++) {
            max = Math.max(max, map[i]);
        }

        for (int i : map) {
            if (i == max) result += i;
        }

        return result;
    }
}
