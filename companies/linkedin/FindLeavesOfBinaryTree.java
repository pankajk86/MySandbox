package linkedin;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class FindLeavesOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<List<Integer>> result = findLeaves(root);
		System.out.println(result);
	}

	private static List<List<Integer>> findLeaves(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		getHeight(result, root);
		return result;
	}

	private static int getHeight(List<List<Integer>> result, TreeNode root) {
		if(root == null) return -1;
		
		int leftHeight = getHeight(result, root.left);
		int rightHeight = getHeight(result, root.right);
		int level = 1 + Math.max(leftHeight, rightHeight);
		
		if(result.size() < level + 1) 
			result.add(new ArrayList<>());
		
		result.get(level).add(root.val);
		return level;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n2.left = n4; n2.right = n5;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
