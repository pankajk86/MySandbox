package microsoft;

import google.ListNode;

public class PartitionList {

	public static void main(String[] args) {
		ListNode head = createList();
		int x = 3;
		
		ListNode result = partitionList(head, x);
		System.out.println(result);
		
		result = partitionList2(head, x);
		System.out.println(result);
	}
	
	private static ListNode partitionList2(ListNode head, int x) {
		ListNode p = null, pHead = null, prev = null;
		
		for(ListNode curr = head; curr != null; ) {
			if(curr.val < x) {
				prev = curr;
				curr = curr.next;
			} else {
				ListNode next = curr.next;
				if(pHead == null) {
					pHead = curr;
					p = curr;
				} else {
					p.next = curr;
					p = p.next;
				}
				prev.next = next;
				curr = next;
			}
		}
		
		prev.next = pHead;
		return head;
	}

	private static ListNode partitionList(ListNode head, int x) {
		ListNode smallerHead = new ListNode(0), biggerHead = new ListNode(0);
		ListNode smaller = smallerHead, bigger = biggerHead;
		
		while(head != null) {
			if(head.val < x) smaller = smaller.next = head;
			else bigger = bigger.next = head;
			head = head.next;
		}
		
		smaller.next = biggerHead.next;
		bigger.next = null;
		return smallerHead.next;
	}

	private static ListNode createList() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(2);
		
		// 1 -> 4 -> 3 -> 2 -> 5 -> 2
		n5.next = n6; n2.next = n5; n3.next = n2; n4.next = n3; n1.next = n4;
		return n1;
	}

}
