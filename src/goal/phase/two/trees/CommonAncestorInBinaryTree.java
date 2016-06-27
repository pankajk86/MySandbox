package goal.phase.two.trees;

public class CommonAncestorInBinaryTree {

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node2.left = node1;
        node2.right = node3;

        node6.left = node5;
        node6.right = node7;

        node4.left = node2;
        node4.right = node6;

        Node node = getCommonAncestor(node4, node3, node7);
        System.out.println("Result: " + node.data);

        Result result = getAncestor(node4, node3, node7);
        node = (result.isAncestor ? result.node : null);

        if (node != null) {
            System.out.println("Result: " + node.data);
        } else {
            System.out.println("No common ancestor");
        }
    }

    /**
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static Result getAncestor(Node root, Node p, Node q) {

        if (root == null) {
            return new Result(root, false);
        }

        if (root.data == p.data && root.data == q.data) {
            return new Result(root, true);
        }

        Result rx = getAncestor(root.left, p, q);
        if (rx.isAncestor) {
            return rx;
        }

        Result ry = getAncestor(root.right, p, q);
        if (ry.isAncestor) {
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            return new Result(root, true);
        } else if (root.data == p.data || root.data == q.data) {
            /*
             * If current root node is one of p or q, and in the subtree, we
             * have found another node (out of p and q), it means that the
             * current root node is the LCA.
             */
            boolean isAncestor = rx.node != null || ry.node != null ? true : false;
            return new Result(root, isAncestor);
        } else {
            return new Result(rx.node != null ? rx.node : ry.node, false);
        }
    }

    /**
     * In this method, it is assumed that both nodes are present in the tree.
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static Node getCommonAncestor(Node root, Node p, Node q) {

        if (root == null) {
            return null;
        }

        if (root.data == p.data || root.data == q.data) {
            return root;
        }

        Node left = getCommonAncestor(root.left, p, q);
        Node right = getCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        if (left == null && right == null) {
            return null;
        }

        return (left != null ? left : right);
    }

}

class Result {
    Node node;
    boolean isAncestor;

    public Result(Node node, boolean isAncestor) {
        this.node = node;
        this.isAncestor = isAncestor;
    }
}
