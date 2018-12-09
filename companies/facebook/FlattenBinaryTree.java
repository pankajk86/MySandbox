package facebook;

import java.util.Stack;

import trees.TreeNode;

public class FlattenBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		flatten(root);
		
		while(root != null) {
			System.out.print(root.val + " ");
			root = root.right;
		}
	}

	private static void flatten(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = root;
		
		while(curr != null) {
			if(curr.right != null)
				stack.push(curr.right);
			
			if(curr.left != null) {
				TreeNode left = curr.left;
				curr.right = curr.left;
				curr.left = null;
				curr = left;
			} else {
				if(!stack.isEmpty()) {
					TreeNode right = stack.pop();
					curr.right = right;
					curr = right;
				} else break;
			}
		}
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n4.left = n7; n4.right = n8;
		n2.left = n3; n2.right = n4;
		n5.right = n6;
		n1.left = n2; n1.right = n5;
		
		return n1;
	}

}
