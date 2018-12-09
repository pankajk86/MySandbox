package microsoft;

import google.ListNode;

public class AddTwoNumbersII {

	public static void main(String[] args) {
		ListNode l1 = createList1();
		ListNode l2 = createList2();
		ListNode result = sum(l1, l2);
		
		while(result.next != null) {
			System.out.print(result.val);
			result = result.next;
		}
		System.out.print(result.val);
	}

	private static ListNode sum(ListNode l1, ListNode l2) {
		String s1 = getNumStr(l1), s2 = getNumStr(l2);
		int carry = 0, i1 = 0, i2 = 0;
		StringBuilder sb = new StringBuilder();
		
		while(i1 < s1.length() && i2 < s2.length()) {
			int sum = (s1.charAt(i1) - '0') + (s2.charAt(i2) - '0') + carry;
			if(sum > 9) {
				carry = 1; 
				sum %= 10;
			} else carry = 0;
			sb.append(sum);
			i1++; i2++;
		}
		
		while(i1 < s1.length()) {
			int sum = (s1.charAt(i1) - '0') + carry;
			if(sum > 9) {
				carry = 1; 
				sum %= 10;
			} else carry = 0;
			sb.append(sum);
			i1++;
		}
		
		while(i2 < s2.length()) {
			int sum = (s2.charAt(i2) - '0') + carry;
			if(sum > 9) {
				carry = 1; 
				sum %= 10;
			} else carry = 0;
			sb.append(sum);
			i2++;
		}
		
		if(carry == 1) sb.append(carry);
		String total = sb.reverse().toString();
		
		ListNode head = new ListNode(total.charAt(0) - '0');
		ListNode result = head;
		
		for(int i = 1; i < total.length(); i++) {
			ListNode next = new ListNode(total.charAt(i) - '0');
			head.next = next;
			head = head.next;
		}
		
		return result;
	}
	
	private static String getNumStr(ListNode l) {
		StringBuilder sb = new StringBuilder();
		
		while(l.next != null) {
			sb.append(l.val);
			l = l.next;
		}
		
		sb.append(l.val);
		return sb.reverse().toString();
	}

	private static ListNode createList1() {

		ListNode n1 = new ListNode(7);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(3);
 
		n3.next = n4; 
		n2.next = n3;
		n1.next = n2;
		return n1;
	}
	
	private static ListNode createList2() {
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(4);
		
		n6.next = n7;
		n5.next = n6;
		return n5;
	}

}
