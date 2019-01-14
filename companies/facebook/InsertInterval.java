package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		List<Interval> intervals = createIntervals();
		Interval newInterval = new Interval(4, 8);
		
		List<Interval> result = insert(intervals, newInterval);
		
		for(Interval interval: result)
			System.out.println(interval.start + ", " + interval.end);
	}

	private static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(newInterval == null) return intervals;
		
		if(newInterval.end < intervals.get(0).start) {
			intervals.add(0, newInterval);
			return intervals;
		}
		
		int size = intervals.size();
		if(newInterval.start > intervals.get(size - 1).end) {
			intervals.add(size, newInterval);
			return intervals;
		}
		
		int start = 0, end = 0;
		
		for(int i = 0; i < size; i++) {
			if(newInterval.start >= intervals.get(i).start && newInterval.start <= intervals.get(i).end) {
				start = i; break;
			}
		}
		
		for(int i = start; i < size; i++) {
			if(newInterval.end >= intervals.get(i).start && newInterval.end <= intervals.get(i).end) {
				end = i; break;
			}
		}
		
		int startI = start, endI = end;
		start = Math.min(newInterval.start, intervals.get(start).start);
		end = Math.max(newInterval.end, intervals.get(end).end);
		List<Interval> result = new ArrayList<>();
		
		for(int i = 0; i < startI; i++)
			result.add(intervals.get(i));
		
		result.add(new Interval(start, end));
		
		for(int i = endI + 1; i < intervals.size(); i++)
			result.add(intervals.get(i));
		
		return result;
	}

	private static List<Interval> createIntervals() {
		Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(3, 5);
		Interval i3 = new Interval(6, 7);
		Interval i4 = new Interval(8, 10);
		Interval i5 = new Interval(12, 16);
		
//		Interval i6 = new Interval(1, 3);
//		Interval i7 = new Interval(6, 9);
		
		return Arrays.asList(i1, i2, i3, i4, i5);
	}

}
