package goal.phase.two.trees;

public class MirrorBinaryTree {

    public static void main(String[] args) {

        test1();
        test2();
    }

    private static void test1() {

        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');
        Node g = new Node('g');

        b.left = d;
        b.right = e;

        c.left = f;
        c.right = g;

        a.left = b;
        a.right = c;

        System.out.print("Prefix of original tree: ");
        printPrefix(a);

        Node mirror = getMirrorTree(a);

        System.out.print("\nPrefix of mirror tree: ");
        printPrefix(mirror);
    }

    private static void test2() {

        Node a = new Node('a');
        Node b = new Node('b');
        Node c = new Node('c');
        Node d = new Node('d');
        Node e = new Node('e');
        Node f = new Node('f');

        b.left = d;
        b.right = e;

        c.left = f;

        a.left = b;
        a.right = c;

        System.out.print("\nPrefix of original tree: ");
        printPrefix(a);

        Node mirror = getMirrorTree(a);

        System.out.print("\nPrefix of mirror tree: ");
        printPrefix(mirror);
    }

    private static void printPrefix(Node node) {

        if (node == null) {
            return;
        }
        System.out.print(node.data);
        printPrefix(node.left);
        printPrefix(node.right);
    }

    /**
     * This method mirrors the given binary tree rooted at "root".
     * 
     * @param root
     * @return
     */
    private static Node getMirrorTree(Node root) {

        if (root == null) {
            return root;
        }

        Node newRoot = new Node(root.data);
        newRoot.left = getMirrorTree(root.right);
        newRoot.right = getMirrorTree(root.left);

        return newRoot;
    }

    private static class Node {
        char data;
        Node left;
        Node right;

        public Node(char c) {
            this.data = c;
        }
    }

}
