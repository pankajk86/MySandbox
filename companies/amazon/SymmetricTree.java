package amazon;

import trees.TreeNode;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		boolean result = isSymmetric(root);
		System.out.println(result);
	}

	private static boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		return isSymmetric(root.left, root.right);
	}

	private static boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == right) return true;
		if(left == null || right == null || left.val != right.val) return false;
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(3);
		
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
