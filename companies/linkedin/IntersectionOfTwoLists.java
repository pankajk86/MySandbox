package linkedin;

import google.ListNode;

public class IntersectionOfTwoLists {

	public static void main(String[] args) {
		ListNode head1 = createList1();
		ListNode head2 = createList2();
		ListNode result = getIntersection(head1, head2);
		System.out.println(result.val);
	}

	private static ListNode getIntersection(ListNode head1, ListNode head2) {
		
		if(head1 == null || head2 == null)
			return null;
		
		ListNode curr1 = head1, curr2 = head2;
		int size1 = 0, size2 = 0;
		while(curr1 != null) {
			size1++;
			curr1 = curr1.next;
		}
		
		while(curr2 != null) {
			size2++;
			curr2 = curr2.next;
		}
		
		curr1 = head1; curr2 = head2;
		
		if(size1 > size2) {
			while(size1 != size2) {
				curr1 = curr1.next; 
				size1--;
			}
		} else if(size1 < size2) {
			while(size1 != size2) {
				curr2 = curr2.next; 
				size2--;
			}
		}
		
		while(curr1.val != curr2.val) {
			curr1 = curr1.next; 
			curr2 = curr2.next;
			
			if(curr1 == null || curr2 == null)
				return null;
		}
		
		return curr1;
	}

	private static ListNode createList1() {
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n5.next = n6; n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		return n1;
	}
	
	
	private static ListNode createList2() {
		
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n5.next = n6; n4.next = n5; n2.next = n4; n1.next = n2;
		return n1;
	}

}
