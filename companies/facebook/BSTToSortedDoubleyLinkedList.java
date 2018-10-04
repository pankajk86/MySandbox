package facebook;

import java.util.ArrayList;
import java.util.List;

import trees.TreeNode;

public class BSTToSortedDoubleyLinkedList {
	
	private static List<TreeNode> inorderList = new ArrayList<>();

	public static void main(String[] args) {
		TreeNode root = createTree();
		TreeNode result = treeToDoublyList(root);
		System.out.println(result.val);
	}

	private static TreeNode treeToDoublyList(TreeNode root) {

		inorder(root);
		int n = inorderList.size();
		
		for(int i = 0; i < n; i++) {
			TreeNode curr = inorderList.get(i);
			curr.right = (i == n - 1) ? inorderList.get(0) : inorderList.get(i + 1);
			curr.left = (i == 0) ? inorderList.get(n - 1) : inorderList.get(i - 1);
		}
		
		return inorderList.get(0);
	}

	private static void inorder(TreeNode root) {
		if(root == null) return;
		
		inorder(root.left);
		inorderList.add(root);
		inorder(root.right);
	}

	private static TreeNode createTree() {

		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		
		n2.left = n1; n2.right = n3;
		n4.left = n2; n4.right = n5;
		
		return n4;
	}

}
