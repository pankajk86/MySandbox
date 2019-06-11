package google;

import trees.TreeNode;

public class FlipEquivalentBinaryTrees {

	public static void main(String[] args) {
		TreeNode root1 = createTree1();
		TreeNode root2 = createTree2();
		
		boolean result = flipEquiv(root1, root2);
		System.out.println(result);
	}

	private static boolean flipEquiv(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null)  return root1 == root2;
		if(root1.val != root2.val) return false;
		
		return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)
			|| flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
	}

	private static TreeNode createTree1() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n5.left = n7; n5.right = n8;
		n2.left = n4; n2.right = n5;
		n3.left = n6;
		n1.left = n2; n1.right = n3;
		return n1;
	}

	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n5.left = n8; n5.right = n7;
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		n1.left = n3; n1.right = n2;
		return n1;
	}

}
