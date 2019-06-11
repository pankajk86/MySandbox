package google;

import trees.TreeNode;

public class DistributeCoinsInBinaryTree {

	private static int moves = 0;
	
	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = calculateMoves(root);
		System.out.println(result);
	}

	private static int calculateMoves(TreeNode root) {
		dfs(root);
		return moves;
	}

	//returns an array: [# of nodes in subtree, # of coins in the subtree]
	private static int[] dfs(TreeNode root) {
		if(root == null) return new int[] {0, 0};
		
		int[] left = dfs(root.left);
		int[] right = dfs(root.right);
		moves += Math.abs(left[0] - left[1]) + Math.abs(right[0] - right[1]);
		return new int[] {left[0] + right[0] + 1, left[1] + right[1] + root.val};
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		
		n1.right = n2;
		n3.left = n1; n3.right = n4;
		return n3;
	}

}
