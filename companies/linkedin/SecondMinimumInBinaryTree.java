package linkedin;

import java.util.Stack;

import trees.TreeNode;

public class SecondMinimumInBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		
		int result = secondMinimum(root);
		System.out.println(result);
	}

	private static int secondMinimum(TreeNode root) {
		if(root == null) return -1;
		
		int min = Integer.MAX_VALUE, secMin = min;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while(!stack.isEmpty() || curr != null) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				TreeNode node = stack.pop();
				
				if(node.val < min) {
					secMin = min;
					min = node.val;
				} else if(node.val > min && node.val < secMin) {
					secMin = node.val;
				}
				
				curr = node.right;
			}
		}
		
		return secMin == Integer.MAX_VALUE ? -1 : secMin;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(5);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(7);
		
		TreeNode n6 = new TreeNode(2);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(4);
		TreeNode n9 = new TreeNode(2);
		TreeNode n10 = new TreeNode(3);
		
//		n3.left = n4; n3.right = n5;
//		n1.left = n2; n1.right = n3;
		
//		n1.left = n2; n1.right = n6;
		
//		n7.left = n8; n7.right = n9;
//		n2.left = n10; n2.right = n6;
//		n1.left = n7; n1.right = n2;
		
		n1.left = n2; n1.right = n6;
		
		return n1;
	}

}
