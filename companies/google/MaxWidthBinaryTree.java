package google;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class MaxWidthBinaryTree {

	public static void main(String[] args) {
		TreeNode root = createTree();
		int result = maxWidth(root);
		System.out.println(result);
		
		root = createTree2();
		result = maxWidth(root);
		System.out.println(result);
		
		root = new TreeNode(1);
		result = maxWidth(root);
		System.out.println(result);
	}

	private static int maxWidth(TreeNode root) {

		if (root == null)
			return 0;

		int result = 1;
		List<TreeNode> q1 = new ArrayList<>();
		List<TreeNode> q2 = new ArrayList<>();
		q1.add(root);

		while (!q1.isEmpty() || !q2.isEmpty()) {
			if(!q1.isEmpty()) {
				while(!q1.isEmpty()) {
					TreeNode current = q1.remove(0);
					if(current != null) {
						q2.add(current.left);
						q2.add(current.right);
					} else {
						q2.add(null);
						q2.add(null);
					}
				}
				if(isNull(q2)) break;
				result = Math.max(result, findWidth(q2));
			} else if(!q2.isEmpty()) {
				while(!q2.isEmpty()) {
					TreeNode current = q2.remove(0);
					if(current != null) {
						q1.add(current.left);
						q1.add(current.right);
					} else {
						q1.add(null);
						q1.add(null);
					}
				}
				if(isNull(q1)) break;
				result = Math.max(result, findWidth(q1));
			}
		}

		return result;
	}

	private static int findWidth(List<TreeNode> q) {

		int start = 0, end = 0;
		
		for(int i = 0; i < q.size(); i++) {
			TreeNode current = q.get(i);
			if(current != null) {
				start = i; break;
			}
		}
		
		for(int i = q.size() - 1; i > 0; i--) {
			TreeNode current = q.get(i);
			if(current != null) {
				end = i; break;
			}
		}
		
		return (start == 0 && end == 0) ? 0 : end - start + 1;
	}

	private static boolean isNull(List<TreeNode> q) {
		
		if(q.isEmpty()) return false;
		
		for (TreeNode node : q) {
			if (node != null)
				return false;
		}
		return true;
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(3);
		TreeNode n6 = new TreeNode(9);

		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n1.left = n2;
		n1.right = n3;

		return n1;
	}
	
	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(9);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		
		n4.left = n6; n5.right = n7;
		n2.left = n4; n3.right = n5;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
