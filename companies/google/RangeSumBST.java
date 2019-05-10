package google;

import trees.TreeNode;

public class RangeSumBST {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = rangeSum(root, 7, 15);
		System.out.println(result);
		
		root = createTree2();
		result = rangeSum(root, 7, 10);
		System.out.println(result);
	}

	private static int rangeSum(TreeNode root, int l, int r) {
		if(root == null) return 0;
		if(root.val < l) return rangeSum(root.right, l, r);
		if(root.val > r) return rangeSum(root.left, l, r);
		return root.val + rangeSum(root.left, l, r) + rangeSum(root.right, l, r);
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(7);
		TreeNode n4 = new TreeNode(8);
		TreeNode n5 = new TreeNode(9);
		TreeNode n6 = new TreeNode(15);
		TreeNode n7 = new TreeNode(18);
		TreeNode n8 = new TreeNode(10);
		
		n5.left = n4;
		n3.right = n5;
		n2.left = n1; n2.right = n3;
		n6.right = n7;
		n8.left = n2; n8.right = n6;
		
		return n8;
	}
	
	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(13);
		TreeNode n7 = new TreeNode(18);
		TreeNode n8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(6);
		
		n4.left = n8; n5.left = n9;
		n3.left = n6; n3.right = n7;
		n2.left = n4; n2.right = n5;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
