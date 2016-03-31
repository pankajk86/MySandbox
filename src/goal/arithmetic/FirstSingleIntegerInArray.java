package goal.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class FirstSingleIntegerInArray {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 2, 1, 4, 5, 6, 5 };
        int value = getFirstSingleInteger(arr);
        System.out.println(value);
    }

    private static int getFirstSingleInteger(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int count = map.get(arr[i]);
                map.put(arr[i], ++count);
            } else {
                map.put(arr[i], 1);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int value = map.get(arr[i]);
            if (value == 1) {
                return arr[i];
            }
        }

        return -1;
    }

}
