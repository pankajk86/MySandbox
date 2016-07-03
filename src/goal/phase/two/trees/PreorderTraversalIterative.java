package goal.phase.two.trees;

import java.util.Stack;

public class PreorderTraversalIterative {

    public static void main(String[] args) {
        Node root = getBST();

        Stack<Node> stack = new Stack<Node>();
        stack.add(root);

        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.print(node.data + " ");

            if (node.right != null) {
                stack.add(node.right);
            }

            if (node.left != null) {
                stack.add(node.left);
            }
        }
    }

    private static Node getBST() {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n3.right = n4;

        n2.left = n1;
        n2.right = n3;

        n7.left = n6;
        n7.right = n8;

        n5.left = n2;
        n5.right = n7;

        return n5;
    }

    static class Node {
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

}
