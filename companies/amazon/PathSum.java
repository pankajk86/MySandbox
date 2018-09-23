package amazon;

import java.util.Stack;

import trees.TreeNode;

public class PathSum {

	public static void main(String[] args) {
		TreeNode root = createTree();
		boolean result = hasPathSum(root, 22);
		System.out.println(result);
	}

	private static boolean hasPathSum(TreeNode root, int sum) {

		if(root == null) return false;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			
			if(curr.left == null && curr.right == null) {
				if(curr.val == sum)
					return true;
			}
			
			if(curr.left != null) {
				curr.left.val += curr.val;
				stack.push(curr.left);
			}
			
			if(curr.right != null) {
				curr.right.val += curr.val;
				stack.push(curr.right);
			}
		}
		
		return false;
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
		TreeNode n9 = new TreeNode(1);
		
		n4.left = n7; n4.right = n8;
		n6.right = n9;
		n2.left = n4;
		n3.left = n5; n3.right = n6;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
