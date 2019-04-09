package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		List<Interval> intervals = createIntervals1();
		Interval newInterval = new Interval(4, 8);
		
		List<Interval> result = insert(intervals, newInterval);
		System.out.println(result);
		
		intervals = createIntervals2();
		newInterval = new Interval(9, 15);
		
		result = insert(intervals, newInterval);
		System.out.println(result);
	}

	private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals == null || intervals.size() == 0) 
			return Arrays.asList(newInterval);
		
		if(newInterval == null) return intervals;
		
		List<Interval> merged = new ArrayList<>(intervals);
		merged.add(newInterval);
		
		Collections.sort(merged, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if(i1.start < i2.start) return -1;
				else if(i1.start > i2.start) return 1;
				else {
					if(i1.end < i2.end) return -1;
					else if(i1.end > i2.end) return 1;
					else return 0;
				}
			}
		});
		
		List<Interval> result = new ArrayList<>();
		int start = merged.get(0).start, end = merged.get(0).end;
		
		for(Interval curr: merged) {
			if(curr.start <= end)
				end = Math.max(curr.end, end);
			else {
				result.add(new Interval(start, end));
				start = curr.start;
				end = curr.end;
			}
		}
		
		result.add(new Interval(start, end));
		return result;
	}

	private static List<Interval> createIntervals1() {
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 5);
		Interval i3 = new Interval(6, 7);
		Interval i4 = new Interval(8, 10);
		Interval i5 = new Interval(12, 16);
		
		return Arrays.asList(i1, i2, i3, i4, i5);
	}

	private static List<Interval> createIntervals2() {
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 4);
		Interval i3 = new Interval(3, 5);
		
		return Arrays.asList(i1, i2, i3);
	}
	
}
