package facebook;

import trees.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {

    public static void main(String[] args) {
        TreeNode root = createTree();
        TreeNode result = subtreeWithAllDeepest(root);
        System.out.println(result);
    }

    private static TreeNode subtreeWithAllDeepest(TreeNode root) {
        PairI result = dfs(root, 0);
        return result.node;
    }

    private static PairI dfs(TreeNode root, int depth) {
        if (root == null) return new PairI(null, 0);
        PairI left = dfs(root.left, depth);
        PairI right = dfs(root.right, depth);

        if (left.depth == right.depth) return new PairI(root, left.depth + 1);
        else if (left.depth < right.depth) return new PairI(right.node, right.depth + 1);
        else return new PairI(left.node, left.depth + 1);
    }

    private static TreeNode createTree() {
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

        return n3;
    }
}

class PairI {
    TreeNode node;
    int depth;

    public PairI(TreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}
