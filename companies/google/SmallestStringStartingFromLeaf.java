package google;

import trees.TreeNode;

public class SmallestStringStartingFromLeaf {
	
	private static String smallest = null;

	public static void main(String[] args) {
		TreeNode root = createTree();
		String result = smallestLeaf(root);
		System.out.println(result);
		
		root = createTree2();
		result = smallestLeaf(root);
		System.out.println(result);
		
		System.out.println("ae".compareTo("bae"));
	}

	private static String smallestLeaf(TreeNode root) {
		if(root.left == null && root.right == null) {
			return String.valueOf((char) (97 + root.val));
		}
		if(root.left == null) {
			TreeNode dummy = new TreeNode(26);
			root.left = dummy;
		}
		
		if(root.right == null) {
			TreeNode dummy = new TreeNode(26);
			root.right = dummy;
		}
		inorder(root, "");
		return smallest;
	}

	private static void inorder(TreeNode root, String s) {
		if(root == null) {
			if(smallest == null || smallest.compareTo(s) > 0)
				smallest = s;
			return;
		}
		
		String updated = String.valueOf((char) (97 + root.val)) + s;
		inorder(root.left, updated);
		inorder(root.right, updated);
	}
	
	private static TreeNode createTree2() {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		n1.right = n2;
		return n1;
	}

	private static TreeNode createTree() {
		TreeNode n1 = new TreeNode(0);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(4);
		
		n2.left = n4; n2.right = n5;
		n3.left = n6; n3.right = n7;
		n1.left = n2; n1.right = n3;
		return n1;
	}

}
