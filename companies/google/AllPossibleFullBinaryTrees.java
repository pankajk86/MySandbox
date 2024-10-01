package google;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class AllPossibleFullBinaryTrees {

	public static void main(String[] args) {
		int n = 7;
		List<TreeNode> result = allPossibleFBT(n);
		System.out.println(result);
	}

	private static List<TreeNode> allPossibleFBT(int n) {
		if(n % 2 == 0) return new ArrayList<>();
		List<TreeNode> result = new ArrayList<>();
		
		if(n == 1) {
			result.add(new TreeNode(0));
			return result;
		}
		
		for(int i = 1; i < n; i+= 2) {
			List<TreeNode> leftSubTrees = allPossibleFBT(i);
			List<TreeNode> rightSubTrees = allPossibleFBT(n - 1 - i);
			
			for(TreeNode left: leftSubTrees) {
				for(TreeNode right: rightSubTrees) {
					TreeNode root = new TreeNode(0);
					root.left = left;
					root.right = right;
					
					result.add(root);
				}
			}
		}
		
		return result;
	}

}
