package trees;

public class DeepestSubtree {

	public static void main(String[] args) {
		TreeNode root = createTree();
//		root = new TreeNode(1);
		TreeNode result = getDeepestSubtree(root);
		System.out.println(result.val);
	}

	private static TreeNode getDeepestSubtree(TreeNode root) {

		DeepNode droot = createDeepTree(root, 0);
		TreeNode result = getDeepestTree(droot);
		return result;
	}

	private static TreeNode getDeepestTree(DeepNode droot) {
		int depth = droot.depth;
		
		if(droot.left == null && droot.right == null) {
			return droot.tnode;
		}
		
		while(droot != null) {
			if(droot.left != null && droot.right != null) {
				if(droot.left.depth == depth && droot.right.depth == depth) {
					break;
				}else if(droot.left.depth == depth) {
					droot = droot.left;
				} else {
					droot = droot.right;
				}
			} else if(droot.left == null && droot.right == null) {
				break;
			} else {
				if(droot.left != null) {
					droot = droot.left;
				} else if(droot.right != null) {
					droot = droot.right;
				}
			}
		}
		
		return droot.tnode;
	}

	private static DeepNode createDeepTree(TreeNode root, int depth) {
		
		if(root.left == null && root.right == null) {
			return new DeepNode(root, depth);
		}

		DeepNode dleft = null, dright = null;
		
		if(root.left != null)
			dleft = createDeepTree(root.left, depth + 1);
		if(root.right != null)
			dright = createDeepTree(root.right, depth + 1);
		
		int leftDepth = dleft != null ? dleft.depth : 0;
		int rightDepth = dright != null ? dright.depth : 0;
		int subMax = Math.max(leftDepth, rightDepth);
		
		DeepNode droot = new DeepNode(root, subMax);
		droot.left = dleft;
		droot.right = dright;
		return droot;
	}

	private static TreeNode createTree() {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		
		node9.left = node11;
		node9.right = node12;
		
		node5.left = node9;
		node5.right = node10;
		
		node4.left = node8;
		
		node2.left = node4;
		node2.right = node5;
		
		node3.left = node6;
		node3.right = node7;
		
		node1.left = node2;
		node1.right = node3;
		
		return node1;
	}

}

class DeepNode {
	DeepNode left;
	DeepNode right;
	TreeNode tnode;
	int depth;
	
	DeepNode(TreeNode tnode, int depth) {
		this.tnode = tnode;
		this.depth = depth;
	}
}
