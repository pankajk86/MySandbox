package google;

public class InsertIntoACyclicSortedList {

	public static void main(String[] args) {
		ListNode head = createList();
		ListNode result = insert(head, 2);
		System.out.println(result);
	}

	private static ListNode insert(ListNode head, int val) {
		if(head == null) {
			ListNode newHead = new ListNode(val);
			newHead.next = newHead;
			return newHead;
		}
		
		ListNode thead = head, curr = head, next = head.next, tend = head;
		while(next != thead) {
			if(next.val >= curr.val) {
				curr = next; next = next.next;
			} else {
				tend = curr; tend.next = null;
				thead = next;
				break;
			}
		}
		
		ListNode newNode = new ListNode(val);
		if(val <= thead.val || val > tend.val) {
			newNode.next = thead; tend.next = newNode;
		} else {
			for(curr = thead; curr != tend; curr = curr.next) {
				if(curr.val < val && curr.next.val >= val) {
					next = curr.next;
					curr.next = newNode; newNode.next = next;
					tend.next = thead;
					break;
				}
			}
		}
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
