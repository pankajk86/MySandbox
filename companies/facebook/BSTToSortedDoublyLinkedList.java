package facebook;

import trees.TreeNode;

public class BSTToSortedDoublyLinkedList {
	
	private static TreeNode head, prev;

	public static void main(String[] args) {
		TreeNode root = createTree();
		
		TreeNode result = treeToDoublyListBetter(root);
		System.out.println(result.val);
	}

	private static TreeNode treeToDoublyListBetter(TreeNode root) {
		inorder(root);
		
		if(head != null) {
			prev.right = head;
			head.left = prev;
		}
		return head;
	}
	
	private static void inorder(TreeNode root) {
		if(root == null) return;
		
		inorder(root.left);
		if(head == null) head = root;
		if(prev != null) prev.right = root;
		
		root.left = prev;
		prev = root;
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
