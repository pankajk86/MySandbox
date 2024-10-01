package linkedin;

import java.util.PriorityQueue;

public class MaxStack {

	private DllNode head, tail;
	private int count;
	private PriorityQueue<DllNode> pq;

	public MaxStack() {
		head = new DllNode(-1);
		tail = new DllNode(-1);
		head.next = tail;
		tail.prev = head;
		count = 0;
		pq = new PriorityQueue<>((a, b) -> a.val != b.val ? b.val - a.val : b.id - a.id);
	}

	public void push(int x) {
		DllNode temp = new DllNode(x);
		temp.id = count++;
		addHead(temp);
		pq.add(temp);
	}

	public int pop() {
		if (pq.isEmpty()) return -1;
		DllNode temp = head.next;
		pq.remove(temp);
		head.next = temp.next;
		temp.next.prev = head;
		return temp.val;
	}

	public int top() {
		return head.next.val;
	}

	public int peekMax() {
		return pq.peek().val;
	}

	public int popMax() {
		DllNode temp = pq.poll();
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		return temp.val;
	}

	private void addHead(DllNode node) {
		node.next= head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
	}

}

class DllNode {
	int id, val;
	DllNode prev, next;

	public DllNode(int val) {
		this.val = val;
	}
}