package facebook;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;

        int[][] result = kClosest(points, k);
        for (int[] p : result)
            System.out.println(Arrays.toString(p));
    }

    private static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> dist(p2) - dist(p1));

        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > k) pq.poll();
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) result[i] = pq.poll();
        return result;
    }

    private static int dist(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}
