package facebook;

import trees.TreeNode;

public class LCAII {

    private static boolean foundP = false, foundQ = false;

    public static void main(String[] args) {
        TreeNode[] treeNodes = createTree();
        TreeNode result = lca(treeNodes[0], treeNodes[1], treeNodes[2]);
        System.out.println(result);
    }

    private static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = helper(root, p, q);
        return foundP && foundQ ? lca : null;
    }

    private static TreeNode helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        TreeNode left = helper(root.left, p, q);
        TreeNode right = helper(root.right, p, q);

        if (root == p) {
            foundP = true;
            return root;
        }

        if (root == q) {
            foundQ = true;
            return root;
        }

        return (left != null && right != null) ? root : (left != null ? left : right);
    }

    private static TreeNode[] createTree() {
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);

        n2.left = n7; n2.right = n4;
        n5.left = n6; n5.right = n2;
        n1.left = n0; n1.right = n8;
        n3.left = n5; n3.right = n1;
        return new TreeNode[]{n3, n5, n4};
    }
}
