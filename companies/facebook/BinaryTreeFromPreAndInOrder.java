package facebook;

import trees.TreeNode;

public class BinaryTreeFromPreAndInOrder {

	private static int preIndex = 0;
	
	public static void main(String[] args) {
		int[] pre = {1, 2};//{ 3, 9, 20, 15, 7 };
		int[] in = {2, 1};//{ 9, 3, 15, 20, 7 };
		
		TreeNode result = createTree(pre, in);
		System.out.println(result.val);
	}

	private static TreeNode createTree(int[] pre, int[] in) {
		TreeNode result = buildTree(pre, in, 0, pre.length - 1); 
		return result;
	}

	private static TreeNode buildTree(int[] pre, int[] in, int start, int end) {

		if(start > end) return null;
		TreeNode node = new TreeNode(pre[preIndex++]);
		if(start == end) return node;
		
		int index = search(in, start, end, node.val);
		node.left = buildTree(pre, in, start, index - 1);
		node.right = buildTree(pre, in, index + 1, end);
		return node;
	}

	private static int search(int[] in, int start, int end, int val) {
		for(int i = start; i <= end; i++) {
			if(in[i] == val) return i;
		}
		
		return 0;
	}

}
