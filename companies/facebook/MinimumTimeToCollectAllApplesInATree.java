package facebook;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}};
        List<Boolean> hasApple = List.of(false, false, true, false, true, true, false);

        int result = minimumTime(n, edges, hasApple);
        System.out.println(result);
    }

    private static int minimumTime(int n, int[][] edges, List<Boolean> hasApple) {
        if (edges.length == 0) return 0;
        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        return dfs(0, -1, graph, hasApple);
    }

    private static int dfs(int curr, int parent, List<Integer>[] graph, List<Boolean> hasApple) {
        int time = 0;

        for (int child : graph[curr]) {
            if (child == parent) continue;

            int childTime = dfs(child, curr, graph, hasApple);
            if (childTime > time || hasApple.get(child))
                time += childTime + 2;
        }
        return time;
    }
}
