package google;

public class PlusOneLinkedList {

	public static void main(String[] args) {
		ListNode head = createList2(); 
		ListNode result = addOneInPlace(head);
		System.out.println(result);
		
		head = createList();
		result = addOne(head);
		System.out.println(result);
	}
	
	private static ListNode addOneInPlace(ListNode head) {
		head = reverse(head);
		int carry = 1;
		ListNode tail = null;
		
		for(ListNode curr = head; curr != null; curr = curr.next) {
			int val = curr.val + carry;
			carry = val > 9 ? val / 10 : 0;
			val = val > 9 ? val % 10 : val;
			curr.val = val;
			
			if(curr.next == null) tail = curr;
		}
		
		if(carry > 0)
			tail.next = new ListNode(carry);
		
		head = reverse(head);
		return head;
	}

	private static ListNode reverse(ListNode head) {
		ListNode prev = null, curr = head;
		
		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private static ListNode addOne(ListNode head) {
		StringBuilder sb = new StringBuilder();
		for(ListNode curr = head; curr != null; curr = curr.next)
			sb.append(curr.val);
		
		String num = sb.toString();
		sb = new StringBuilder();
		int carry = 1;
		
		for(int i = num.length() - 1; i >= 0; i--) {
			int temp = (num.charAt(i) - '0') + carry;
			if(temp > 9) {
				carry = temp / 10;
				temp = temp % 10;
			} else carry = 0;
			sb.append(temp);
		}
		
		if(carry > 0) sb.append(carry);
		String newNum = sb.reverse().toString();
		
		ListNode newHead = new ListNode(newNum.charAt(0) - '0');
		ListNode curr = newHead;
		
		for(int i = 1; i < newNum.length(); i++) {
			curr.next = new ListNode(newNum.charAt(i) - '0');
			curr = curr.next;
		}

		return newHead;
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
		ListNode n9 = new ListNode(9);
		ListNode n10 = new ListNode(0);
		
		// [9,8,7,6,5,4,3,2,1,0]
		n1.next = n10; n2.next = n1; n3.next = n2; n4.next = n3;
		n5.next = n4; n6.next = n5; n7.next = n6; n8.next = n7;
		n9.next = n8;
		
		return n9;
	}

	private static ListNode createList2() {
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(9);
		ListNode n3 = new ListNode(9);
		ListNode n4 = new ListNode(9);
		
		n3.next = n4; n2.next = n3; n1.next = n2;
		return n1;
	}

}
