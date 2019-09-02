package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// not complete
public class ReentrantLockIIWithH2O {

	public static void main(String[] args) {
		
		ReentrantLock lock = new ReentrantLock();
		Condition hc = lock.newCondition();
		Condition oc = lock.newCondition();
		
		Thread th = new Thread(new HydrogenII(lock, hc, oc));
		Thread to = new Thread(new OxygenII(lock, hc, oc));
		
		th.start(); to.start();
	}

}

class HydrogenII implements Runnable {

	private ReentrantLock lock;
	private Condition hc, oc;
	private int count;
	
	public HydrogenII(ReentrantLock lock, Condition hc, Condition oc) {
		this.lock = lock; this.hc = hc; this.oc = oc;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 4; i++) {
			if(count < 2) {
				lock.lock();
				System.out.print("H");
				count++;
			} else {
				try {
					hc.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count = 0;
				oc.signal();
				lock.unlock(); lock.unlock();
			}
		}
	}	
}

class OxygenII implements Runnable {

	private ReentrantLock lock;
	private Condition hc, oc;
	private int count;
	
	public OxygenII(ReentrantLock lock, Condition hc, Condition oc) {
		this.lock = lock; this.hc = hc; this.oc = oc;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 2; i++) {
			if(count == 0) {
				lock.lock();
				System.out.print("O");
				count++;
			} else {
				try {
					oc.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count = 0;
				hc.signal();
				lock.unlock();
			}
		}
	}	
}
