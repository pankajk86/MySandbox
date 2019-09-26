package google;

import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode[] lists = create3Lists();
		ListNode result = merge(lists);
		ListNode temp = result;

		while (temp != null) {
			System.out.print(temp.val + ", ");
			temp = temp.next;
		}
	}

	private static ListNode merge(ListNode[] lists) {
		if (lists == null || lists.length == 0)
			return null;

		ListNode head = null, next = head;
		PriorityQueue<IndexNode> pq = new PriorityQueue<>((i1, i2) -> (i1.node.val - i2.node.val));
		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) pq.add(new IndexNode(i, lists[i]));
		}

		while (!pq.isEmpty()) {
			IndexNode curr = pq.poll();
			if (head == null) {
				head = curr.node;
				next = head;
			} else {
				next.next = curr.node;
				next = next.next;
			}

			if (curr.node.next != null)
				pq.add(new IndexNode(curr.index, curr.node.next));
		}
		return head;
	}

	private static ListNode[] create3Lists() {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(7);
		ListNode n6 = new ListNode(9);
		ListNode n7 = new ListNode(10);
		ListNode n8 = new ListNode(10);
		ListNode n9 = new ListNode(15);
		ListNode n10 = new ListNode(19);
		ListNode n11 = new ListNode(20);
		ListNode n12 = new ListNode(25);
		ListNode n13 = new ListNode(27);
		ListNode n14 = new ListNode(4);

		// ListNode n15 = new ListNode(30);
		// n15.next = n1;

		n1.next = n2;
		n2.next = n4;
		n4.next = n5;
		n3.next = n6;
		n6.next = n7;
		n7.next = n11;
		n11.next = n13;
		n14.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n12;

		return new ListNode[] { n1, n3, n14 };
	}

}

class IndexNode {
	int index;
	ListNode node;

	IndexNode(int index, ListNode node) {
		this.index = index;
		this.node = node;
	}
}
