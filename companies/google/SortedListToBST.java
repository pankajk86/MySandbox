package google;

import trees.TreeNode;

public class SortedListToBST {

	public static void main(String[] args) {
		ListNode head = createList();
		TreeNode result = createBST(head);
		System.out.println(result.val);
	}

	private static TreeNode createBST(ListNode head) {

		int size = 0;
		for(ListNode curr = head; curr != null; curr = curr.next)
			size++;
		
		TreeNode root = helper(head, 0, size - 1);
		return root;
	}

	private static TreeNode helper(ListNode head, int start, int end) {
		if(start > end) return null;
		if(start == end) {
			ListNode node = getNode(start, head);
			return new TreeNode(node.val);
		}
		
		if(end - start == 1) {
			TreeNode root = new TreeNode(getNode(end, head).val);
			TreeNode left = new TreeNode(getNode(start, head).val);
			root.left = left;
			return root;
		}
		
		int mid = (start + end) / 2;
		ListNode curr = getNode(mid, head);
		TreeNode root = new TreeNode(curr.val);
		root.left = helper(head, start, mid - 1);
		root.right = helper(head, mid + 1, end);
		
		return root;
	}
	
	private static ListNode getNode(int index, ListNode head) {
		ListNode curr = head;
		for(int i = 0; i < index; i++)
			curr = curr.next;
		return curr;
	}

	private static ListNode createList() {
		ListNode n1 = new ListNode(-10);
		ListNode n2 = new ListNode(-3);
		ListNode n3 = new ListNode(0);
		ListNode n4 = new ListNode(5);
		ListNode n5 = new ListNode(9);
		
		n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		return n1;
	}

}
