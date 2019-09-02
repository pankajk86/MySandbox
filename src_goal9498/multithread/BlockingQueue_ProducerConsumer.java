package multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueue_ProducerConsumer {

	public static void main(String[] args) {
		BlockingQueue<Integer> q = new ArrayBlockingQueue<>(10);
		Thread producer = new Thread(new ProducerBQ(q));
		Thread consumer = new Thread(new ConsumerBQ(q));
		
		producer.start(); consumer.start();
	}

}


class ProducerBQ implements Runnable {

	private int i;
	private BlockingQueue<Integer> q;
	
	public ProducerBQ(BlockingQueue<Integer> q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		while(true) {
			System.out.println("Produced: " + i);
			q.add(i++);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ConsumerBQ implements Runnable {
	private BlockingQueue<Integer> q;
	
	public ConsumerBQ(BlockingQueue<Integer> q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println("Consumed: " + q.take());
				Thread.sleep(700);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
