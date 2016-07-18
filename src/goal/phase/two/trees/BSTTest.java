package goal.phase.two.trees;

import java.util.ArrayList;
import java.util.List;

public class BSTTest {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree(4);
        bst.add(2);
        bst.add(6);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(8);

        bst.print(bst.getRoot());

        List<Node> inorderList = new ArrayList<Node>();
        inorderList = inorder(bst.getRoot(), inorderList);

        System.out.print("\nInorder traversal: ");
        for (Node node : inorderList) {
            System.out.print(node.data + " ");
        }
    }

    private static List<Node> inorder(Node root, List<Node> inorderList) {

        if (root != null) {
            inorder(root.left, inorderList);
            inorderList.add(root);
            inorder(root.right, inorderList);
        }

        return inorderList;
    }

}
