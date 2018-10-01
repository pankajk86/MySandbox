package facebook;

import java.util.Stack;

import google.ListNode;

public class ReorderList {

	public static void main(String[] args) {
		ListNode head = createList();
		reorderList(head);
		
		for(ListNode curr = head; curr != null; curr = curr.next) {
			System.out.print(curr.val + " ");
		}
	}

	private static void reorderList(ListNode head) {
		if(head == null) return;
		
		ListNode curr = head;
		int count = 0;
		
		while(curr != null) {
			count++;
			curr = curr.next;
		}
		
		Stack<ListNode> stack = new Stack<>();
		curr = head;
		
		for(int i = 0; i < count / 2; i++) 
			curr = curr.next;

		ListNode part = curr.next;
		curr.next = null;
		
		while(part != null) {
			stack.push(part);
			part = part.next;
		}
		
		curr = head;
		
		while(curr != null && !stack.isEmpty()) {
			ListNode next = curr.next;
			curr.next = stack.pop(); curr = curr.next;
			curr.next = next; curr = curr.next;
		}
	}

	private static ListNode createList() {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);
		
		ListNode n8 = new ListNode(8);
		n7.next = n8;
		
		n6.next = n7; n5.next = n6; n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		return n1;
	}

}
