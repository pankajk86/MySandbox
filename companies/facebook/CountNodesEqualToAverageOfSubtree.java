package facebook;

import trees.TreeNode;

public class CountNodesEqualToAverageOfSubtree {

    private static int result = 0;

    public static void main(String[] args) {
        TreeNode root  = createTree();
        int result = averageOfSubtree(root);
        System.out.println(result);
    }

    private static int averageOfSubtree(TreeNode root) {
        dfs(root);
        return result;
    }

    private static int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        // {# of nodes, sum}
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int count = 1 + left[0] + right[0];
        int sum = root.val + left[1] + right[1];

        if (sum / count == root.val) result++;
        return new int[]{count, sum};
    }

    private static TreeNode createTree() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n8 = new TreeNode(8);

        n8.left = n0; n8.right = n1;
        n5.right = n6;
        n4.left = n8; n4.right = n5;

        return n4;
    }
}
