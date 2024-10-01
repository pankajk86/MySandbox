package facebook;

public class MakeTwoArraysEqualByReversingSubArrays {

    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4};
        int[] arr = {2, 4, 1, 3};

        boolean result = canBeEqual(target, arr);
        System.out.println(result);
    }

    private static boolean canBeEqual(int[] target, int[] arr) {
        int[] map = new int[1001];
        int n = target.length;

        for (int i = 0; i < n; i++) {
            map[target[i]]++;
            map[arr[i]]--;
        }

        for (int i = 0; i < 1001; i++) {
            if (map[i] != 0) return false;
        }

        return true;
    }
}
