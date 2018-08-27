package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import trees.TreeNode;

public class FindDuplicateSubtrees {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<TreeNode> result = duplicateSubtrees(root);
		
		for(TreeNode node: result) System.out.print(node.val + " ");
	}

	private static List<TreeNode> duplicateSubtrees(TreeNode root) {
		List<TreeNode> result = new ArrayList<>();
		postOrder(root, new HashMap<>(), result);
		return result;
	}

	private static String postOrder(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {

		if(root == null) return "#";
		
		StringBuilder sb = new StringBuilder();
		sb.append(root.val + ", ");
		sb.append(postOrder(root.left, map, result) + ", ");
		sb.append(postOrder(root.right, map, result));
		
		String serial = sb.toString();
		
		if(map.getOrDefault(serial, 0) == 1)
			result.add(root);
		
		map.put(serial, map.getOrDefault(serial, 0) + 1);
		return serial;
		
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(4);

		n5.left = n6;
		n3.left = n5; n3.right = n7;
		n2.left = n4;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
