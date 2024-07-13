package facebook;

import trees.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversalII {

    public static void main(String[] args) {

    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Node>> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, root));
        int minCol = 0, maxCol = 0;

        List<List<Integer>> result = new ArrayList<>();

        while (!q.isEmpty()) {
            Node curr = q.poll();
            int col = curr.col;
            int level = curr.level;

            List<Node> list = map.getOrDefault(col, new ArrayList<>());
            list.add(curr);
            map.put(col, list);

            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (curr.node.left != null) q.add(new Node(level + 1, col - 1, curr.node.left));
            if (curr.node.right != null) q.add(new Node(level + 1, col + 1, curr.node.right));
        }

        for (int i = minCol; i <= maxCol; i++) {
            List<Node> list = map.get(i);
            list.sort((n1, n2) ->
                    n1.level != n2.level ? n1.col - n2.col : n1.node.val - n2.node.val
            );
            List<Integer> l = new ArrayList<>();
            for (Node n : list) l.add(n.node.val);
            result.add(l);
        }
        return result;
    }


}


class Node {
    int level;
    int col;
    TreeNode node;

    Node(int level, int col, TreeNode node) {
        this.level = level;
        this.col = col;
        this.node = node;
    }
}