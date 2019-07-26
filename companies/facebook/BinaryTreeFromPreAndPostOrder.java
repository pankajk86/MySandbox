package facebook;

import trees.TreeNode;

public class BinaryTreeFromPreAndPostOrder {

	public static void main(String[] args) {
		int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
		int[] post = { 4, 5, 2, 6, 7, 3, 1 };
		
		TreeNode result = createBT(pre, post);
		System.out.println(result);
	}

	private static TreeNode createBT(int[] pre, int[] post) {
		return createBT(pre, 0, pre.length - 1, post, 0, post.length - 1);
	}

	private static TreeNode createBT(int[] pre, int preStart, int preEnd, int[] post, int postStart, int postEnd) {
		if(preStart > preEnd) return null;
		
		TreeNode root = new TreeNode(pre[preStart]);
		if(preStart == preEnd) return root;
		
		int preStartForLeftSubTree = preStart + 1;
		int postStartForLeftSubTree = getIndex(post, postStart, postEnd, pre[preStartForLeftSubTree]);
		int preEndForLeftSubTree = preStartForLeftSubTree + (postStartForLeftSubTree - postStart);
		
		TreeNode left = createBT(pre, preStartForLeftSubTree, preEndForLeftSubTree, 
								post, postStart, postStartForLeftSubTree);
		
		TreeNode right = createBT(pre, preEndForLeftSubTree + 1, preEnd, 
								post, postStartForLeftSubTree + 1, postEnd - 1);
		
		root.left = left; root.right = right;
		return root;
	}

	private static int getIndex(int[] a, int start, int end, int target) {
		for(int i = start; i <= end; i++) {
			if(a[i] == target) return i;
		}
		return -1;
	}

}
