package goal.phase.two.trees;

public class ArrayToBST {

    public static void main(String[] args) {

        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
        Node rootToBST = createBST(a, 0, a.length-1);

        System.out.println(rootToBST.data);
    }

    private static Node createBST(int[] a, int start, int end) {
        
        if (end < start) {
            return null;
        }

        int mid = (start + end)/2;
        
        Node node = new Node(a[mid]);
        node.left = createBST(a, start, mid - 1);
        node.right = createBST(a, mid + 1, end);
        
        return node;
    }

}

