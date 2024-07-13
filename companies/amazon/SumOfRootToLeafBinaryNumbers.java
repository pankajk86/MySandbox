package amazon;

import trees.TreeNode;

public class SumOfRootToLeafBinaryNumbers {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = sumRootToLeaf(root);
		System.out.println(result);
	}

	private static int sumRootToLeaf(TreeNode root) {
		return dfs(root, 0);
	}

	private static int dfs(TreeNode root, int sum) {
		int curr = sum * 10 + root.val, result = 0;
		if (root.left == null && root.right == null) return curr;
		if (root.left != null) result += dfs(root.left, curr);
		if (root.right != null) result += dfs(root.right, curr);
		return result;
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(0);
		TreeNode n7 = new TreeNode(1);
		
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		n1.left = n2; n1.right = n3;
		return n1;
	}

}
