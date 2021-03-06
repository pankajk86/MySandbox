package amazon;

import java.util.Stack;

import trees.TreeNode;

public class KthSmallestInBST {

	private static int result = -1, temp = 0;
	private static boolean found = false;
	
	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = kthSmallest(root, 3);
		System.out.println(result);
		
		result = kthSmallestRecursion(root, 3);
		System.out.println(result);
	}
	
	private static int kthSmallestRecursion(TreeNode root, int k) {
		inorder(root, k);
		return result;
	}

	private static void inorder(TreeNode root, int k) {
		if(root == null || found) return;
		
		if(!found) inorder(root.left, k);
		temp++;
		if(temp == k) {
			result = root.val;
			found = true; return;
		}
		if(!found) inorder(root.right, k);
	}

	private static int kthSmallest(TreeNode root, int k) {

		Stack<TreeNode> stack = new Stack<>();
		int count = 0;
		
		TreeNode curr = root;
		
		while(!stack.isEmpty() || curr != null) {
			
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				count++;
				if(count == k) 
					return curr.val;
				curr = curr.right;
			}
		}
		
		return -1;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		
		n2.left = n1;
		n3.left = n2; n3.right = n4;
		n5.left = n3; n5.right = n6;
		
		return n5;
	}

}

