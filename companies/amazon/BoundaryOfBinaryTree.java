package amazon;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class BoundaryOfBinaryTree {
	
	private static List<Integer> nodes = new ArrayList<>();

	public static void main(String[] args) {
		TreeNode root = createTree();
		List<Integer> result = findBoundary(root);
		System.out.println(result);
	}

	private static List<Integer> findBoundary(TreeNode root) {

		if(root == null) return nodes;
		
		nodes.add(root.val);
		
		findLeftBoundary(root.left);
		findBottomBoundary(root.left);
		findBottomBoundary(root.right);
		findRightBoundary(root.right);
		
		return nodes;
	}

	private static void findBottomBoundary(TreeNode root) {
		if(root == null) return;
		
		if(root.left == null && root.right == null) {
			nodes.add(root.val);
			return;
		}
		
		findBottomBoundary(root.left);
		findBottomBoundary(root.right);
	}
	
	private static void findRightBoundary(TreeNode root) {
		
		if(root == null || (root.left == null && root.right == null)) return;
		
		if(root.right == null) findRightBoundary(root.left);
		else findRightBoundary(root.right);
		nodes.add(root.val); // add after child visit to reverse the order
	}

	private static void findLeftBoundary(TreeNode root) {
		
		if(root == null || (root.left == null && root.right == null)) return;
		
		nodes.add(root.val);
		if(root.left == null) findLeftBoundary(root.right);
		else findLeftBoundary(root.left);
	}
	
	@SuppressWarnings("unused")
	private static List<Integer> findBottomBoundaryIter(TreeNode root) {

		List<TreeNode> l1 = new ArrayList<>();
		List<TreeNode> l2 = new ArrayList<>();
		List<Integer> result = null;
		
		l1.add(root);
		
		while(l1.size() > 0 || l2.size() > 0) {
			if(l1.size() > 0) {
				result = new ArrayList<>();
				for(TreeNode n: l1) 
					result.add(n.val);
				
				while(l1.size() > 0) {
					TreeNode curr = l1.remove(0);
					if(curr.left != null)
						l2.add(curr.left);
					if(curr.right != null)
						l2.add(curr.right);
				}
			} else if(l2.size() > 0) {
				result = new ArrayList<>();
				for(TreeNode n: l2) 
					result.add(n.val);
				
				while(l2.size() > 0) {
					TreeNode curr = l2.remove(0);
					if(curr.left != null)
						l1.add(curr.left);
					if(curr.right != null)
						l1.add(curr.right);
				}
			}
		}
		
		return result;
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
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		
		n4.right = n7;
		n5.left = n8; n5.right = n9;
		n6.left = n10; n6.right = n11;
		n2.left = n4; n2.right = n5; 
		n3.left = n6;
		n1.left = n2; n1.right = n3;
		
		return n1;
	}

}
