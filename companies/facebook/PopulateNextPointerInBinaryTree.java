package facebook;

public class PopulateNextPointerInBinaryTree {

	public static void main(String[] args) {
		TreeLinkNode root = createTree();
		connect(root);
		System.out.println("Connected");
	}

	private static void connect(TreeLinkNode root) {
		for(TreeLinkNode head = root; head != null; ) {
			TreeLinkNode nextHead = new TreeLinkNode(0), nextTail = nextHead;
			for(TreeLinkNode node = head; node != null; node = node.next) {
				if(node.left != null) {
					nextTail.next = node.left;
					nextTail = nextTail.next;
				}
				
				if(node.right != null) {
					nextTail.next = node.right;
					nextTail = nextTail.next;
				}
			}
			head = nextHead.next;
		}
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