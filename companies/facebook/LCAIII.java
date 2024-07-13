package facebook;

import trees.TreeNode;

public class LCAIII {
    public static void main(String[] args) {
        TreeNode root = createTreeWithParent();
        TreeNode p = null, q = null;
        TreeNode result = lca(p, q);
        System.out.println(result.val);
    }

    private static TreeNode lca(TreeNode p, TreeNode q) {
        TreeNode a = p, b = q;
//        while (a != b) {
//            a = a != null ? a.parent : q;
//            b = b != null ? b.parent : p;
//        }
        return a;
    }

    private static TreeNode createTreeWithParent() {
        return null;
    }
}
