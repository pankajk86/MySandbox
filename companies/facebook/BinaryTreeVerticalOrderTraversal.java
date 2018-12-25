package facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import trees.TreeNode;

public class BinaryTreeVerticalOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<List<Integer>> result = verticalTraversal(root);
		System.out.println(result);
	}

	private static List<List<Integer>> verticalTraversal(TreeNode root) {
		TreeMap<Integer, List<Integer>> map = new TreeMap<>();
		helper(root, 0, map);
		
		List<List<Integer>> result = new ArrayList<>();
		result.addAll(map.values());
		return result;
	}

	private static void helper(TreeNode node, int level, Map<Integer, List<Integer>> map) {
		if(node == null) return;
		
		List<Integer> list = map.getOrDefault(level, new ArrayList<>());
		list.add(node.val);
		map.put(level, list);
		
		if(node.left != null)
			helper(node.left, level - 1, map);
		
		if(node.right != null)
			helper(node.right, level + 1, map);
		
		return;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(8);
		TreeNode n7 = new TreeNode(9);
		
		n7.left = n4; n7.right = n1;
		n6.left = n2; n6.right = n5;
		n3.left = n7; n3.right = n6;
		
		return n3;
	}

}
