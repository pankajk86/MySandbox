package trees;

public class CheckUnivalTrees {

	public static void main(String[] args) {
		TreeNode root = createTree();
		boolean result = isUnivalTree(root);
		System.out.println(result);
	}

	private static boolean isUnivalTree(TreeNode root) {
		return isUnivalTree(root, root.val);
	}

	private static boolean isUnivalTree(TreeNode root, int val) {
		if(root == null) return true;
		boolean left = true, right = true;
		
		if(root.val != val) return false;
		
		if(root.left != null) left = isUnivalTree(root.left, val);
		if(root.right != null) right = isUnivalTree(root.right, val);
		return left && right;
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(1);
		
		n3.left = n4; n3.right = n5;
		n1.left = n3; n1.right = n2;
		return n1;
	}

}
