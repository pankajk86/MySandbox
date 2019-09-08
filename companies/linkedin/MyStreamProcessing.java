package linkedin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyStreamProcessing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MyWindow {

	private ConcurrentHashMap<Long, Msg> map = new ConcurrentHashMap<>();
	private Queue<SNode> q = new LinkedList<>();
	private long oldestTS;
	private long sum, capacity;
	private int count;

	private ReadWriteLock rwLock;
	private Lock readLock, writeLock;

	MyWindow(int nMicrosecs) {
		this.capacity = nMicrosecs * 1000000 * 300; // for 5 minutes
		this.rwLock = new ReentrantReadWriteLock();
		readLock = rwLock.readLock();
		writeLock = rwLock.writeLock();
		oldestTS = System.currentTimeMillis();
	}

	public void addMsg(Msg m) {
		try {
			readLock.lock();
			writeLock.lock();
			long currTime = System.currentTimeMillis();

			while (q.size() > capacity) {
				SNode node = q.poll();
				if (node != null) {
					map.remove(node.message.key);
					sum -= node.message.value;
					count--;
				}
			}

			oldestTS = q.peek().timestamp;
			q.add(new SNode(currTime, m));
			map.put(m.key, m);
			sum += m.value;
			count++;

		} finally {
			writeLock.unlock();
			readLock.unlock();
		}
	}

	public Msg getMsg(long key) {
		try {
			readLock.lock();
			return map.get(key);
		} finally {
			readLock.unlock();
		}
	}

	public Double getAvg() {
		try {
			writeLock.lock();
			return (double) (sum / count);
		} finally {
			writeLock.unlock();
		}
	}
}

class SNode {
	long timestamp;
	Msg message;

	SNode(long timestamp, Msg message) {
		this.timestamp = timestamp;
		this.message = message;
	}
}

class Msg {
	long key, value;

	Msg(long key, long value) {
		this.key = key;
		this.value = value;
	}
}