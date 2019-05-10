package uber;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class DesignHitCounter {

	public static void main(String[] args) {
		
		test1();
		test2();
		test3();
	}
	
	private static void test3() {
		HitCounter hc = new HitCounter();
		hc.hit(700);
		System.out.print(hc.getHits(900) + " ");
		System.out.println(hc.getHits(1001));
	}
	
	private static void test2() {
		HitCounter hc = new HitCounter();
		hc.hit(1);
		hc.hit(2);
		hc.hit(4);
		System.out.print(hc.getHits(4) + " ");
		hc.hit(299);
		System.out.println(hc.getHits(303));
	}

	private static void test1() {
		HitCounter hc = new HitCounter();
		hc.hit(1);
		hc.hit(2);
		hc.hit(3);
		System.out.print(hc.getHits(4) + " ");
		hc.hit(300);
		System.out.print(hc.getHits(300) + " ");
		System.out.println(hc.getHits(301));
	}

}

class HitCounter {
	private TreeMap<Integer, Integer> map = null;
	
	HitCounter() {
		map = new TreeMap<>();
	}
	
	public void hit(int t) {
		Entry<Integer, Integer> last = map.floorEntry(t);
		map.put(t, last != null ? last.getValue() + 1 : 1);
	}
	
	public int getHits(int t) {
		if(map.size() == 0) return 0;
		
		Entry<Integer, Integer> lastEntry = map.lastEntry();
		if(t - lastEntry.getKey() > 300) return 0;
		else {
			if(t <= 300)
				return lastEntry.getValue();
			
			int toIgnore = t - 300;
			Entry<Integer, Integer> ignoreEntry = map.floorEntry(toIgnore);
			if(ignoreEntry == null)
				return lastEntry.getValue();
			else
				return lastEntry.getValue() - ignoreEntry.getValue();
		}
	}
}

class HitCounter1 {
    private Queue<Integer> q = null;
    
    HitCounter1() {
        this.q = new LinkedList<>();
    }
    
    public void hit(int t) {
        q.add(t);
    }
    
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
}