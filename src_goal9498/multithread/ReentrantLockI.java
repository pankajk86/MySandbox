package multithread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockI {
	
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition prod = lock.newCondition();
		Condition con = lock.newCondition();
		
		Queue<Integer> q = new LinkedList<>();
		int capacity = 10;
		
		Thread producer = new Thread(new Producer(q, lock, prod, con, capacity), "Producer");
		Thread consumer = new Thread(new Consumer(q, lock, prod, con, capacity), "Consumer");
		
		producer.start(); consumer.start();
	}

}

class Producer implements Runnable {
	
	private Queue<Integer> q;
	private ReentrantLock lock;
	private Condition prod, con;
	private int capacity;
	
	Producer(Queue<Integer> q, ReentrantLock lock, Condition prod, Condition con, int capacity) {
		this.q = q;
		this.lock = lock;
		this.prod = prod;
		this.con = con;
		this.capacity = capacity;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < capacity; i++) {
			lock.lock();
			while(q.size() == capacity)
				try {
					prod.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			System.out.println("Thread: " + Thread.currentThread().getName() + ", Produced: " + i);
			q.add(i);
			con.signal();
			lock.unlock();
			
			try {
				Thread.sleep(500); // to flex the producer frequency.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private Queue<Integer> q;
	private ReentrantLock lock;
	private Condition prod, con;
	private int capacity;
	
	Consumer(Queue<Integer> q, ReentrantLock lock, Condition prod, Condition con, int capacity) {
		this.q = q;
		this.lock = lock;
		this.prod = prod;
		this.con = con;
		this.capacity = capacity;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < capacity; i++) {
			lock.lock();
			while(q.size() == 0)
				try {
					con.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			System.out.println("Thread: " + Thread.currentThread().getName() + ", Consumed: " + q.remove());
			prod.signal();
			lock.unlock();
			
			try {
				Thread.sleep(1000);	 // to flex the consumer frequency.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
