package facebook;

import trees.TreeNode;

public class SumOfNodesWithEvenValuedGrandparent {

    static int result = 0;

    public static void main(String[] args) {
        TreeNode root = createTree();
        int result = sumEvenGrandParent(root);
        System.out.println(result);
    }

    private static int sumEvenGrandParent(TreeNode root) {
        dfs(root);
        return result;
    }

    private static void dfs(TreeNode root) {
        if (root == null) return;
        if (root.val % 2 == 0) {
            if (root.left != null && root.left.left != null) result += root.left.left.val;
            if (root.left != null && root.left.right != null) result += root.left.right.val;
            if (root.right != null && root.right.left != null) result += root.right.left.val;
            if (root.right != null && root.right.right != null) result += root.right.right.val;
        }
        dfs(root.left);
        dfs(root.right);
    }

    private static TreeNode createTree() {
        TreeNode n11 = new TreeNode(1);
        TreeNode n12 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n71 = new TreeNode(7);
        TreeNode n72 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);

        n2.left = n9;
        n72.left = n12; n72.right = n4;
        n71.left = n2; n71.right = n72;
        n3.right = n5;
        n8.left = n11; n8.right = n3;
        n6.left = n71; n6.right = n8;

        return n6;
    }
}
