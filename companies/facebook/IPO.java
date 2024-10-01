package facebook;

import java.util.PriorityQueue;

public class IPO {

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        int result = findMaximizedCapital(k, w, profits, capital);
        System.out.println(result);
    }

    private static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // {profit, capital}
        PriorityQueue<int[]> maxProfit = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        PriorityQueue<int[]> minCapital = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int n = profits.length;
        for (int i = 0; i < n; i++) {
            int[] toAdd = new int[]{profits[i], capital[i]};
            if (capital[i] <= w) maxProfit.add(toAdd);
            else minCapital.add(toAdd);
        }

        while (k > 0 && !maxProfit.isEmpty()) {
            k--;
            w += maxProfit.poll()[0];
            while (!minCapital.isEmpty() && minCapital.peek()[1] <= w) {
                maxProfit.add(minCapital.poll());
            }
        }

        return w;
    }
}
