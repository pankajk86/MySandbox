package goal.phase.two.trees;

public class BSTTest {

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree(4);
        bst.add(2);
        bst.add(6);
        bst.add(1);
        bst.add(3);
        bst.add(5);
        bst.add(7);

        bst.print(bst.getRoot());
    }

}
