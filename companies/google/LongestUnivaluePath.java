package google;

import java.util.List;

import trees.TreeNode;

public class LongestUnivaluePath {
	
	private static List<Integer> list = null;
	private static int length = 0;

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = getLongestPath(root);
		System.out.println(result);
		
		root = createTree2();
		result = getLongestPath(root);
		System.out.println(result);
	}

	private static int getLongestPath(TreeNode root) {
		length = 0;
		longestPath(root, -1);
		return length;
	}

	private static int longestPath(TreeNode root, int val) {

		if(root == null) return 0;
		
		int left = longestPath(root.left, root.val);
		int right = longestPath(root.right, root.val);
		int count = 0;
		
		length = Math.max(length, left  + right);
		
		if(root.val == val) count = 1 + Math.max(left, right);
		
		return count;
	}

	@SuppressWarnings("unused")
	private static void inorder(TreeNode root) {
		if(root == null) return;
		inorder(root.left);
		list.add(root.val);
		inorder(root.right);
	}
	
	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(-7);
		TreeNode n3 = new TreeNode(-3);
		TreeNode n4 = new TreeNode(-9);
		TreeNode n5 = new TreeNode(-3);
		TreeNode n6 = new TreeNode(-4);
		
		n5.left = n6;
		n3.left = n4; n3.right = n5;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(5);
		
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
