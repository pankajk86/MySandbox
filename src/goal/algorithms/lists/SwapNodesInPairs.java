package goal.algorithms.lists;

import google.ListNode;

public class SwapNodesInPairs {

    public static void main(String[] args) {

    	ListNode head = createList();
        ListNode result = swapListInPairs(head);
        System.out.println(result);
    }

	private static ListNode swapListInPairs(ListNode head) {
    	if(head == null || head.next == null) return head;
        ListNode newHead = null, curr = head, prev = null;
        
        while(curr != null && curr.next != null) {
            ListNode next = curr.next, nextNext = curr.next.next;
            if(prev != null) prev.next = next;
            
            curr.next = nextNext;
            next.next = curr;
            if(newHead == null) newHead = next;
            prev = curr;
            curr = nextNext;
        }
        return newHead;
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
