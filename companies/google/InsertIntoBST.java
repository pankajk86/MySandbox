package google;

import trees.TreeNode;

public class InsertIntoBST {

	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode result = insert(root, 9);
		System.out.println(result);
	}

	private static TreeNode insert(TreeNode root, int val) {
		TreeNode parent = find(root, val);
		if(parent.val <= val)
			parent.right = new TreeNode(val);
		else parent.left = new TreeNode(val);
		
		return root;
	}

	private static TreeNode find(TreeNode root, int val) {
		if(val >= root.val) {
			if(root.right != null) {
				return find(root.right, val);
			} else return root;
		} else {
			if(root.left != null) {
				return find(root.left, val);
			} else return root;
		}
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(8);
		TreeNode n8 = new TreeNode(10);
		TreeNode n9 = new TreeNode(11);
		TreeNode n10 = new TreeNode(13);
		TreeNode n11 = new TreeNode(14);
		TreeNode n12 = new TreeNode(15);
		
		n7.right = n8;
		n9.left = n7; n9.right = n10;
		n11.left = n9; n11.right = n12;
		n6.left = n5; n6.right = n11;
		n2.left = n1; n2.right = n3;
		n4.left = n2; n4.right = n6;
		
		return n4;
	}

}
