package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import facebook.Interval;

public class MergeIntervals {
	
	public static void main(String[] args) {
		List<Interval> intervals = createIntervals();
		List<Interval> result = merge(intervals);
		
		System.out.println(result);
	}
	
	private static List<Interval> merge(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		
		Collections.sort(intervals, new Comparator<Interval>() {
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
		
		int start = intervals.get(0).start, end = intervals.get(0).end;
		
		for(Interval interval: intervals) {
			if(interval.start <= end)
				end = Math.max(interval.end, end);
			else {
				result.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		
		result.add(new Interval(start, end));
		return result;
	}
	
	private static List<Interval> createIntervals() {
		List<Interval> intervals = new ArrayList<>();
		intervals.addAll(Arrays.asList(
				new Interval(2,6),
				new Interval(1,3),
				new Interval(8,10),
				new Interval(13,16),
				new Interval(15,18)
			));
		return intervals;
	}
}
