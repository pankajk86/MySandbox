package multithread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockIII {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		Condition a = lock.newCondition(), b = lock.newCondition(), c = lock.newCondition();
		SharedObj obj = new SharedObj('a');
		
		Thread t1 = new Thread(new Thread7(lock, a, b, obj));
		Thread t2 = new Thread(new Thread8(lock, b, c, obj));
		Thread t3 = new Thread(new Thread9(lock, a, c, obj));
		
		t2.start(); t1.start(); t3.start(); 
	}

}


class Thread7 implements Runnable {
    private Lock lock;
    private Condition a, b;
    private SharedObj obj;
    
    public Thread7(Lock lock, Condition a, Condition b, SharedObj obj) {
        this.lock = lock; this.a = a; this.b = b; this.obj = obj;
    }
    
    public void run() {
    	for(int i = 0; i < 5; i++) {
    		lock.lock();
        	while(obj.c != 'a')
    			try {
    				a.await();
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
            System.out.print("first:");
            
            obj.c = 'b';
            b.signal();
            lock.unlock();
    	}
    	
    }
}

class Thread8 implements Runnable {
	private Lock lock;
    private Condition b, c;
    private SharedObj obj;
    
    public Thread8(Lock lock, Condition b, Condition c, SharedObj obj) {
        this.lock = lock; this.b = b; this.c = c; this.obj = obj;
    }
    
    public void run() {
    	
    	for(int i = 0; i < 5; i++) {
    		lock.lock();
    		while(obj.c != 'b')
    			try {
    				b.await();
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    		System.out.print(":second:");
    		
    		obj.c = 'c';
    		c.signal();
    		lock.unlock();
    	}
    }
}

class Thread9 implements Runnable {
	private Lock lock;
    private Condition a, c;
    private SharedObj obj;
    
    public Thread9(Lock lock, Condition a, Condition c, SharedObj obj) {
        this.lock = lock; this.a = a; this.c = c; this.obj = obj;
    }
    
    public void run() {
    	for(int i = 0; i < 5; i++) {
    		lock.lock();
    		while(obj.c != 'c')
    			try {
    				c.await();
    			} catch (InterruptedException e) {
    				e.printStackTrace();
    			}
    		System.out.print(":third\n");
    		
    		obj.c = 'a';
    		a.signal();
    		lock.unlock();
    	}
    }
}
