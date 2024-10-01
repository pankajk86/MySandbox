package facebook;

import trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTreeInserter {

    public static void main(String[] args) {
        TreeNode root = createTree();
        CBTInserter cbtInserter = new CBTInserter(root);

        cbtInserter.insert(3);
        cbtInserter.insert(4);
        System.out.println(cbtInserter.get_root());
    }

    private static TreeNode createTree() {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        n1.left = n2;
        return n1;
    }

}

class CBTInserter {

    private Queue<TreeNode> q = new LinkedList<>();
    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
        q.add(root);

        while (true) {
            TreeNode curr = q.peek();
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);
            if (curr.left != null && curr.right != null) q.poll();
            else break;
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        TreeNode curr = q.peek();
        if (curr.left == null) curr.left = node;
        else {
            curr.right = node;
            q.poll();
        }
        q.add(node);
        return curr.val;
    }

    public TreeNode get_root() {
        return this.root;
    }
}
