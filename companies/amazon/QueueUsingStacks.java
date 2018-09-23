package amazon;

import java.util.Stack;

public class QueueUsingStacks {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		queue.push(1);
		queue.push(2);
		System.out.println(queue.peek());
		System.out.println(queue.pop());
		System.out.println(queue.empty());
	}

}


class MyQueue {
	private Stack<Integer> stack1 = null;
	private Stack<Integer> stack2 = null;
	
	public MyQueue() {
		this.stack1 = new Stack<>();
		this.stack2 = new Stack<>();
	}
	
	public void push(int x) {
		stack1.push(x);
	}
	
	public int pop() {
		int result = 0;
		while(!stack1.isEmpty()) stack2.push(stack1.pop());
		result = stack2.pop();
		while(!stack2.isEmpty()) stack1.push(stack2.pop());
		return result;
	}
	
	public int peek() {
		int result = 0;
		while(!stack1.isEmpty()) stack2.push(stack1.pop());
		result = stack2.peek();
		while(!stack2.isEmpty()) stack1.push(stack2.pop());
		return result;
	}
	
	public boolean empty() {
		return stack1.size() == 0;
	}
}
