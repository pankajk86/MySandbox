package goal.phase.two.trees;

public class ArrayToBST {

    public static void main(String[] args) {

        int a[] = { 1, 2, 3, 4, 5, 6, 7 };
        Node rootToBST = createBST(a, 0, a.length-1);
    }

    private static Node createBST(int[] a, int start, int end) {
        
        int mid = (start + end)/2;
        
        Node node = new Node(a[mid]);
        
        return null;
    }

}

