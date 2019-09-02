package multithread;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockIV_ProducerMultipleConsumer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ProducerI implements Runnable {
	
	private List<Queue<Integer>> qList;
	private List<ReentrantLock> lock;
	private List<Condition> prod, con;
	private int capacity;
	
	ProducerI(List<Queue<Integer>> q, List<ReentrantLock> lock, List<Condition> prod, List<Condition> con, int capacity) {
		this.qList = q;
		this.lock = lock;
		this.prod = prod;
		this.con = con;
		this.capacity = capacity;
	}
	
	@Override
	public void run() {
		
//		for(int i = 0; i < capacity; i++) {
//			lock.lock();
//			while(q.size() == capacity)
//				try {
//					prod.await();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			System.out.println("Thread: " + Thread.currentThread().getName() + ", Produced: " + i);
//			q.add(i);
//			con.signal();
//			lock.unlock();
//			
//			try {
//				Thread.sleep(500); // to flex the producer frequency.
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}

class ConsumerI implements Runnable {

	private int capacity;
	private Queue<Integer> q;
	private ReentrantLock lock;
	private Condition prod, con;
	
	public ConsumerI(Queue<Integer> q, ReentrantLock lock, Condition prod, Condition con, int capacity) {
		this.q = q; this.lock = lock; this.prod = prod; this.con = con; this.capacity = capacity;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < capacity; i++) {
			try {
				lock.lock();
				while(q.size() == 0)
					try {
						con.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				System.out.println("Thread: " + Thread.currentThread().getName() + ", Consumed: " + q.remove());
				prod.signal();
			} finally {
				lock.unlock();
			}
		}
	}
	
}
