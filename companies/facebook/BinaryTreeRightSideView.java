package facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import trees.TreeNode;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<Integer> result = rightView(root);
		System.out.print(result);
	}

	private static List<Integer> rightView(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		dfs(root, result, 0);
		return result;
	}

	private static void dfs(TreeNode root, List<Integer> result, int depth) {
		if (root == null) return;
		if (depth == result.size()) result.add(root.val);

		dfs(root.right, result, depth + 1);
		dfs(root.left, result, depth + 1);
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n5.left = n6; n5.right = n7;
		n2.right = n5; n3.left = n4;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
