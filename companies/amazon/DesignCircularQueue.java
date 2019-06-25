package amazon;

public class DesignCircularQueue {

	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(3);
		System.out.println(circularQueue.enQueue(1));
		System.out.println(circularQueue.enQueue(2));
		System.out.println(circularQueue.enQueue(3));
		System.out.println(circularQueue.enQueue(4));
		System.out.println(circularQueue.Rear());
		System.out.println(circularQueue.isFull());
		System.out.println(circularQueue.deQueue());
		System.out.println(circularQueue.enQueue(4));
		System.out.println(circularQueue.Rear());
	}

}

class MyCircularQueue {
	private int capacity = 0;
    private int size = 0;
    private CQNode head = null, tail = null;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size < capacity) {
        	CQNode newNode = new CQNode(value);
            if(head == null) {
                head = newNode;
                tail = newNode;
                tail.next = head;
            } else {
            	
                tail.next = newNode;
                newNode.next = this.head;
                tail = newNode;
            }
            size++;
            return true;
        } else return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
    	if(size == 0) return false;
    	else {
    		if(size == 1) {
    			head = tail = null;
    		} else {
    			head = head.next;
    			tail.next = head;
    		}
    		size--;
    		return true;
    	}
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	return head != null ? head.val : -1;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	return tail != null ? tail.val : -1;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

class CQNode {
	int val;
	CQNode next;
	
	CQNode(int val) {
		this.val = val;
	}
}
