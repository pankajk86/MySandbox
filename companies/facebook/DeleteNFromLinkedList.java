package facebook;

import google.ListNode;

public class DeleteNFromLinkedList {

	public static void main(String[] args) {
		ListNode head = createList();
		System.out.println(head);
		ListNode result = remove(3, head);
		System.out.println(result);

	}

	private static ListNode remove(int n, ListNode head) {
		ListNode curr = head, prev = null;

		while (curr != null && curr.val == n) {
			head = curr.next; // Changed head
			curr = head; // Change Temp
		}

		// Delete occurrences other than head
		while (curr != null) {
			// Search for the key to be deleted,
			// keep track of the previous node
			// as we need to change 'prev->next'
			while (curr != null && curr.val != n) {
				prev = curr;
				curr = curr.next;
			}

			// If key was not present in linked list
			if (curr == null)
				return head;

			// Unlink the node from linked list
			prev.next = curr.next;

			// Update Temp for next iteration of outer loop
			curr = prev.next;
		}

		return head;
	}

	private static ListNode createList() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(5);
		ListNode n7 = new ListNode(3);
		ListNode n8 = new ListNode(3);

		n6.next = n7; n5.next = n6;
		n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		n8.next = n1;
		return n8;
	}

}
