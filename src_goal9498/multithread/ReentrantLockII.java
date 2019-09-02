package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockII {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		SharedObj obj = new SharedObj('a');
		Condition b = lock.newCondition(), c = lock.newCondition();
		
		Thread ta = new Thread(new ThreadA(lock, obj, b));
		Thread tb = new Thread(new ThreadB(lock, obj, b, c));
		Thread tc = new Thread(new ThreadC(lock, obj, c));
		
		tc.start(); tb.start(); ta.start(); 
	}
}

class ThreadA implements Runnable {

	private Lock lock;
	private Condition b;
	private SharedObj obj;
	
	public ThreadA(Lock lock, SharedObj obj, Condition b) {
		this.lock = lock; this.obj = obj; this.b = b;
	}
	
	@Override
	public void run() {
		lock.lock();
		System.out.print("first:");
		obj.c = 'b';
		b.signal();
		lock.unlock();
	}
	
}

class ThreadB implements Runnable {

	private Lock lock;
	private Condition b, c;
	private SharedObj obj;
	
	public ThreadB(Lock lock, SharedObj obj, Condition b, Condition c) {
		this.lock = lock; this.obj = obj; this.b = b; this.c = c;
	}
	
	@Override
	public void run() {
		lock.lock();
		while(obj.c != 'b') {
			try {
				b.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print(":second:");
		obj.c = 'c';
		c.signal();
		lock.unlock();
	}
	
}

class ThreadC implements Runnable {

	private Lock lock;
	private Condition c;
	private SharedObj obj;
	
	public ThreadC(Lock lock, SharedObj obj, Condition c) {
		this.lock = lock; this.obj = obj; this.c = c;
	}
	
	@Override
	public void run() {
		lock.lock();
		while(obj.c != 'c') {
			try {
				c.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(":third");
		lock.unlock();
	}
	
}

class SharedObj {
	char c;
	public SharedObj(char c) {this.c = c;}
}