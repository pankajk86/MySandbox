package google;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

	public static void main(String[] args) {
		ListNode head = createList();
		int[] g = { 0, 3, 1, 4 };
		
		int result = numComponents(head, g);
		System.out.println(result);
	}

	private static int numComponents(ListNode head, int[] g) {
		if(g == null || g.length == 0) return 0;
		
		Set<Integer> set = new HashSet<>();
		for(int i: g) set.add(i);
		int result = 0, temp = 0;
		
		for(ListNode curr = head; curr != null; curr = curr.next) {
			while(set.contains(curr.val)) {
				temp++;
				curr = curr.next; 
				if(curr == null) break;
			}
			
			if(temp > 0) {
				result++;
				temp = 0;
			}
			if(curr == null) break;
		}
		
		return result;
	}

	private static ListNode createList() {
		ListNode n0 = new ListNode(0);
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		
		n3.next = n4; n2.next = n3; n1.next = n2; n0.next = n1;
		return n0;
	}

}
