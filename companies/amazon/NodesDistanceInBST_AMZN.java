package amazon;

import trees.TreeNode;

public class NodesDistanceInBST_AMZN {
	public static void main(String args[]) {
		int[] a = { 5, 6, 3, 1, 2, 4 };

		TreeNode root = createTree(a);
		
		int distance = findDistance(root, 2, 4);
		System.out.println(distance);
	}

	private static TreeNode createTree(int[] a) {
		TreeNode root = null;
		for (int i = 0; i < a.length; i++) {
			root = insert(root, a[i]);
		}
		return root;
	}

	private static TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			root = new TreeNode(val);
			return root;
		}
		if (root.val < val)
			root.right = insert(root.right, val);
		else
			root.left = insert(root.left, val);

		return root;
	}

	public static int findDistance(TreeNode root, int n1, int n2) {
		int x = pathlength(root, n1) - 1;
		int y = pathlength(root, n2) - 1;
		int lcaData = findLCA(root, n1, n2).val;
		int lcaDistance = pathlength(root, lcaData) - 1;
		return (x + y) - 2 * lcaDistance;
	}

	public static int pathlength(TreeNode root, int n1) {
		if (root != null) {
			int x = 0;
			if ((root.val == n1) || (x = pathlength(root.left, n1)) > 0 || (x = pathlength(root.right, n1)) > 0) {
				return x + 1;
			}
			return 0;
		}
		return 0;
	}

	public static TreeNode findLCA(TreeNode root, int n1, int n2) {
		if (root != null) {
			if (root.val == n1 || root.val == n2) {
				return root;
			}
			TreeNode left = findLCA(root.left, n1, n2);
			TreeNode right = findLCA(root.right, n1, n2);
			if (left != null && right != null) {
				return root;
			}
			if (left != null) {
				return left;
			}
			if (right != null) {
				return right;
			}
		}
		return null;
	}
}
