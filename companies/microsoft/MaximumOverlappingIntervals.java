package microsoft;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MaximumOverlappingIntervals {

	public static void main(String[] args) {
		Interval[] intervals = getIntervals();
		int result = getMaxOverlappingIntervals(intervals);
		System.out.println(result);
	}

	private static int getMaxOverlappingIntervals(Interval[] intervals) {
		Set<Interval> set = new HashSet<>();
		int layers = -1, end = -1;
		
		Arrays.sort(intervals, new Comparator<Interval>() {

			@Override
			public int compare(Interval i1, Interval i2) {
				if(i1.begin < i2.begin) return -1;
				else if(i1.begin > i2.begin) return 1;
				else {
					if(i1.end < i2.end) return -1;
					else if(i1.end > i2.end) return 1;
					else return 0;
				}
			}
			
		});
		
		for(int i = 0; i < intervals.length; i++)
			set.add(intervals[i]);
		
		while(!set.isEmpty()) {
			for(int i = 0; i < intervals.length; i++) {
				if(set.contains(intervals[i]) && intervals[i].begin > end) {
					set.remove(intervals[i]);
					end = intervals[i].end;
				}
			}
			end = -1;
			layers++;
		}
		return Math.max(layers, 0);
	}

	private static Interval[] getIntervals() {
		Interval[] intervals = new Interval[10];
        intervals[0] = new Interval(0, 3);
        intervals[1] = new Interval(2, 4);
        intervals[2] = new Interval(3, 6);
        intervals[3] = new Interval(4, 5);
        intervals[4] = new Interval(5, 9);
        intervals[5] = new Interval(7, 8);
        intervals[6] = new Interval(6, 7);
        intervals[7] = new Interval(9, 11);
        intervals[8] = new Interval(7, 13);
        intervals[9] = new Interval(3, 8);
        return intervals;
	}
}

class Interval {
	int begin;
	int end;

	Interval(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
}