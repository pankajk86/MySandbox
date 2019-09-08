package linkedin;

import java.util.Stack;

public class DesignBetterMaxStack {

	public static void main(String[] args) {
		MyMaxStackIII ms = new MyMaxStackIII();
		ms.push(5); ms.push(1); ms.push(5);
		System.out.println(ms.top());
		System.out.println(ms.popMax());
		System.out.println(ms.top());
		System.out.println(ms.peekMax());
		System.out.println(ms.pop());
		System.out.println(ms.top());
	}
}

class MyMaxStackIII {
	
	private Stack<Integer> stack;
	private Stack<Integer> maxStack;
	
	public MyMaxStackIII() {
		this.stack = new Stack<>(); this.maxStack = new Stack<>();
	}
	
	public void push(int x) {
		pushHelper(x);
    }
    
    private void pushHelper(int x) {
    	int max = maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
    	if(x > max) max = x;
    	stack.push(x); maxStack.push(max);
	}

	public int pop() {
		maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> temp = new Stack<>();
        
        while(stack.peek() != max) {
        	temp.push(stack.pop());
        	maxStack.pop();
        }
        
        stack.pop(); maxStack.pop();
        while(!temp.isEmpty())
        	pushHelper(temp.pop());
        
        return max;
    } 
}