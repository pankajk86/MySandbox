package facebook;

import java.util.*;

public class CourseSchedulerII {

    public static void main(String[] args) {
        int[][] pres = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int n = 4;
//        int[][] pres = {{1, 0}, {0, 1}};
//        int n = 2;

        int[] result = findOrder(n, pres);
        System.out.println(Arrays.toString(result));

    }

    private static int[] findOrder(int n, int[][] pres) {
        NodeI[] nodes = new NodeI[n];
        for (int i = 0; i < n; i++) nodes[i] = new NodeI(i);
        for (int[] pre : pres) nodes[pre[0]].pres.add(nodes[pre[1]]);

        for (NodeI node : nodes) {
            if (node.isCyclic()) return new int[]{};
        }

        Set<Integer> visited = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for (NodeI node : nodes) {
            if (!visited.contains(node.val)) {
                dfs(node, list, visited);
                if (list.size() == n) break;
            }
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) result[i] = list.get(i);
        return result;
    }

    private static void dfs(NodeI node, List<Integer> list, Set<Integer> visited) {
        for (NodeI n : node.pres) {
            if (!visited.contains(n.val))
                dfs(n, list, visited);
        }
        visited.add(node.val);
        list.add(node.val);
    }
}



class NodeI {
    int val;
    boolean visited, done;
    List<NodeI> pres = new ArrayList<>();

    public NodeI(int val) {
        this.val = val;
    }

    public boolean isCyclic() {
        if (done) return false;
        if (visited) return true;
        visited = true;

        for (NodeI node : pres) {
            if (node.isCyclic()) {
                return true;
            }
        }

        done = true;
        return false;
    }
}