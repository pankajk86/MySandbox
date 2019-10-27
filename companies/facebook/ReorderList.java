package facebook;

import google.ListNode;

public class ReorderList {

	public static void main(String[] args) {
		ListNode head = createList();
		reorderList(head);
		System.out.println(head);
	}
	
	private static void reorderList(ListNode head) {
		if(head == null || head.next == null) return;
		ListNode mid = findMid(head);
		ListNode left = head, right = mid.next;
		mid.next = null;
		right = reverse(right);
		merge(left, right);
	}

	private static void merge(ListNode left, ListNode right) {
		while(right != null) {
			ListNode next = left.next;
			left.next = right;
			left = right; right = next;
		}
	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head; head = next;
		}
		return prev;
	}

	private static ListNode findMid(ListNode head) {
		ListNode slow = head, fast = head;
		while(fast != null && fast.next.next != null) {
			slow = slow.next; fast = fast.next.next;
		}
		return slow;
	}

	private static ListNode createList() {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		ListNode n8 = new ListNode(8);
		n7.next = n8;
		
		n6.next = n7; n5.next = n6; n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		return n1;
	}

}
