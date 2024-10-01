package trees;

public class BinaryTreeMaxPathSum {

	private static int result = Integer.MIN_VALUE;

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = maxPathSum(root);
		System.out.println(result);
		
		root = createTree2();
		result = maxPathSum(root);
		System.out.println(result);
	}

	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(-1);
		TreeNode n2 = new TreeNode(2);
		n2.left = n1;
		return n2;
	}

	private static int maxPathSum(TreeNode root) {
		dfs(root);
		return result;
	}

	private static int dfs(TreeNode root) {
		if(root == null) return 0;
		
		int left = dfs(root.left);
		int right = dfs(root.right);
		
		int current = Math.max(root.val, Math.max(left + root.val, right + root.val));
		result = Math.max(current, Math.max(result, left + root.val + right));
		
		return current;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(-10);
		TreeNode n2 = new TreeNode(9);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(15);
		TreeNode n5 = new TreeNode(7);
		
		n3.left = n4; n3.right = n5;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}
}
