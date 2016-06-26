package goal.phase.two.trees;

public class InorderSuccessor {

    public static void main(String[] args) {

        test1();
    }

    private static void test1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.parent = node2;
        node2.left = node1;

        node3.parent = node2;
        node2.right = node3;

        node2.parent = node4;
        node4.left = node2;

        node5.parent = node6;
        node6.left = node5;

        node7.parent = node6;
        node6.right = node7;

        node6.parent = node4;
        node4.right = node6;

        TreeNode successor = getInorderSuccessor(node1);
        System.out.println("Successor of node1: " + successor.data);

        successor = getInorderSuccessor(node2);
        System.out.println("Successor of node2: " + successor.data);

        successor = getInorderSuccessor(node3);
        System.out.println("Successor of node3: " + successor.data);

        successor = getInorderSuccessor(node4);
        System.out.println("Successor of node4: " + successor.data);
    }

    private static TreeNode getInorderSuccessor(TreeNode node) {

        if (node == null) {
            return null;
        }

        if (node.parent == null) {
            if (node.right == null) {
                return null;
            } else {
                node = node.right;
                while (node.left != null) {
                    node = node.left;
                }
                return node;
            }
        } else {
            if (node.right == null) {
                if (node.parent.left.data == node.data) {
                    return node.parent;
                } else {
                    while (node.parent.left.data != node.data) {
                        node = node.parent;
                    }
                    return node.parent;
                }
            } else {
                node = node.right;
                while (node.left != null) {
                    node = node.left;
                }
                return node;
            }
        }
    }

}

class TreeNode {
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    int data;

    public TreeNode(int data) {
        this.data = data;
    }
}
