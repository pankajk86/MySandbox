package amazon;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class DesignLFUCache {

	public static void main(String[] args) {
		LFUCache cache = new LFUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    					// evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3.
		cache.put(4, 4);    					// evicts key 1.
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
	}

}

class LFUCache {
	
	private TreeMap<Long, Integer> timeToKeyMap = null;
	private Map<Integer, Long> keyToTimeMap = null;
	private Map<Integer, Integer> map = null;
	private int capacity = -1;
	private long inceptionTime = -1L;
	
	public LFUCache(int capacity) {
		this.timeToKeyMap = new TreeMap<>();
		this.keyToTimeMap = new HashMap<>();
		this.map = new HashMap<>();
		this.capacity = capacity;
		this.inceptionTime = System.currentTimeMillis();
	}
	
	public int get(int key) {
		if(map.containsKey(key)) {
			long currTime = System.currentTimeMillis() - inceptionTime;
			
			long keyTime = keyToTimeMap.get(key);
			timeToKeyMap.remove(keyTime);
			keyToTimeMap.put(key, currTime);
			timeToKeyMap.put(currTime, key);
			return map.get(key);
		}
        return -1;
    }
    
    public void put(int key, int value) {
    	long currTime = System.currentTimeMillis() - inceptionTime;
    	
        if(map.size() < capacity) {
        	map.put(key, value);
        	timeToKeyMap.put(currTime, key);
        	keyToTimeMap.put(key, currTime);
        } else {
        	Entry<Long, Integer> lfEntry = timeToKeyMap.firstEntry();
        	long lfTime = lfEntry.getKey();
        	int lfKey = lfEntry.getValue();
        	
        	if(key == lfKey) {
        		timeToKeyMap.remove(lfTime);
        		timeToKeyMap.put(currTime, lfKey);
        		keyToTimeMap.put(key, currTime);
        	} else {
        		map.remove(lfKey);
        		timeToKeyMap.remove(lfTime);
        		keyToTimeMap.remove(lfKey);
        		
        		timeToKeyMap.put(currTime, key);
        		keyToTimeMap.put(key, currTime);
        	}
        	map.put(key, value);
        }
    }
}
