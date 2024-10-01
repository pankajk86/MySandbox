package amazon;

import trees.TreeNode;

public class LargestBSTSubtree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = largestBSTSubtree(root);
		System.out.println(result);
	}

	private static int largestBSTSubtree(TreeNode root) {
		int[] result = largestBST(root);
		return result[2];
	}

	private static int[] largestBST(TreeNode root) {
		if(root == null) return new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
		
		int[] left = largestBST(root.left);
		int[] right = largestBST(root.right);
		
		if(root.val > left[1] && root.val < right[0])
			return new int[] {
					Math.min(left[0], root.val),
					Math.max(root.val, right[1]),
					left[2] + right[2] + 1
			};
		else return new int[] {
				Integer.MIN_VALUE,
				Integer.MAX_VALUE,
				Math.max(left[2], right[2])
			};
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(15);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(8);
		TreeNode n6 = new TreeNode(7);
		
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
