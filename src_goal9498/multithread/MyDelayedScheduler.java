package multithread;

import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyDelayedScheduler implements DelayedScheduler {
	
	private PriorityQueue<Item> pq = new PriorityQueue<>();
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	public MyDelayedScheduler() {
		new Thread(new BackgroundProcessor()).start();
	}

	@Override
	public void delayedRun(long timeToRunFromNowMillis, Runnable task) {
		try {
			lock.lock();
			pq.add(new Item(timeToRunFromNowMillis, task));
			cond.signal();
		} finally {
			lock.unlock();
		}
	}

	// Inner class to keep checking for the tasks to be executed.
	class BackgroundProcessor implements Runnable {
		@Override
		public void run() {
			while(true) {
				try {
					lock.lock();
					if(pq.isEmpty())
						cond.await();
					else {
						Item item = pq.peek();
						long currTime = System.currentTimeMillis();
						if(item.timeToRun <= currTime) {
							item.task.run();
							pq.poll();
						} else cond.await(item.timeToRun - currTime, TimeUnit.MILLISECONDS);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}
		}	
	}
}


interface DelayedScheduler {
	void delayedRun(long timeToRunFromNowMillis, Runnable task);
}

class Item {
	long timeToRun;
	Runnable task;
	
	Item(long timeToRun, Runnable task) {
		this.timeToRun = timeToRun;
		this.task = task;
	}
}