package goal.algorithms.lists;

import google.ListNode;

public class MergeSortedLists {

    public static void main(String[] args) {
    	ListNode[] lists = createLists();
    	ListNode result = merge(lists[0], lists[1]);
    	System.out.println(result);
    }

	private static ListNode merge(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		
		ListNode dummy = new ListNode(0), curr = dummy;
		while(l1 != null && l2 != null) {
			if(l1.val <= l2.val) {
				curr.next = l1; l1 = l1.next;
			} else {
				curr.next = l2; l2 = l2.next;
			}
			curr = curr.next;
		}
		
		curr.next = l1 == null ? l2 : l1;
		return dummy.next;
	}

	private static ListNode[] createLists() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);
		
		n2.next = n3; n1.next = n2;
		n5.next = n6; n4.next = n5;
		
		return new ListNode[] {n1, n4};
	}
}
