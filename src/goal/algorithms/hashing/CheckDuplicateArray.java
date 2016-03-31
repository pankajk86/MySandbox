package goal.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckDuplicateArray {

    public static void main(String[] args) {
        int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int arr2[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        boolean check = ifDuplicateArrays(arr1, arr2);
        System.out.println("Arrays are same?: " + check);
    }

    private static boolean ifDuplicateArrays(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], 1);
        }

        for (int i = 0; i < arr2.length; i++) {
            if (!map.containsKey(arr2[i])) {
                return false;
            }
        }

        return true;
    }

}
