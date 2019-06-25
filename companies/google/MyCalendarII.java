package google;

import java.util.Map.Entry;
import java.util.TreeMap;

public class MyCalendarII {

	public static void main(String[] args) {
		MyCalendarTwo mct = new MyCalendarTwo();
		System.out.println(mct.book(10, 20));
		System.out.println(mct.book(50, 60));
		System.out.println(mct.book(10, 40));
		System.out.println(mct.book(5, 15));
		System.out.println(mct.book(5, 10));
		System.out.println(mct.book(25, 55));
	}

}

class MyCalendarTwo {
	
	private TreeMap<Integer, Integer> map;
	
	public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
    	
    	map.put(start, map.getOrDefault(start, 0) + 1);
    	map.put(end, map.getOrDefault(end, 0) - 1);
    	int count = 0;
    	
    	for(Entry<Integer, Integer> entry: map.entrySet()) {
    		count += entry.getValue();
    		
    		if(count > 2) {
    			map.put(start, map.get(start) - 1);
    			if(map.get(start) == 0) map.remove(start);
    			map.put(end, map.get(end) + 1);
    			if(map.get(end) == 0) map.remove(end);
    			return false;
    		}
    	}
        return true;
    }
}
