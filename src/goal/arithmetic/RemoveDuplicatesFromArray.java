package goal.arithmetic;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RemoveDuplicatesFromArray {

    public static void main(String[] args) {

        int arr[] = { 1, 2, 3, 3, 4, 5, 6, 5, 3 };
        arr = removeDuplicates(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        arr = removeDuplicatesWithoutHashMap(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static int[] removeDuplicates(int[] arr) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], 1);
        }

        arr = new int[map.size()];
        int j = 0;

        for (Entry<Integer, Integer> i : map.entrySet()) {
            arr[j] = i.getKey();
            j++;
        }

        return arr;
    }

    private static int[] removeDuplicatesWithoutHashMap(int[] arr) {

        int i = 1, j = 0;

        if (arr.length < 2) {
            return arr;
        }

        while (i < arr.length) {
            if (arr[i] == arr[j]) {
                i++;
            } else {
                arr[++j] = arr[i++];
            }
        }

        int brr[] = new int[j + 1];

        for (int k = 0; k < brr.length; k++) {
            brr[k] = arr[k];
        }

        return brr;
    }

}
