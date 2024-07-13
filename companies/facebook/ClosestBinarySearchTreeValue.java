package facebook;

import trees.TreeNode;

public class ClosestBinarySearchTreeValue {

    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        TreeNode root = createTree();
        double target = 3.714286;
        int result = closestValue(root, target);
        System.out.println(result);
    }

    private static int closestValue(TreeNode root, double target) {
        double rootDiff = Math.abs(root.val - target);
        double resultDiff = Math.abs(result - target);

        if (rootDiff < resultDiff) result = root.val;
        if (rootDiff == resultDiff) result = Math.min(root.val, result);

        if (root.left != null) closestValue(root.left, target);
        if (root.right != null) closestValue(root.right, target);
        return result;
    }

    private static TreeNode createTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);

        n2.left = n1; n2.right = n3;
        n4.left = n2; n4.right = n5;

        return n4;
    }
}
