package goal.arithmetic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {

        int arr[] = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> list = new LinkedList<List<Integer>>();

        Arrays.sort(arr);
        int size = arr.length;

        for (int i = 0; i < size - 2; i++) {

            if (i == 0 || arr[i] > arr[i - 1]) {
                int a = arr[i];
                int start = i + 1;
                int end = size - 1;

                while (start < end) {
                    int b = arr[start];
                    int c = arr[end];

                    if (a + b + c == 0) {
                        List<Integer> triplet = new LinkedList<Integer>();
                        triplet.add(a);
                        triplet.add(b);
                        triplet.add(c);
                        list.add(triplet);
                        end--;
                    } else if (a + b + c > 0) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }

        for (List<Integer> triplet : list) {
            for (int n : triplet) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

}
