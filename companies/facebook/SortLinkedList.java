package facebook;

import google.ListNode;

public class SortLinkedList {

	public static void main(String[] args) {
		ListNode head = createList();
		ListNode result = sortList(head);
		
		while(result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
	}

	private static ListNode sortList(ListNode head) {
		if(head == null || head.next == null)
			return head;
		
		ListNode pre = null, slow = head, fast = head;
		
		while(fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		pre.next = null;
		ListNode l1 = sortList(head), l2 = sortList(slow);
		ListNode result = merge(l1, l2);
		return result;
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				curr.next = l1; 
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		
		if(l1 != null)
			curr.next = l1;
		if(l2 != null)
			curr.next = l2;
		
		return dummy.next;
	}

	private static ListNode createList() {

		ListNode n1 = new ListNode(-1);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(0);
		
		n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		return n1;
	}

}
