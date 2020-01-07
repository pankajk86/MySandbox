package apple;

import trees.TreeNode;

public class BinarySearchTreeToGreaterSumTree {

	private static int pre = 0;
	
	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode result = bstToGst(root);
		System.out.println(result);
	}

	private static TreeNode bstToGst(TreeNode root) {
		if(root.right != null) bstToGst(root.right);
		pre = root.val = pre + root.val;
		if(root.left != null) bstToGst(root.left);
		return root;
	}

	private static TreeNode createTree() {
		TreeNode n0 = new TreeNode(0);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n2.right = n3;
		n1.left = n0; n1.right = n2;
		n7.right = n8;
		n6.left = n5; n6.right = n7;
		n4.left = n1; n4.right = n6;
		
		return n4;
	}

}
