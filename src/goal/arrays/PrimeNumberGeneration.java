package goal.arrays;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumberGeneration {

    public static void main(String[] args) {

        int limit = 100;

        for (Integer i : getPrimeList(limit)) {
            System.out.print(i + " ");
        }
    }

    /*
     * Sieve of Eratosthenes algorithm
     */
    private static List<Integer> getPrimeList(int limit) {

        List<Integer> primeList = new ArrayList<Integer>();

        for (int i = 2; i <= limit; i++) {
            primeList.add(i);
        }

        for (int i = 0; i < primeList.size(); i++) {
            int val = primeList.get(i);

            /*
             * for each of the number in the list (from the beginning, i.e. 2),
             * we need to keep removing all the other composite numbers.
             */
            for (int j = i + 1; j < primeList.size(); j++) {
                int compositeVal = primeList.get(j);
                if (compositeVal % val == 0) {
                    primeList.remove(j);
                }
            }
        }

        return primeList;
    }

}
