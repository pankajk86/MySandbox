package google;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore {

	public static void main(String[] args) {
		System.out.println("======Test1======");
		test1();
		System.out.println("======Test2======");
		test2();
	}

	private static void test1() {
		TimeMap tmap = new TimeMap();
		tmap.set("foo", "bar", 1);
		System.out.println(tmap.get("foo", 1));
		System.out.println(tmap.get("foo", 3));
		
		tmap.set("foo", "bar2", 4);
		System.out.println(tmap.get("foo", 4));
		System.out.println(tmap.get("foo", 5));
	}

	private static void test2() {
		TimeMap tmap = new TimeMap();
		tmap.set("love", "high", 10);
		tmap.set("love", "low", 20);
		System.out.println(tmap.get("love", 5));
		System.out.println(tmap.get("love", 10));
		System.out.println(tmap.get("love", 15));
		System.out.println(tmap.get("love", 20));
		System.out.println(tmap.get("love", 25));
	}
}

class TimeMap {
	
	private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> tmap = map.getOrDefault(key, new TreeMap<>());
        tmap.put(timestamp, value);
        map.put(key, tmap);
    }
    
    public String get(String key, int timestamp) {
    	if(map.containsKey(key)) {
    		TreeMap<Integer, String> tmap = map.get(key);
    		Map.Entry<Integer, String> entry = tmap.floorEntry(timestamp);
    		return entry == null ? "" : entry.getValue();
    	}
        return null;
    }
}
