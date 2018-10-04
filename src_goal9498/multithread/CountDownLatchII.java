package multithread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchII {

	public static void main(String[] args) {
		CountDownLatch latch = new CountDownLatch(1);
		
		System.out.println("Started the main thread.");
//		new Thread(new Process1(latch, 0)).start();
		new Thread(new ProcessorII(latch, 0)).start();
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Main thread completed.");
	}

}

class ProcessorII implements Runnable {
	
	private CountDownLatch latch;
	private int id;

	public ProcessorII(CountDownLatch latch, int id) {
		this.latch = latch;
		this.id = id;
	}
	
	@Override
	public void run() {
		if(this.id < 4) {
			CountDownLatch childLatch = new CountDownLatch(1);
			int childId = this.id + 1;
			System.out.println("Processing thread: " + childId);
			new Thread(new ProcessorII(childLatch, childId)).start();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			childLatch.countDown();
			System.out.println("Completed thread: " + childId);

			try {
				childLatch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		this.latch.countDown();
	}
	
}


class Process1 implements Runnable {
	
	private CountDownLatch latch;
	private int id;

	public Process1(CountDownLatch latch, int id) {
		this.latch = latch;
		this.id = id;
	}
	
	@Override
	public void run() {
		CountDownLatch childLatch = new CountDownLatch(1);
		int childId = this.id + 1;
		System.out.println("Processing thread: " + childId);
		new Thread(new Process2(childLatch, childId)).start();
		
		try {
			childLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed thread: " + childId);
		this.latch.countDown();
	}
}


class Process2 implements Runnable {
	
	private CountDownLatch latch;
	private int id;

	public Process2(CountDownLatch latch, int id) {
		this.latch = latch;
		this.id = id;
	}

	@Override
	public void run() {
		int childId = this.id + 1;
		System.out.println("Processing thread: " + childId);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Completed thread: " + childId);
		this.latch.countDown();
	}
	
}