package facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import trees.TreeNode;

public class ValidateBST {

	public static void main(String[] args) {
		TreeNode root = createTree();
		boolean result = isValidBST(root);
		System.out.println(result);
		
		result = isValidBSTRecur(root);
		System.out.println(result);
	}

	private static boolean isValidBSTRecur(TreeNode root) {
		if(root == null) return true;
		return validate(root, null, null);
	}
	
	private static boolean validate(TreeNode root, Integer min, Integer max) {
		if(root == null) return true;
		if(min != null && root.val <= min) return false;
		if(max != null && root.val >= max) return false;
		return validate(root.left, min, root.val) && validate(root.right, root.val, max);
	}

	/*
	 * Using the logic that in-order traversal creates a sorted array of elements (here, integers)
	 */
	private static boolean isValidBST(TreeNode root) {
		
		if(root == null) return true;
		
		List<TreeNode> list = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = root;
		int i = 0;
		
		while(!stack.isEmpty() || current != null) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			} else {
				TreeNode node = stack.pop();
				list.add(node);
				if(i > 0 && list.get(i).val <= list.get(i - 1).val)
					return false;
				i++;
				current = node.right;
			}
		}

		return true;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n2.left = n1; n2.right = n3;
		n6.left = n5; n6.right = n7;
		n4.left = n2; n4.right = n6;
		
		return n4;
	}

}
