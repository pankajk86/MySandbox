package linkedin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import facebook.Interval;

public class TotalCoverageOfIntervals {

	public static void main(String[] args) {
		List<Interval> intervals = createIntervals();
		int result = totalCoverage(intervals);
		System.out.println(result);
	}

	private static int totalCoverage(List<Interval> intervals) {
		if(intervals == null || intervals.size() == 0) return 0;
		
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if(a.start != b.start) return a.start - b.start;
				return a.end - b.end;
			}}
		);
		
		int start = intervals.get(0).start, end = intervals.get(0).end;
		int result = 0;
		
		for(int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if(curr.start <= end) end = Math.max(curr.end, end);
			else {
				result += end - start;
				start = curr.start; end = curr.end;
			}
		}
		
		result += end - start;
		return result;
	}

	private static List<Interval> createIntervals() {
		List<Interval> intervals = new ArrayList<>();
		intervals.addAll(Arrays.asList(
				new Interval(3, 6), 
				new Interval(8, 9),
				new Interval(1, 5))
			);
		return intervals;
	}

	
	
}


