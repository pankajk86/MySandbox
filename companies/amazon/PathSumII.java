package amazon;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class PathSumII {

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<List<Integer>> result = pathSum(root, 22);
		System.out.println(result);
	}

	private static List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> result = new ArrayList<>();
		dfs(root, result, new ArrayList<>(), 0, sum);
		return result;
	}

	private static void dfs(TreeNode root, List<List<Integer>> result, List<Integer> path, int temp, int sum) {
		if(root == null) return;
		
		path.add(root.val);
		temp += root.val;
		
		if(root.left == null && root.right == null && temp == sum) {
			result.add(new ArrayList<>(path));
		}
		
		dfs(root.left, result, path, temp, sum);
		dfs(root.right, result, path, temp, sum);
		path.remove(path.size() - 1);
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(11);
		TreeNode n5 = new TreeNode(13);
		TreeNode n6 = new TreeNode(4);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(5);
		TreeNode n10 = new TreeNode(1);
		
		n4.left = n7; n4.right = n8;
		n6.left = n9; n6.right = n10;
		n2.left = n4;
		n3.left = n5; n3.right = n6;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
