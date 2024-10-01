package facebook;

import java.util.HashSet;
import java.util.Set;

public class ValidateBinaryTreeNodes {

    public static void main(String[] args) {
        int n = 4;
        int[] leftChild = {1, -1, 3, -1}, rightChild = {2, -1, -1, -1};
        boolean result = validateBinaryTreeNodes(n, leftChild, rightChild);
        System.out.println(result);
    }

    private static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set = new HashSet<>();
        for (int i : leftChild) {
            if (i != -1) set.add(i);
        }
        for (int i : rightChild) {
            if (i != -1) set.add(i);
        }

        if (set.size() == n) return false;
        int root = -1;

        for (int i = 0; i < n; i++) {
            if (!set.contains(i)) {
                root = i;
                break;
            }
        }

        Set<Integer> visited = new HashSet<>();
        boolean check = dfs(root, leftChild, rightChild, visited);
        return check && visited.size() == n;
    }

    private static boolean dfs(int root, int[] leftChild, int[] rightChild, Set<Integer> visited) {
        if (root == -1) return true;
        if (visited.contains(root)) return false;
        visited.add(root);

        boolean left = dfs(leftChild[root], leftChild, rightChild, visited);
        boolean right = dfs(rightChild[root], leftChild, rightChild, visited);
        return left && right;
    }
}
