package amazon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopTenItemsInLast24hours {

	public static void main(String[] args) {
		long start = System.currentTimeMillis() / 1000;
		long oneSec = 1000;
		
		TrendingItemAnalyzer tia = new TrendingItemAnalyzer(5L);
		tia.order("u1", "i1", start);
		tia.order("u1", "i2", start + (1 * oneSec));
		tia.order("u1", "i3", start + (2 * oneSec));
		tia.order("u1", "i2", start + (1 * oneSec));
		tia.order("u2", "i3", start + (5 * oneSec));
		tia.order("u2", "i1", start + (2 * oneSec));
		tia.order("u2", "i2", start + (4 * oneSec));
		tia.order("u3", "i2", start + (1 * oneSec));
		tia.order("u3", "i1", start + (6 * oneSec));
		tia.order("u1", "i3", start + (2 * oneSec));
		tia.order("u2", "i4", start + (1 * oneSec));
		tia.order("u3", "i1", start + (3 * oneSec));
		tia.order("u2", "i3", start + (1 * oneSec));
		tia.order("u1", "i4", start + (3 * oneSec));
		
		long current = start + (6 * oneSec);
		System.out.println(tia.getTopItems(3, current));
	}

}

class TrendingItemAnalyzer {
	
	private TreeMap<Long, Map<String, Long>> map = null;
	private long timeRange = 0L; // in last n seconds
	
	public TrendingItemAnalyzer(long timeRange) {
		this.timeRange = timeRange;
		this.map = new TreeMap<Long, Map<String, Long>>(new Comparator<Long>() {
			@Override
			public int compare(Long t1, Long t2) {
				if(t1 > t2) return -1;
				else if(t1 < t2) return 1;
				return 0;
			}
		});
	}
	
	public void order(String userId, String itemId, long timestamp) {
		Map<String, Long> imap = map.getOrDefault(timestamp, new HashMap<>());
		imap.put(itemId, imap.getOrDefault(itemId, 0L) + 1);
		map.put(timestamp, imap);
		
		if(map.size() > timeRange) {
			map.remove(map.lastKey());
		}
	}
	
	public List<String> getTopItems(int m, long currentTime) { // top m items from the given current time
		List<String> result = new ArrayList<>();
		Map<String, Long> amap = new HashMap<>();
		
		PriorityQueue<ItemObj> pq = new PriorityQueue<>(new Comparator<ItemObj>() {
			@Override
			public int compare(ItemObj i1, ItemObj i2) {
				if(i1.count < i2.count) return -1;
				else if(i1.count > i2.count) return 1;
				return 0;
			}
		});
		
		System.out.println("Current time: " + currentTime);
		
		for(Map.Entry<Long, Map<String, Long>> entry: map.entrySet()) {
			for(Map.Entry<String, Long> ientry: entry.getValue().entrySet()) {
				amap.put(ientry.getKey(), amap.getOrDefault(ientry.getKey(), 0L) + ientry.getValue());
			}
		}
		
		for(Map.Entry<String, Long> entry: amap.entrySet()) {
			pq.add(new ItemObj(entry.getKey(), entry.getValue()));
			if(pq.size() == m) pq.poll();
		}
		
		while(!pq.isEmpty())
			result.add(0, pq.poll().itemId);
		
		return result;
	}
	
}

class ItemObj {
	String itemId;
	long count;
	
	ItemObj(String itemId, long count) {
		this.itemId = itemId;
		this.count = count;
	}
}
