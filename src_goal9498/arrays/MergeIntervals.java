package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeIntervals {
	
	static MergeIntervals mi = new MergeIntervals();

	public static void main(String[] args) {
		
		
		List<Interval> intervals = new ArrayList<>();
		intervals.addAll(Arrays.asList(
				mi.new Interval(2,6),
				mi.new Interval(1,3),
				mi.new Interval(8,10),
				mi.new Interval(13,16),
				mi.new Interval(15,18)
			));
		
		List<Interval> result = merge(intervals);
		System.out.println(result.size());
		
		result = merge2(intervals);
		System.out.println(result.size());
	}

	private static List<Interval> merge(List<Interval> intervals) {

		List<Interval> result = new ArrayList<>();
		
		Comparator<Interval> comparator = new Comparator<>() {

			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start < i2.start ? -1 : 1;
			}
		};
		
		Collections.sort(intervals, comparator);
		
		for(int i = 0; i < intervals.size(); ) {
			Interval current = intervals.get(i);
			
			if(i < intervals.size() - 1) {
				while(intervals.get(i + 1).start <= current.end) {
					i++;
					if(i == intervals.size() - 1) {
						break;
					}
				}
			}

			Interval merged = mi.new Interval(current.start, intervals.get(i).end);
			result.add(merged);
			i++;
		}
		
		return result;
	}

	class Interval {
		int start;
	    int end;
	    Interval() { start = 0; end = 0; }
	    Interval(int s, int e) { start = s; end = e; }
	}
	
	
	// TRYING AGAIN
	private static List<Interval> merge2(List<Interval> intervals) {
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
				result.add(mi.new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		
		result.add(mi.new Interval(start, end));
		return result;
	}
}
