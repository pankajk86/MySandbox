package goal.phase.two.trees;

public class BinarySearchTree {
    
    private static Node root = null;

    public BinarySearchTree(int data) {
        root = new Node(data);
    }
    
    public void add(int data) {
        
        Node head = root;
        Node parent = null;

        Node node = new Node(data);

        while (head != null) {
            parent = head;
            if (data < head.data) {
                head = head.left;
            } else {
                head = head.right;
            }
        }

        if (data < parent.data) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }
    
    public void print(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        print(root.left);
        print(root.right);
    }

    public Node getRoot() {
        return root;
    }

}

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
    }
}
