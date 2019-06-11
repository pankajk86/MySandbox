package facebook;

import trees.TreeNode;

public class ConstructBSTFromPreorder {

	public static void main(String[] args) {
		int[] a = {4, 2};//{ 8, 5, 1, 7, 10, 12 };
		TreeNode result = createTree(a);
		System.out.println(result);
	}

	private static TreeNode createTree(int[] a) {
		return createTree(a, 0, a.length - 1);
	}

	private static TreeNode createTree(int[] a, int start, int end) {
		if(start > end) return null;
		TreeNode root = new TreeNode(a[start]);
		if(start == end) return root;
		
		int mid = start + 1;
		while(mid < a.length && a[mid] < a[start]) mid++;
		
		root.left = createTree(a, start + 1, mid - 1);
		root.right = createTree(a, mid, end);
		return root;
	}

}
