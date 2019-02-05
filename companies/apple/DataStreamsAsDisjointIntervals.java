package apple;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import facebook.Interval;

public class DataStreamsAsDisjointIntervals {

	public static void main(String[] args) {
		SummaryRanges s = new SummaryRanges();
		s.addNum(1);
		print(s.getIntervals());
		s.addNum(3);
		print(s.getIntervals());
		s.addNum(7);
		print(s.getIntervals());
		s.addNum(2);
		print(s.getIntervals());
		s.addNum(6);
		print(s.getIntervals());
	}
	
	private static void print(List<Interval> intervals) {
		for(Interval interval: intervals) {
			System.out.print(interval + " ");
		}
		System.out.println();
	}

}

class SummaryRanges {
	TreeMap<Integer, Interval> map = null;

	public SummaryRanges() {
		map = new TreeMap<>();
	}

	public void addNum(int val) {
		if (map.containsKey(val))
			return;

		Integer low = map.lowerKey(val);
		Integer high = map.higherKey(val);

		// if adjacent lower and upper bound for the new val is found
		if (low != null && high != null && map.get(low).end + 1 == val && val + 1 == high) {
			map.get(low).end = map.get(high).end;
			map.remove(high);
		} else if(low != null && map.get(low).end + 1 >= val) { // if lower bound is found
			map.get(low).end = Math.max(map.get(low).end, val);
		} else if(high != null && val + 1 == high) { // if upper bound is found
			map.put(val, new Interval(val, map.get(high).end));
			map.remove(high);
		} else map.put(val, new Interval(val, val));
	}

	public List<Interval> getIntervals() {
		return new ArrayList<>(map.values());
	}
}
