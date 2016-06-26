package goal.phase.two.trees;

public class CheckBalancedTrees {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree(4);
        bst.add(2);
        bst.add(6);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(7);
        bst.add(8);
        bst.add(9);

        // Time Complexity: O(n^2)
        boolean result = isTreeBalanced(bst.getRoot());
        System.out.println("Result: " + result);

        // Time Complexity: O(log N)
        result = isBalanced(bst.getRoot());
        System.out.println("Result: " + result);
    }

    private static boolean isTreeBalanced(Node root) {

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return (Math.abs(leftHeight - rightHeight) <= 1);
    }

    private static int getHeight(Node root) {

        if (root == null) {
            return 0;
        }

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static boolean isBalanced(Node root) {
        return (checkHeight(root) == -1 ? false : true);
    }

    private static int checkHeight(Node root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
