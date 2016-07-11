package goal.phase.two.trees;

public class CreateTreeFromInorderPostorder {

    public static void main(String[] args) {

        String inorder = "dbheiafcg";
        String postorder = "dhiebfgca";

        Node root = createBinaryTree(inorder, postorder);
        printPreorder(root);
    }

    private static void printPreorder(Node root) {
        if (root != null) {
            System.out.print(root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    private static Node createBinaryTree(String inorder, String postorder) {

        char data = postorder.charAt(postorder.length() - 1);
        Node root = new Node(data);

        if (inorder.equals(postorder)) {
            return root;
        }

        String[] inorderPart = inorder.split(String.valueOf(data));
        int leftLength = inorderPart[0].length();
        int rightLength = inorderPart[1].length();

        String leftPostorder = postorder.substring(0, leftLength);
        String rightPostorder = postorder.substring(leftLength, leftLength + rightLength);

        root.left = createBinaryTree(inorderPart[0], leftPostorder);
        root.right = createBinaryTree(inorderPart[1], rightPostorder);

        return root;
    }

    private static class Node {
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }

}
