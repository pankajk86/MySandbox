package amazon;

import trees.TreeNode;

public class MergeTwoBinaryTrees {

	public static void main(String[] args) {
		TreeNode root1 = createTree1();
		TreeNode root2 = createTree2();
		TreeNode result = merge(root1, root2);
		System.out.println(result);
	}

	private static TreeNode merge(TreeNode r1, TreeNode r2) {
		if(r1 == null && r2 == null) return null;
		else if(r1 != null && r2 == null) return r1;
		else if(r1 == null && r2 != null) return r2;
		
		TreeNode root = new TreeNode(r1.val + r2.val);
		root.left = merge(r1.left, r2.left);
		root.right = merge(r1.right, r2.right);
		
		return root;
	}

	private static TreeNode createTree1() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(5);
		
		n2.left = n4;
		n1.left = n2; n1.right = n3;
		return n1;
	}
	
	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);
		
		n1.right = n4;
		n3.right = n5;
		n2.left = n1; n2.right = n3;
		return n2;
	}



}
