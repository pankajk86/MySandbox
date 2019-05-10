package amazon;

import trees.TreeNode;

public class SubtreeOfAnotherTree {

	public static void main(String[] args) {
		TreeNode s = createTree1();
		TreeNode t = createTree2();
		
		boolean result = isSubTree(s, t);
		System.out.println(result);
	}

	private static boolean isSubTree(TreeNode s, TreeNode t) {
		if(s == null) return false;
		if(isSame(s, t)) return true;
		return isSubTree(s.left, t) || isSubTree(s.right, t);
	}

	private static boolean isSame(TreeNode s, TreeNode t) {
		if(s == null && t == null) return true;
		if(s == null || t == null) return false;
		if(s.val != t.val) return false;
		
		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}

	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n4 = new TreeNode(4);
		
		n4.left = n1; n4.right = n2;
		return n4;
	}

	private static TreeNode createTree1() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n4.left = n1; n4.right = n2;
		n3.left = n4; n3.right = n5;
		return n3;
	}

}
