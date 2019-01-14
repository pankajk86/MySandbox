package linkedin;

import java.util.Random;

import google.ListNode;

public class DesignLinkedListRandomNode {

	public static void main(String[] args) {
		ListNode head = createList();
		LinkedListRandomNode llrNode = new LinkedListRandomNode(head);
		System.out.println(llrNode.getRandom());
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


class LinkedListRandomNode {
	
	private ListNode head = null;
	private Random random = null;
	
	LinkedListRandomNode(ListNode head) {
		this.head = head;
		this.random = new Random();
	}
	
	public int getRandom() {
		ListNode result = head, curr = head;
		int size = 1;
		
		while(curr != null) {
			if(random.nextInt(size) == 0)
				result = curr;
			curr = curr.next;
			size++;
		}
		return result.val;
	}
}
