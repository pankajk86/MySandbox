package facebook;

public class PopulateNextPointerInBinaryTree {

	public static void main(String[] args) {
		TreeLinkNode root = createTree();
		connect(root);
	}

	private static TreeLinkNode connect(TreeLinkNode root) {
		TreeLinkNode currRoot = root;
		while(currRoot != null && currRoot.left != null) {
			for(TreeLinkNode curr = currRoot; curr != null; curr = curr.next) {
				curr.left.next = curr.right;
				curr.right.next = curr.next == null ? null : curr.next.left;
			}
			currRoot = currRoot.left;
		}
		return root;
	}

	private static TreeLinkNode createTree() {
		
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(7);
		
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}


class TreeLinkNode {
	TreeLinkNode right, left, next;
	int val;
	
	TreeLinkNode(int val) {
		this.val = val;
	}
}