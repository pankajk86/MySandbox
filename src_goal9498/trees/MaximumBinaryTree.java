package trees;

public class MaximumBinaryTree {

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 6, 0, 5 };
		TreeNode root = constructMaximumBinaryTree(a);
		System.out.println(root.val);
	}

	private static TreeNode constructMaximumBinaryTree(int[] a) {

		TreeNode root = helper(a, 0, a.length - 1);
		return root;
	}

	private static TreeNode helper(int[] a, int start, int end) {

		if (start == end) {
			return new TreeNode(a[start]);
		}

		Max max = getMax(a, start, end);
		TreeNode root = new TreeNode(max.val);

		if (max.index > start) {
			root.left = helper(a, start, max.index - 1);
		}

		if (max.index < end) {
			root.right = helper(a, max.index + 1, end);
		}

		return root;
	}

	private static Max getMax(int[] a, int start, int end) {
		int val = Integer.MIN_VALUE;
		int index = -1;

		for (int i = start; i <= end; i++) {
			if (a[i] > val) {
				val = a[i];
				index = i;
			}
		}

		return new Max(val, index);
	}

}

class Max {
	int val;
	int index;

	Max(int val, int index) {
		this.val = val;
		this.index = index;
	}
}
