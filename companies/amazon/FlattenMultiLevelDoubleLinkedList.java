package amazon;

import java.util.Stack;

public class FlattenMultiLevelDoubleLinkedList {

	public static void main(String[] args) {
		Node head = createList();
		Node result = flatten(head);
		System.out.println(result);
	}

	private static Node flatten(Node head) {
		Stack<Node> stack = new Stack<>();
		
		for(Node curr = head; curr != null; curr = curr.next) {
			if(curr.child != null) {
				stack.push(curr.next);
				curr.next = curr.child;
				if(curr.next != null) curr.next.prev = curr;
				curr.child = null;
			} else if(curr.next == null && !stack.isEmpty()) {
				curr.next = stack.pop();
				if(curr.next != null) curr.next.prev = curr;
			}
		}
		
		return head;
	}



	private static Node createList() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		
		n11.next = n12; 
		n9.next = n10; n8.next = n9; n7.next = n8;
		n5.next = n6; n4.next = n5; n3.next = n4; n2.next = n3; n1.next = n2;
		
		n12.prev = n11; 
		n10.prev = n9; n9.prev = n8; n8.prev = n7;
		n6.prev = n5; n5.prev = n4; n4.prev = n3; n3.prev = n2; n2.prev = n1;
		
		n8.child = n11; n3.child = n7;
		
		return n1;
	}

}

class Node {
	int val;
	Node next, prev, child;
	
	Node(int val) {
		this.val = val;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
        
        for(Node curr = this; curr != null; curr = curr.next) {
            sb.append(curr.val).append(curr.next != null ? "->" : "");
        }
        
        return sb.toString();
	}
}