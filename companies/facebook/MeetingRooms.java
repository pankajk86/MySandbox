package facebook;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms {

	public static void main(String[] args) {
		Interval[] intervals = createIntervals();
		boolean result = canAttendMeetings(intervals);
		System.out.println(result);
		
		intervals = createIntervals2();
		result = canAttendMeetings(intervals);
		System.out.println(result);
	}

	private static boolean canAttendMeetings(Interval[] intervals) {

		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				return i1.start - i2.start;
			}
		});
		
		for(int i = 0; i < intervals.length - 1; i++) {
			if(intervals[i].end > intervals[i + 1].start)
				return false;
		}
		
		return true;
	}

	private static Interval[] createIntervals() {

		Interval[] intervals = new Interval[3];
		intervals[1] = new Interval(0, 30);
		intervals[0] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);
		
		return intervals;
	}
	
	private static Interval[] createIntervals2() {

		Interval[] intervals = new Interval[3];
		intervals[1] = new Interval(7, 10);
		intervals[0] = new Interval(2, 4);
		intervals[2] = new Interval(15, 20);
		
		return intervals;
	}
}
