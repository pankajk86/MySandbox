package goal.phase.two.trees;

public class CheckBinarySearchTree {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {
        BinarySearchTree bst = new BinarySearchTree(4);
        bst.add(2);
        bst.add(6);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(8);

        boolean result = isBST(bst.getRoot());
        System.out.println("Result of test1: " + result);
    }

    private static void test2() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node5.left = node1;
        node5.right = node2;
        node4.left = node5;

        node6.left = node7;
        node6.right = node3;
        node4.right = node6;

        boolean result = isBST(node4);
        System.out.println("Result of test2: " + result);
    }

    private static boolean isBST(Node root) {

        if (root == null) {
            return false;
        }

        if (root.left != null) {
            if (root.left.data < root.data) {
                return isBST(root.left);
            } else {
                return false;
            }
        }

        if (root.right != null) {
            if (root.right.data > root.data) {
                return isBST(root.right);
            } else {
                return false;
            }
        }

        return true;
    }

}
