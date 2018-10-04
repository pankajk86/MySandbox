package consistent.hash;

import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<T extends Server> {
	
	private final HashFunction hashFunction;
	private final int numReplicas;
	private final SortedMap<Integer, T> hashRing = new TreeMap<>();
	
	public ConsistentHash(HashFunction hashFunction, int numReplicas, List<T> servers) {
		this.hashFunction = hashFunction;
		this.numReplicas = numReplicas;
		
		for(T server: servers)
			add(server);
	}

	public void add(T server) {
		for(int i = 0; i < numReplicas; i++) {
			int hash = this.hashFunction.hash(server.getName() + i);
			hashRing.put(hash, server);
		}
	}
	
	public void remove(T server) {
		for(int i = 0; i < numReplicas; i++) {
			int hash = this.hashFunction.hash(server.getName() + i);
			hashRing.remove(hash);
		}
	}
	
	public T get(Object key) {
		if(hashRing.isEmpty())
			return null;
		
		int hash = this.hashFunction.hash(key);
		
		if(!hashRing.containsKey(hash)) {
			SortedMap<Integer, T> tailMap = hashRing.tailMap(hash);
			hash = tailMap.isEmpty() ? hashRing.firstKey() : tailMap.firstKey();
		}
		
		return hashRing.get(hash);
	}
	
	public int size() {
		return this.hashRing.size();
	}
	
}
