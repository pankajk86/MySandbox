package microsoft;

import google.ListNode;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode head = createList();
		System.out.println(head);
		ListNode result = removeDuplicates(head);
		System.out.println(result);
	}


	private static ListNode removeDuplicates(ListNode head) {
		if(head == null) return null;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy, curr = head;
		
		while(curr != null) {
			while(curr.next != null && curr.next.val == curr.val)
				curr = curr.next;
			
			prev.next = curr;
			prev = curr;
			curr = curr.next;
		}
		
		return dummy.next;
	}


	private static ListNode createList() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(1);
		ListNode n3 = new ListNode(1);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(3);
		ListNode n7 = new ListNode(4);
		ListNode n8 = new ListNode(5);
		
		n7.next = n8; n6.next = n7; n5.next = n6; n4.next = n5;
		n3.next = n4; n2.next = n3; n1.next = n2;
		
		return n1;
	}
}
