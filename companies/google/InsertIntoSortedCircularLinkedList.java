package google;

public class InsertIntoSortedCircularLinkedList {

	public static void main(String[] args) {
		ListNode head = createList();
		ListNode result = insert(head, 2);
		System.out.println(result);
	}

	private static ListNode insert(ListNode head, int val) {
		if (head == null) {
			ListNode node = new ListNode(val);
			node.next = node;
			return node;
		}

		ListNode curr;

		for (curr = head; curr.next != head; curr = curr.next) {
			if (val >= curr.val && val <= curr.next.val) {
                curr.next = new ListNode(val, curr.next);
				return head;
			} else if (curr.val > curr.next.val) {
				if (val >= curr.val || val <= curr.next.val) {
                    curr.next = new ListNode(val, curr.next);
					return head;
				}
			}
		}

        curr.next = new ListNode(val, curr.next);
		return head;
	}

	private static ListNode createList() {
		ListNode n1 = new ListNode(1);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		
		n3.next = n4; n4.next = n1; n1.next = n3;
		return n3;
	}

}
