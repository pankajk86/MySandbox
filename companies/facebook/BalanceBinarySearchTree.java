package facebook;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = createTree();
        TreeNode result = balanceTree(root);
        System.out.println(result);
    }

    private static TreeNode balanceTree(TreeNode root) {
        inorder(root);
        return helper(0, list.size() - 1);
    }

    private static TreeNode helper(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = helper(left, mid - 1);
        root.right = helper(mid + 1, right);
        return root;
    }

    private static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }

    private static TreeNode createTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);

        n3.right = n4; n2.right = n3; n1.right = n2;
        return n1;
    }
}
