package facebook;

import java.util.LinkedList;
import java.util.Queue;

import trees.TreeNode;

public class CheckCompletenessOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		boolean result = isComplete(root);
		System.out.println(result);
		
		root = createTree2();
		result = isComplete(root);
		System.out.println(result);
	}

	private static boolean isComplete(TreeNode root) {
		if(root == null) return true;
		
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(q.peek() != null) {
			TreeNode curr = q.poll();
			q.add(curr.left); 
			q.add(curr.right);
		}
		
		while(!q.isEmpty()) {
			TreeNode curr = q.poll();
			if(curr != null) return false;
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
		
		n2.left = n4; n2.right = n5;
		n3.right = n6;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}
	
	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		
		n1.right = n2;
		return n1;
	}

}
