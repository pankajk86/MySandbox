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
		
		Thread producer = new Thread(new Producer(q, lock, prod, con), "Producer");
		Thread consumer = new Thread(new Consumer(q, lock, prod, con), "Consumer");
		
		producer.start(); consumer.start();
	}

}

class Producer implements Runnable {
	private int MAX_CAPACITY = 10;
	
	private Queue<Integer> q;
	private ReentrantLock lock;
	private Condition prod, con;
	
	Producer(Queue<Integer> q, ReentrantLock lock, Condition prod, Condition con) {
		this.q = q;
		this.lock = lock;
		this.prod = prod;
		this.con = con;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < MAX_CAPACITY; i++) {
			lock.lock();
			while(q.size() == MAX_CAPACITY)
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
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Consumer implements Runnable {
	private Queue<Integer> q;
	private ReentrantLock lock;
	private Condition prod, con;
	
	Consumer(Queue<Integer> q, ReentrantLock lock, Condition prod, Condition con) {
		this.q = q;
		this.lock = lock;
		this.prod = prod;
		this.con = con;
	}
	
	@Override
	public void run() {
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
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
