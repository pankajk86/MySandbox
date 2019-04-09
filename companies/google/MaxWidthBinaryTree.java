package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trees.TreeNode;

public class MaxWidthBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree3();
		int result = widthOfBinaryTree(root);
		System.out.println(result);
	}

	private static int widthOfBinaryTree(TreeNode root) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		inorder(root, 0, 1, map);
		int result = 0;
		for(List<Integer> list: map.values()) {
			int size = list.get(list.size() - 1) - list.get(0) + 1;
			result = Math.max(result, size);
		}
		return result;
	}

	private static void inorder(TreeNode root, int level, int index, Map<Integer, List<Integer>> map) {
		if(root == null) return;
		
		inorder(root.left, level + 1, 2 * index - 1, map);
		List<Integer> list = map.getOrDefault(level, new ArrayList<>());
		list.add(index);
		map.put(level, list);
		inorder(root.right, level + 1, 2 * index, map);
	}

	private static TreeNode createTree3() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		TreeNode n12 = new TreeNode(12);
		
		n10.left = n11; n10.right = n12;
		n8.right = n10;
		n6.left = n8; n6.right = n9;
		n4.left = n7;
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}
}
