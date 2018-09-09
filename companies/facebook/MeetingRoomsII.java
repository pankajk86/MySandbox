package facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {

	public static void main(String[] args) {
		Interval[] intervals = createIntervals();
		int result = minMeetingRooms(intervals);
		System.out.println(result);
	}

	private static int minMeetingRooms(Interval[] intervals) {

		if(intervals == null || intervals.length == 0)
			return 0;
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		PriorityQueue<Interval> pq = new PriorityQueue<>(intervals.length, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.end - i2.end;
			}
		});

		pq.add(intervals[0]);
		
		for(int i = 1; i < intervals.length; i++) {
			Interval current = pq.poll();
			
			if(intervals[i].start >= current.end) {
				current.end = intervals[i].end;
			} else {
				pq.add(intervals[i]);
			}
			pq.add(current);
		}
		
		return pq.size();
	}

	private static Interval[] createIntervals() {

		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		
		return intervals;
	}

}

