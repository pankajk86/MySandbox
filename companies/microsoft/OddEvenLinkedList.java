package microsoft;

import google.ListNode;

public class OddEvenLinkedList {

	public static void main(String[] args) {
		ListNode head = createList();
		ListNode result = processList(head);
		
		System.out.println(result);
	}

	private static ListNode processList(ListNode head) {
		if(head != null) {
			ListNode odd = head, even = head.next, evenHead = even;
			
			while(even != null && even.next != null) {
				odd.next = odd.next.next;
				even.next = even.next.next;
				odd = odd.next;
				even = even.next;
			}
			odd.next = evenHead;
		}
		return head;
	}
	
	@SuppressWarnings("unused")
	private static ListNode createList2() {
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(1);
		
		n1.next = n2;
		return n1;
	}

	private static ListNode createList() {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		n4.next = n7; n6.next = n4; n5.next = n6;
		n6.next = n7; n5.next = n6;
		n3.next = n5; n1.next = n3; n2.next = n1;
		
		return n2;
	}

}
