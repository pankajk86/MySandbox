package goal.phase.two.trees;

import java.util.LinkedList;
import java.util.List;

public class ListOfNodesInSameDepth {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(4);
        bst.add(2);
        bst.add(6);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(8);

        List<List<Node>> lists = getListsOfNodes(bst.getRoot());

        for (List<Node> list : lists) {
            for (Node node : list) {
                System.out.print(node.data + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Node>> getListsOfNodes(Node root) {

        List<Node> queue = new LinkedList<Node>();
        queue.add(root);

        List<List<Node>> lists = new LinkedList<List<Node>>();

        List<Node> d1 = new LinkedList<Node>();
        d1.add(root);
        lists.add(d1);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node node = queue.remove(0);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            List<Node> d = new LinkedList<Node>();

            for (Node n : queue) {
                d.add(n);
            }

            lists.add(d);
        }

        return lists;
    }

}
