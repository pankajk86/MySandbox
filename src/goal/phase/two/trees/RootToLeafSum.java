package goal.phase.two.trees;

public class RootToLeafSum {

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

        int rootToLeafSum = getRootToLeafSum(node4);
        System.out.println("Result: " + rootToLeafSum);
    }

    private static int getRootToLeafSum(Node root) {
        return dfs(root, 0, 0);
    }

    private static int dfs(Node root, int num, int sum) {

        if (root == null) {
            return sum;
        }

        num = num * 10 + root.data;

        if (root.left == null && root.right == null) {
            sum += num;
            return sum;
        }

        return dfs(root.left, num, sum) + dfs(root.right, num, sum);
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
