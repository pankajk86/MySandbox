package multithread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchI {

	private static final int CD_LATCH_COUNT = 3;
	private static final int THREAD_COUNT = 4;
	
	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(CD_LATCH_COUNT);
		ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
		
		for(int i = 0; i < THREAD_COUNT; i++) {
			executor.submit(new Processor(latch, (i + 1)));
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed");
	}

}

class Processor implements Runnable {
	
	private CountDownLatch latch;
	private int id;
	
	public Processor(CountDownLatch latch, int id) {
		this.latch = latch;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("Started " + this.id + ": " + System.currentTimeMillis());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.latch.countDown();
	}
	
}
