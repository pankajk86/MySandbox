package google;

public class InorderSuccessorInBSTII {

	private static Node[] tree;
	
	public static void main(String[] args) {
		tree = createTree2();
		Node node = tree[1];
		
		Node result = inorderSuccessor(node);
		System.out.println(result.val);
	}

	private static Node inorderSuccessor(Node node) {
		if(node == null) return null;
		
		if(node.right != null) {
			Node curr = node.right;
			while(curr.left != null) curr = curr.left;
			return curr;
		} else {
			if(node.parent == null) return null;
			else {
				if(node == node.parent.left)
					return node.parent;
				else {
					Node parent = node.parent;
					while(parent.parent != null && parent != parent.parent.left)
						parent = parent.parent;
					return parent.parent;
				}
			}
		}
	}
	
	private static Node[] createTree2() {
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n9 = new Node(9);
		Node n13 = new Node(13);
		Node n15 = new Node(15);
		Node n17 = new Node(17);
		Node n18 = new Node(18);
		Node n20 = new Node(20);
		
		n3.left = n2; n2.parent = n3; n3.right = n4; n4.parent = n3;
		n13.left = n9; n9.parent = n13; n7.right = n13; n13.parent = n7;
		n6.left = n3; n3.parent = n6; n6.right = n7; n7.parent = n6;
		
		n18.left = n17; n17.parent = n18; n18.right = n20; n20.parent = n18;
		n15.left = n6; n6.parent = n15; n15.right = n18; n18.parent = n15;
		
		return new Node[] {n15, n13};
	}

	@SuppressWarnings("unused")
	private static Node[] createTree() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		
		n2.left = n1; n1.parent = n2;
		n3.left = n2; n2.parent = n3; n3.right = n4; n4.parent = n3;
		n5.left = n3; n3.parent = n5; n5.right = n6; n6.parent = n5;
		return new Node[] {n5, n2};
	}

}

class Node {
	int val;
    Node left;
    Node right;
    Node parent;
    
    Node(int val) {
    	this.val = val;
    }
}
