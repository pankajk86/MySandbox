package arrays;

public class AddTwoNumbers {

	public static void main(String[] args) {

		ListNode l1 = getList(342);
		ListNode l2 = getList(465);
		
		ListNode sum = addNumbers(l1, l2);
		
		for(ListNode l = sum; l != null; l = l.next) {
			System.out.print(l.val + "->" );
		}
	}

	

	private static ListNode addNumbers(ListNode l1, ListNode l2) {
		
		ListNode head = null;
		ListNode sum = head;
		int carry = 0;
		
		while(l1 != null && l2 != null) {
			int val = l1.val + l2.val + carry;
			
			if(val >= 10) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}
			
			if(sum == null) {
				sum = new ListNode(val);
				head = sum;
			} else {
				sum.next = new ListNode(val);
				sum = sum.next;
			}
			
			l1 = l1.next; l2 = l2.next;
		}
		
		while(l1 != null) {
			int val = l1.val + carry;
			if(val >= 10) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}
			sum.next = new ListNode(val);
			
			sum = sum.next; l1 = l1.next;
		}
		
		while(l2 != null) {
			int val = l2.val + carry;
			if(val >= 10) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}
			
			sum.next = new ListNode(val);
			
			sum = sum.next; l2 = l2.next;
		}
		
		if(carry > 0) {
			sum.next = new ListNode(carry);
		}
		
		
		return head;
	}



	/**
	 * Creates a reversed linked list from a given integer array
	 * Input: [2, 4, 3], Output: 2 -> 4 -> 3 
	 * 
	 * @param n
	 * @return
	 */
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

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
