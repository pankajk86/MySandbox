package linkedin;

import java.util.Stack;
import java.util.TreeMap;

public class MaxStack {
	
	private Stack<Integer> stack = null;
	private TreeMap<Integer, Integer> map = null;

	public MaxStack() {
        stack = new Stack<>();
        map = new TreeMap<>();
    }
    
    public void push(int x) {
        stack.push(x);
        map.put(x, map.getOrDefault(x, 0) + 1);
    }
    
    public int pop() {
    	int result = stack.pop();
    	if(map.get(result) > 1) 
    		map.put(result, map.get(result) - 1);
    	else
    		map.remove(result);
		return result;
    }
    
    public int top() {
		return stack.peek();
    }
    
    public int peekMax() {
    	return map.lastKey();
    }
    
    public int popMax() {
    	int result = map.lastKey();
    	if(map.get(result) > 1) 
    		map.put(result, map.get(result) - 1);
    	else
    		map.remove(result);
    	
    	Stack<Integer> temp = new Stack<>();
    	
    	while(stack.peek() != result) {
    		temp.push(stack.pop());
    	}
    	
    	stack.pop();
    	
    	while(!temp.isEmpty())
    		stack.push(temp.pop());
    	
		return result;
    }

}
