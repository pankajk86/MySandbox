package google;

import trees.TreeNode;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = longestConsecutive(root);
		System.out.println(result);
	}

	private static int longestConsecutive(TreeNode root) {
		
		if(root == null)
			return 0;
		
		int result = helper(root, 1);
		return result;
	}

	private static int helper(TreeNode root, int count) {
		
		if(root.left == null && root.right == null)
			return count;
		
		int leftVal = -1, rightVal = -1;
		
		if(root.left != null) {
			if(root.left.val == root.val + 1) {
				leftVal = helper(root.left, count + 1);
			} else {
				leftVal = helper(root.left, count);
			}
		}
		
		if(root.right != null) {
			if(root.right.val == root.val + 1) {
				rightVal = helper(root.right, count + 1);
			} else {
				rightVal = helper(root.right, count);
			}
		}
		
		return Math.max(leftVal, rightVal);
	}

	private static TreeNode createTree() {

		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		node6.right = node7;
		node5.right = node6;
		node4.left = node5;
		node3.left = node2; node3.right = node4;
		node1.right = node3;
		
		return node1;
	}

}
