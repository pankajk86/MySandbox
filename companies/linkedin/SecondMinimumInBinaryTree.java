package linkedin;

import java.util.Stack;

import trees.TreeNode;

public class SecondMinimumInBinaryTree {

	private static int min;
	private static long result;

	public static void main(String[] args) {
		TreeNode root = createTree();
		
		int result = secondMinimum(root);
		System.out.println(result);
	}

	private static int secondMinimum(TreeNode root) {
		min = root.val;
		result = Long.MAX_VALUE;

		dfs(root);

		return result < Long.MAX_VALUE ? (int) result : -1;
	}

	private static void dfs(TreeNode node) {
		if (node != null) {
			if (min < node.val && node.val < result) {
				result = node.val;
			} else {
				dfs (node.left);
				dfs (node.right);
			}
		}
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(7);
		
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(4);
		TreeNode n9 = new TreeNode(2);
		TreeNode n10 = new TreeNode(3);
		
//		n3.left = n4; n3.right = n5;
//		n1.left = n2; n1.right = n3;
		
//		n1.left = n2; n1.right = n6;
		
//		n7.left = n8; n7.right = n9;
//		n2.left = n10; n2.right = n6;
//		n1.left = n7; n1.right = n2;
		
		n1.left = n2; n1.right = n6;
		
		return n1;
	}

}
