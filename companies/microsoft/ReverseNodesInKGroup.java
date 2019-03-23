package microsoft;

import google.ListNode;

public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		ListNode head = createList();
		ListNode result = reverseInKGroup(head, 3);
		
		for(ListNode curr = result; curr != null; curr = curr.next)
			System.out.print(curr.val + " ");
	}

	private static ListNode reverseInKGroup(ListNode head, int k) {
		int size = 0;
		
		for(ListNode curr = head; curr != null; curr = curr.next)
			size++;
		
		if(size == 0 || k > size) return head;
		
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy, curr = head;
		
		for(int i = 0; i < size / k; i++ ) {
			for(int j = 0; j < k - 1; j++) {
				ListNode next = curr.next;
				curr.next = next.next;
				next.next = pre.next;
				pre.next = next;
			}
			pre = curr;
			curr = pre.next;
		}
		
		return dummy.next;
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
