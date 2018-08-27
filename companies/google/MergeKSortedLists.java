package google;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

	public static void main(String[] args) {
		ListNode[] lists = create3Lists();
		ListNode result = merge(lists);
		ListNode temp = result;
		
		while(temp != null) {
			System.out.print(temp.val + ", ");
			temp = temp.next;
		}
	}

	private static ListNode merge(ListNode[] lists) {
		int k = lists.length;
		ListNode head = null, current = null;
		PriorityQueue<IndexNode> pq = new PriorityQueue<>(new IndexNodeComparator());
		
		if(lists != null) {
            for(int i = 0; i < k; i++) {
                if(lists[i] != null)
                    pq.add(new IndexNode(i, lists[i]));
            }

            while(!pq.isEmpty()) {
                IndexNode inode = pq.poll();
                if(inode != null && inode.node != null) {
                    ListNode node = new ListNode(inode.node.val);

                    if(current == null) {
                        current = node;
                        head = current;
                    } else {
                        current.next = node;
                        current = current.next;
                    }

                    if(inode.node.next != null) {
                        IndexNode next = new IndexNode(inode.index, inode.node.next); 
                        pq.add(next);
                    } 
                }
            }
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
		
//		ListNode n15 = new ListNode(30);
//		n15.next = n1; 
		
		n1.next = n2; n2.next = n4; n4.next = n5;
		n3.next = n6; n6.next = n7; n7.next = n11; n11.next = n13;
		n14.next = n8; n8.next = n9; n9.next = n10; n10.next = n12;
		
		return new ListNode[] {n1, n3, n14};
	}

}

class IndexNodeComparator implements Comparator<IndexNode> {

	@Override
	public int compare(IndexNode a1, IndexNode a2) {
		if(a1.node.val < a2.node.val)
			return -1;
		else if(a1.node.val > a2.node.val)
			return 1;
		return 0;
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
