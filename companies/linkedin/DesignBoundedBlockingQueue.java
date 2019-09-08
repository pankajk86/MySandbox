package linkedin;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DesignBoundedBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class BoundedBlockingQueue {
	private int capacity, currSize;
	private Lock lock, writeLock;
	private Condition notEmpty, notFull;
	private List<Object> list;
	
	public BoundedBlockingQueue(int capacity) {
		this.capacity = capacity;
		this.lock = new ReentrantLock();
		this.writeLock = new ReentrantLock();
		this.notEmpty = lock.newCondition();
		this.notFull = lock.newCondition();
		this.list = new LinkedList<>();
	}
	
	public Object get() {
		try {
			lock.lock();
			while(currSize <= 0)
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			currSize--;
			notFull.signal();
			return list.remove(0);
		} finally {
			lock.unlock();
		}
	}
	
	public void put(Object o) {
		try {
			lock.lock();
			writeLock.lock();
			while(currSize >= capacity) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			currSize++;
			list.add(o);
			notEmpty.signal();
		} finally {
			writeLock.lock();
			lock.unlock();
		}
	}
	
	public void multiPut(List<Object> list) {
		try {
			lock.lock();
			writeLock.lock();
			
			for(Object o: list) {
				while(currSize >= capacity) {
					try {
						notFull.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				currSize++;
				this.list.add(o);
				notEmpty.signal();
			}
		} finally {
			writeLock.lock();
			lock.unlock();
		}
	}	
}