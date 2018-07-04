package goal.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PairsWithGivenSum {

    public static void main(String[] args) {

        int arr[] = { 2, 4, 3, 5, 6, 1, 4, 7, 8, 9 };
        int sum = 10;

        for (Pair pair : getPairsWithGivenSum(arr, sum)) {
            System.out.println("(" + pair.getFirst() + ", " + pair.getSecond() + ")");
        }
    }

    private static List<Pair> getPairsWithGivenSum(int[] arr, int sum) {

        Set<Integer> numberSet = new TreeSet<Integer>();
        List<Pair> pairList = new ArrayList<Pair>();

        for (int i = 0; i < arr.length; i++) {
            numberSet.add(arr[i]);
        }

        for (Integer i : numberSet) {
            int value = sum - i;
            if (numberSet.contains(value)) {
                Pair pair = new Pair(i, value);
                pairList.add(pair);
            }
        }

        return pairList;
    }

}

class Pair {
    private int first;
    private int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }
}
