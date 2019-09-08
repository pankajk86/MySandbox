package linkedin;

import google.ListNode;

public class CheckMergedLinkedListsWithLoops {

	public static void main(String[] args) {
		ListNode[] lists = createLists();
		boolean result = areMerged(lists[0], lists[1]);
		System.out.println(result);
	}

	private static boolean areMerged(ListNode head1, ListNode head2) {
		ListNode cycleNode1 = detectCycle(head1), cycleNode2 = detectCycle(head2);
		
		if((cycleNode1 != null && cycleNode2 == null) || (cycleNode1 == null && cycleNode2 != null))
			return false;
		
		if(cycleNode1 != null && cycleNode2 != null) {
			for(ListNode curr = cycleNode1.next; curr != cycleNode1; curr = curr.next) {
				if(curr == cycleNode2) return true;
			}
			return false;
		}
		
		return withoutCycle(head1, head2);
	}
	
	private static boolean withoutCycle(ListNode head1, ListNode head2) {
		int len1 = 0, len2 = 0;
		for(ListNode curr = head1; curr != null; curr = curr.next)
			len1++;
		
		for(ListNode curr = head2; curr != null; curr = curr.next)
			len2++;
		
		int stepForward = Math.max(len1, len2) - Math.min(len1, len2);
		if(len1 > len2) return foundMerged(head1, head2, stepForward);
		else return foundMerged(head2, head1, stepForward);
	}
	
	private static boolean foundMerged(ListNode longer, ListNode shorter, int step) {
		for(int i = 0; i < step; i++)
			longer = longer.next;
		
		for(ListNode n1 = longer, n2 = shorter; n1 != null && n2 != null; n1 = n1.next, n2 = n2.next) {
			if(n1 == n2) return true;
		}
		return false;
	}
	
	private static ListNode detectCycle(ListNode head) {
		if(head == null) return head;
		ListNode fast = head, slow = head;

		while(fast.next != null && fast.next.next != null) {
			slow = slow.next; fast = fast.next.next;
			if(slow == fast) return slow;
		}
		return null;
	}
	
	private static ListNode[] createLists() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n4.next = n5; n3.next = n4; 
		// n5.next = n3; // WithCycle 
		
		n2.next = n3; n1.next = n2;
		n6.next = n3;
		
		return new ListNode[] {n1, n6};
	}

}
