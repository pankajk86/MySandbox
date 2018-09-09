package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import facebook.Interval;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		List<List<Interval>> intervals = createIntervals();
		List<Interval> result = getFreeTimesValid(intervals);

		for (Interval i : result)
			System.out.println("[" + i.start + ", " + i.end + "]");
	}

	private static List<Interval> getFreeTimesValid(List<List<Interval>> intervals) {
		List<Interval> result = new ArrayList<>();

		if (intervals == null || intervals.size() == 0)
			return result;
		
		List<Integer> start = new ArrayList<>();
		List<Integer> end = new ArrayList<>();
		
		for(List<Interval> list: intervals) {
			if(list != null) {
				for(Interval i: list) {
					start.add(i.start); end.add(i.end);
				}
			}
		}
		
		Collections.sort(start); Collections.sort(end);
		
		for(int i = 0; i < start.size() - 1; i++) {
			if(end.get(i) < start.get(i + 1))
				result.add(new Interval(end.get(i), start.get(i + 1)));
		}
		
		return result;
	}

	@SuppressWarnings("unused")
	private static List<Interval> getFreeTimes(List<List<Interval>> intervals) {

		List<Interval> result = new ArrayList<>();

		if (intervals == null || intervals.size() == 0)
			return result;

		List<Interval> all = new ArrayList<>();
		for (List<Interval> i : intervals)
			all.addAll(i);

		Collections.sort(all, new Comparator<Interval>() {

			@Override
			public int compare(Interval i1, Interval i2) {

				if (i1.start < i2.start)
					return -1;
				else if (i1.start > i2.start)
					return 1;
				else {
					if (i1.end < i2.end)
						return -1;
					else if (i1.end > i2.end)
						return 1;
					else
						return 0;
				}
			}
		});

		for (int i = 0; i < all.size() - 1; i++) {
			Interval current = all.get(i), next = all.get(i + 1);
			if (current.end < next.start)
				result.add(new Interval(current.end, next.start));
		}

		return result;
	}

	private static List<List<Interval>> createIntervals() {

		List<List<Interval>> intervals = new ArrayList<>();

		List<Interval> l1 = new ArrayList<>();
		Interval i1 = new Interval(1, 3);
		Interval i2 = new Interval(6, 7);
		l1.addAll(Arrays.asList(i1, i2));

		List<Interval> l2 = new ArrayList<>();
		Interval i3 = new Interval(2, 4);
		l2.add(i3);

		List<Interval> l3 = new ArrayList<>();
		Interval i4 = new Interval(2, 5);
		Interval i5 = new Interval(9, 12);
		l3.addAll(Arrays.asList(i4, i5));

		intervals.addAll(Arrays.asList(l1, l2, l3));

		return intervals;
	}

}
