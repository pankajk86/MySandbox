package multithread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchIII {

	public static void main(String[] args) {
		CountDownLatch l1 = new CountDownLatch(1);
        CountDownLatch l2 = new CountDownLatch(1);
        
        Thread t1 = new Thread(new Thread4(l1));
        Thread t2 = new Thread(new Thread5(l1, l2));
        Thread t3 = new Thread(new Thread6(l2));
        t2.start(); t3.start(); t1.start();  
	}

}

class Thread4 implements Runnable {
    
    private CountDownLatch b;
    
    public Thread4(CountDownLatch b) {
        this.b = b;
    }
    
    public void run() {
        System.out.print("first:");
        b.countDown();
    }
}

class Thread5 implements Runnable {
    
    private CountDownLatch b, c;
    
    public Thread5(CountDownLatch b, CountDownLatch c) {
        this.b = b;
        this.c = c;
    }
    
    public void run() {
        try{
            b.await();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.print(":second:");
        c.countDown();
    }
}

class Thread6 implements Runnable {
    
    private CountDownLatch c;
    
    public Thread6(CountDownLatch c) {
        this.c = c;
    }
    
    public void run() {
        try{
            c.await();
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.print(":third");
        
    }
}