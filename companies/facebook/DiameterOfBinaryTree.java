package facebook;

import trees.TreeNode;

public class DiameterOfBinaryTree {
	
	private static int max = 0;

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = diameterOfBinaryTree(root);
		System.out.println(result);
	}

	private static int diameterOfBinaryTree(TreeNode root) {
		maxDepth(root);
		return max;
	}

	private static int maxDepth(TreeNode root) {
		if(root == null) return 0;
		
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		
		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n2.left = n4; n2.right = n5;
		n1.left = n2; n1.right = n3;
		return n1;
	}
	
	

}
