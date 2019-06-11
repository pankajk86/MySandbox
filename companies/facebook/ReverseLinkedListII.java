package facebook;

import google.ListNode;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		ListNode head = createList();
		int m = 2, n = 5;
		ListNode result = reverse(head, m, n);
		System.out.println(result);
	}

	private static ListNode reverse(ListNode head, int m, int n) {
		if(m == n) return head;
		ListNode origHead = head, prev = null, curr = head;
		
		for(int i = 1; i < m; i++) {
			prev = curr;
			curr = curr.next;
		}
		
		ListNode temp = null;
		for(int i = m; i < n; i++) {
			ListNode next = curr.next;
			curr.next = next.next;
			next.next = temp == null ? curr : temp;
			temp = next;
		}
		
		if(prev != null)
			prev.next = temp;
		
		return m == 1 ? temp : origHead;
	}

	private static ListNode createList() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		
		n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		return n1;
	}

}
