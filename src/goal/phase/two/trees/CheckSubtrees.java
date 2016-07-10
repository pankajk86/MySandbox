package goal.phase.two.trees;

public class CheckSubtrees {

    public static void main(String[] args) {
        test1();
        test2();
    }

    private static void test1() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);

        node2.left = node1;
        node2.right = node3;

        node8.left = node7;
        node8.right = node9;

        node6.left = node5;
        node6.right = node8;

        node4.left = node2;
        node4.right = node6;

        boolean result = checkSubtree(node4, node6);
        System.out.println("Result of test1: " + result);
    }

    /**
     *           6
     *         /   \
     *        /     \
     *       /       \
     *      /         \ 
     *     /           \
     *    2             12
     *   / \           /  \
     *  /   \         /    \
     * 1     4       10     14
     *      / \     /  \    / \
     *     3   5   8    11 13  15
     *            / \
     *           7   9
     *  
     */
    private static void test2() {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        Node node15 = new Node(15);

        node4.left = node3;
        node4.right = node5;

        node2.left = node1;
        node2.right = node4;

        node8.left = node7;
        node8.right = node9;

        node10.left = node8;
        node10.right = node11;

        node14.left = node13;
        node14.right = node15;

        node12.left = node10;
        node12.right = node14;

        node6.left = node2;
        node6.right = node12;

        boolean result = checkSubtree(node4, node6);
        System.out.println("Result of test2 (parent: node4, child: node6): " + result);

        result = checkSubtree(node6, node10);
        System.out.println("Result of test2 (parent: node6, child: node10): " + result);

        result = checkSubtree(node12, node4);
        System.out.println("Result of test2 (parent: node12, child: node4): " + result);

        result = checkSubtree(node12, node10);
        System.out.println("Result of test2 (parent: node12, child: node10): " + result);

        result = checkSubtree(node10, node13);
        System.out.println("Result of test2 (parent: node10, child: node13): " + result);

        result = checkSubtree(node10, node9);
        System.out.println("Result of test2 (parent: node10, child: node9): " + result);

        result = checkSubtree(node10, null);
        System.out.println("Result of test2 (parent: node10, child: null): " + result);
    }

    private static boolean checkSubtree(Node parent, Node child) {

        if (parent == null && child == null) {
            return true;
        } else if (parent != null && child == null) {
            return true;
        } else if (parent == null && child != null) {
            return false;
        }

        if (child.data < parent.data) {
            return checkSubtree(parent.left, child);
        } else if (child.data > parent.data) {
            return checkSubtree(parent.right, child);
        } else {
            return (checkSubtree(parent.left, child.left) && checkSubtree(parent.right, child.right));
        }
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}
