package linkedin;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DesignThreadSafeHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class ThreadSafeHashMap<K, V> {
	private int bucketCount = 1000;
	private ArrayList<LinkedList<Node>> buckets = new ArrayList<>();
	private ArrayList<Lock> bucketLocks = new ArrayList<>();
	
	public ThreadSafeHashMap() {
		for(int i = 0; i < bucketCount; i++) {
			buckets.add(null);
			bucketLocks.add(new ReentrantLock());
		}
	}
	
	public void put(K key, V value) {
		try {
			LinkedList<Node> bucket = lockAndGetBucket(key);
			for(Node node: bucket) {
				if(node.key.equals(key)) {
					node.value = value;
					return;
				}
			}
			
			bucket.add(new Node(key, value));
		} finally {
			unlockBucket(key);
		}
	}

	public V get(K key) {
		try {
			LinkedList<Node> bucket = lockAndGetBucket(key);
			for(Node node: bucket) {
				if(node.key.equals(key)) return node.value;
			}
			return null;
		} finally {
			unlockBucket(key);
		}
	}

	private LinkedList<Node> lockAndGetBucket(K key) {
		int index = Math.abs(key.hashCode() % bucketCount);
		bucketLocks.get(index).lock();
		
		LinkedList<Node> bucket = buckets.get(index);
		if(bucket == null) {
			bucket = new LinkedList<>();
			buckets.add(index, bucket);
		}
		return bucket;
	}

	private void unlockBucket(K key) {
		int index = Math.abs(key.hashCode() % bucketCount);
		bucketLocks.get(index).unlock();
	}

	class Node {
		K key; V value;

		public Node(K key, V value) {
			this.key = key; this.value = value;
		}
	}
}
