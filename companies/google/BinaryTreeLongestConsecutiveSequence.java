package google;

import trees.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
	
	private static int length = 0;

	public static void main(String[] args) {
		TreeNode root = createTree2();
		int result = getLongestConsecutive(root);
		System.out.println(result);
	}

	private static int getLongestConsecutive(TreeNode root) {
		inorder(root, root.val, 1);
		return length;
	}

	private static void inorder(TreeNode root, int parentVal, int count) {
		if(root == null) return;
		
		inorder(root.left, root.val, (root.val == parentVal + 1) ? count + 1 : 1);
		length = Math.max(length, (root.val == parentVal + 1) ? count + 1 : 1);
		inorder(root.right, root.val, (root.val == parentVal + 1) ? count + 1 : 1);
	}

	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(5);
		TreeNode n7 = new TreeNode(4);
		TreeNode n8 = new TreeNode(4);
		TreeNode n9 = new TreeNode(5);
		
		n7.right = n9;
		n5.left = n7; n5.right = n8;
		n3.right = n5;
		n4.right = n6;
		n2.left = n3; n2.right = n4;
		n1.right = n2;
		
		return n1;
	}
}
