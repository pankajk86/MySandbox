package linkedin;

import java.util.concurrent.locks.LockSupport;

public class SingleProducerQueueChannel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 *  _ _ _ _ _ _
 *  0 1 2 3 4 5    // head: 0, tail: 5 
 *  
 */
class Channel {
	private Object[] items;
	private Thread producer, consumer;
	private volatile int head, tail;
	private int size;
	
	public Channel(int capacity, Thread producer, Thread consumer) {
		this.items = new Object[capacity];
		this.producer = producer; this.consumer = consumer;
		this.size = capacity;
	}
	
	public void put(Object item) {
		while(head == (tail + 1) % size) {
			LockSupport.park();
		}
		items[tail] = item;
		tail = (tail + 1) % size;
		if(tail == (head + 1) % size)
			LockSupport.unpark(consumer);
	}
	
	public Object get() {
		while(head == tail) {
			LockSupport.park();
		}
		
		Object item = items[head];
		head = (head + 1) % size;
		if(head == (tail + 2) % size)
			LockSupport.unpark(producer);
		return item;
	}
}
