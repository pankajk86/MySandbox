package linkedin;

import trees.TreeNode;

public class SidewaysTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode result = sideways(root);
		System.out.println(result);
	}

	private static TreeNode sideways(TreeNode root) {
		if(root == null || (root.left == null && root.right == null)) return root;
		TreeNode left = root.left, right = root.right;
		root.left = null; root.right = null; // to fix root cycle problem
		return helper(left, root, right);
	}

	private static TreeNode helper(TreeNode node, TreeNode root, TreeNode right) {
		TreeNode nodeLeft = node.left, nodeRight = node.right;
		node.left = right; node.right = root;
		if(nodeLeft == null) return node;
		return helper(nodeLeft, node, nodeRight);
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n4.left = n5; n4.right = n6;
		n2.left = n4; 
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
