package facebook;

import trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = 1;
        List<Integer> temp = new ArrayList<>();

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            size--;
            if (curr.left != null) q.add(curr.left);
            if (curr.right != null) q.add(curr.right);

            temp.add(curr.val);

            if (size == 0) {
                result.add(temp);
                temp = new ArrayList<>();
                size = q.size();
            }
        }
        return result;
    }
}
