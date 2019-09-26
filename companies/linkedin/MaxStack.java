package linkedin;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStack {

	private DllNode head, tail;
	private TreeMap<Integer, List<DllNode>> map;
	
	public MaxStack() {
        this.head = new DllNode(0);
        this.tail = new DllNode(0);
        head.prev = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }
    
    public void push(int x) {
    	DllNode node = new DllNode(x);
    	node.prev = tail.prev;
    	node.next = tail;
    	tail.prev.next = node;
    	tail.prev = node;
    	
    	if(!map.containsKey(x)) map.put(x, new ArrayList<>());
    	map.get(x).add(node);
    }
    
    public int pop() {
    	int val = tail.prev.val;
    	remove(tail.prev);
    	int size = map.get(val).size();
    	map.get(val).remove(size - 1);
    	if(map.get(val).size() == 0) map.remove(val);
    	
    	return val;
    }
    
    private void remove(DllNode node) {
    	DllNode next = node.next;
    	DllNode prev = node.prev;
    	next.prev = prev;
    	prev.next = next;
	}

	public int top() {
		return tail.prev.val;
    }
    
    public int peekMax() {
    	return map.lastKey();
    }
    
    public int popMax() {
    	int val = map.lastKey();
    	int size = map.get(val).size();
    	DllNode node = map.get(val).remove(size - 1);
    	remove(node);
    	if(map.get(val).size() == 0) map.remove(val);
    	
    	return val;
    }

}

class DllNode {
	int val;
	DllNode next, prev;
	
	DllNode(int val) {
		this.val = val;
		this.next = null; this.prev = null;
	}
}