package microsoft;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class UniqueBinarySearchTreesII {

	public static void main(String[] args) {
		int n = 3;
		List<TreeNode> result = generateTrees(n);
		System.out.println(result);
	}

	private static List<TreeNode> generateTrees(int n) {
		if(n == 0) return new ArrayList<>();
		List<TreeNode> result = dfs(1, n); 
		return result;
	}

	private static List<TreeNode> dfs(int low, int high) {
		List<TreeNode> result = new ArrayList<>();
		if(low > high) {
			result.add(null); return result;
		}
		
		for(int i = low; i <= high; i++) {
			for(TreeNode left: dfs(low, i - 1)) {
				for(TreeNode right: dfs(i + 1, high)) {
					TreeNode root = new TreeNode(i);
					root.left = left; root.right = right;
					result.add(root);
				}
			}
		}
		return result;
	}

}
