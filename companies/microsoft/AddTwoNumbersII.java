package microsoft;

import google.ListNode;

public class AddTwoNumbersII {

	public static void main(String[] args) {
		ListNode l1 = createList1();
		ListNode l2 = createList2();

		ListNode result = sumBetter(l1, l2);
		System.out.print(result);
	}
	
	private static ListNode sumBetter(ListNode h1, ListNode h2) {
		h1 = reverse(h1); h2 = reverse(h2);
		ListNode dummy = new ListNode(0), curr = dummy;
		ListNode l1 = h1, l2 = h2;
		int carry = 0;
		
		for(; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
			int val = l1.val + l2.val + carry;
			carry = val / 10; val = val % 10; 
			
			curr.next = new ListNode(val);
			curr = curr.next;
		}
		
		while(l1 != null) {
			int val = l1.val + carry;
			carry = val / 10; val = val % 10;
			
			curr.next = new ListNode(val);
			curr = curr.next;
			l1 = l1.next;
		}
		
		while(l2 != null) {
			int val = l2.val + carry;
			carry = val / 10; val = val % 10;
			
			curr.next = new ListNode(val);
			curr = curr.next;
			l2 = l2.next;
		}
		
		if(carry > 0) curr.next = new ListNode(carry);
		ListNode result = reverse(dummy.next);
		
		return result;
	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null, curr = head;
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr; curr = next;
		}
		return prev;
	}

	private static ListNode createList1() {

		ListNode n1 = new ListNode(7);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(3);
 
		n3.next = n4; 
		n2.next = n3;
		n1.next = n2;
		return n1;
	}
	
	private static ListNode createList2() {
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(4);
		
		n6.next = n7;
		n5.next = n6;
		return n5;
	}

}
