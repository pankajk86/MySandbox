package arrays;

import google.ListNode;

public class AddTwoNumbers {

	public static void main(String[] args) {

		ListNode l1 = getList(342);
		ListNode l2 = getList(465);
		
		ListNode result = addNumbers(l1, l2);
		System.out.println(result);
	}

	private static ListNode addNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		int carry = 0;
		ListNode c1 = l1, c2 = l2, c = dummy;

		for (;c1 != null && c2 != null; c1 = c1.next, c2 = c2.next, c = c.next) {
			int val = c1.val + c2.val + carry;
			carry = val / 10;
			val = val % 10;
			c.next = new ListNode(val);
		}

		for (;c1 != null; c1 = c1.next, c = c.next) {
			int val = c1.val + carry;
			carry = val / 10;
			val = val % 10;
			c.next = new ListNode(val);
		}

		for (;c2 != null; c2 = c2.next, c = c.next) {
			int val = c2.val + carry;
			carry = val / 10;
			val = val % 10;
			c.next = new ListNode(val);
		}

		if (carry > 0)
			c.next = new ListNode(carry);
		return dummy.next;
	}



	/**
	 * Creates a reversed linked list from a given integer array
	 * Input: [2, 4, 3], Output: 2 -> 4 -> 3 
	 * 
	 * @param n
	 * @return
	 */
	@SuppressWarnings("unused")
	private static ListNode getList(int[] a) {

		ListNode head = new ListNode(a[0]);
		ListNode l1 = head;

		for (int i = 1; i < a.length; i++) {
			l1.next = new ListNode(a[i]);
			l1 = l1.next;
		}

		return head;
	}
	
	/**
	 * Creates a reversed linked list from a given number
	 * Input: 342, Output: 2 -> 4 -> 3 
	 * 
	 * @param n
	 * @return
	 */
	private static ListNode getList(int n) {

		ListNode head = new ListNode(n % 10);
		ListNode l = head;
		
		n = n / 10;
		
		while(n > 0) {
			l.next = new ListNode(n % 10);
			l = l.next;
			n = n / 10;
		}
		
		return head;
	}

}