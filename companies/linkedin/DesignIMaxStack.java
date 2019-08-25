package linkedin;

import java.util.Stack;

public class DesignIMaxStack {

	public static void main(String[] args) {
		MyMaxStack ms = new MyMaxStack();
		ms.push(5); ms.push(1); ms.push(5);
		System.out.println(ms.top());
		System.out.println(ms.popMax());
		System.out.println(ms.top());
		System.out.println(ms.peekMax());
		System.out.println(ms.pop());
		System.out.println(ms.top());
	}

}

class MyMaxStack {
	
	private Stack<Integer> s1, s2;
	
	public MyMaxStack() {
        s1 = new Stack<>(); s2 = new Stack<>();
    }
    
    public void push(int x) {
    	s1.push(x);
    }
    
    public int pop() {
    	return s1.pop();
    }
    
    public int top() {
    	return s1.peek();
    }
    
    public int peekMax() {
    	int max = Integer.MIN_VALUE;
    	
    	while(!s1.isEmpty()) {
    		int curr = s1.pop();
    		max = Math.max(max, curr);
    		s2.push(curr);
    	}
    	
    	while(!s2.isEmpty())
    		s1.push(s2.pop());
    	
    	return max;
    }
    
    public int popMax() {
    	int max = Integer.MIN_VALUE;
    	boolean flag = true;
    	
    	while(!s1.isEmpty()) {
    		int curr = s1.pop();
    		max = Math.max(max, curr);
    		s2.push(curr);
    	}
    	
    	while(!s2.isEmpty()) {
    		s1.push(s2.pop());
    		if(flag && s1.peek() == max) {
				s1.pop();
				flag = false;
    		}
    	}
    	
    	return max;
    }
}
