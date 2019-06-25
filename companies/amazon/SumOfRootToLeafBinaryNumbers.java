package amazon;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class SumOfRootToLeafBinaryNumbers {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = sumRootToLeaf(root);
		System.out.println(result);
	}

	private static int sumRootToLeaf(TreeNode root) {
		List<String> list = new ArrayList<>();
		dfs(root, "", list);
		int result = 0;
		
		for(String s: list)
			result += Integer.parseInt(s, 2);
		
		return result;
	}

	private static void dfs(TreeNode root, String s, List<String> list) {
		if(root != null && root.left == null && root.right == null) {
			list.add(s + root.val);
			return;
		}
		
		if(root.left != null) dfs(root.left, s + root.val, list);
		if(root.right != null) dfs(root.right, s + root.val, list);
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(0);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(0);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(0);
		TreeNode n7 = new TreeNode(1);
		
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		n1.left = n2; n1.right = n3;
		return n1;
	}

}
