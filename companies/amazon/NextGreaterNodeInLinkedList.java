package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import google.ListNode;

public class NextGreaterNodeInLinkedList {

	public static void main(String[] args) {
		ListNode head = createList();
		int[] result = nextLargetNodes(head);
		for(int i: result) System.out.print(i + " ");
		System.out.println();
		
		head = createList2();
		result = nextLargetNodes(head);
		for(int i: result) System.out.print(i + " ");
	}

	private static int[] nextLargetNodes(ListNode head) {
		if(head == null) return null;
		List<Integer> list = new ArrayList<>();
		for(ListNode curr = head; curr != null; curr = curr.next)
			list.add(curr.val);
		
		int n = list.size();
		int[] result = new int[n];
		Stack<Integer> stack = new Stack<>();
		stack.push(list.get(n - 1));
		
		for(int i = n - 2; i >= 0; i--) { 
			while(!stack.isEmpty() && stack.peek() <= list.get(i))
				stack.pop();
			if(!stack.isEmpty()) 
				result[i] = stack.peek();
			
			stack.push(list.get(i));
		}
		
		return result;
	}

	private static ListNode createList() {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(5);
		
		n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		return n1;
	}
	
	private static ListNode createList2() {
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(7);
		ListNode n3 = new ListNode(5);
		ListNode n4 = new ListNode(1);
		ListNode n5 = new ListNode(9);
		ListNode n6 = new ListNode(2);
		ListNode n7 = new ListNode(5);
		ListNode n8 = new ListNode(1);
		
		n7.next = n8; n6.next = n7; n5.next = n6;
		n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		return n1;
	}

}
