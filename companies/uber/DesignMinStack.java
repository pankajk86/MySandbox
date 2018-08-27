package uber;

import java.util.PriorityQueue;
import java.util.Stack;

public class DesignMinStack {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}

}

class MinStack {
	
	private Stack<Integer> stack;
	private PriorityQueue<Integer> pq;
	
	public MinStack() {
		stack = new Stack<>();
		pq = new PriorityQueue<>();
	}
	
	public void push(int x) {
		stack.push(x);
		pq.add(x);
	}
	
	public void pop() {
		int current = stack.pop();
		if(pq.peek() == current) pq.poll();
	}
	
	public int top() {
		return stack.peek();
	}
	
	public int getMin() {
		return pq.peek();
	}
}
