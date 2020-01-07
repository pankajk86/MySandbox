package facebook;

import java.util.HashMap;
import java.util.Map;

import trees.TreeNode;

public class BinaryTreeFromPreAndInOrder {

	private static int preIndex = 0;
	private static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		int[] pre = {1, 2};//{ 3, 9, 20, 15, 7 };
		int[] in = {2, 1};//{ 9, 3, 15, 20, 7 };
		
		TreeNode result = createTree(pre, in);
		System.out.println(result.val);
	}

	private static TreeNode createTree(int[] pre, int[] in) {
		for(int i = 0; i < in.length; i++) map.put(in[i], i);
		TreeNode result = buildTree(pre, in, 0, pre.length - 1); 
		return result;
	}

	private static TreeNode buildTree(int[] pre, int[] in, int start, int end) {
		if(start > end) return null;
		TreeNode root = new TreeNode(pre[preIndex++]);
		if(start == end) return root;
		
		root.left = buildTree(pre, in, start, map.get(root.val) - 1);
		root.right = buildTree(pre, in, map.get(root.val) + 1, end);
		return root;
	}
}
