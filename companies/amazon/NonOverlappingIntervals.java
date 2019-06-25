package amazon;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
		int result = nonOverlappingIntevals(intervals);
		System.out.println(result);
	}

	private static int nonOverlappingIntevals(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] i1, int[] i2) {
				return i1[1] - i2[1];
			}
		});
		
		int count = 1, end = intervals[0][1];
		for(int i = 1; i < intervals.length; i++) {
			if(intervals[i][0] >= end) {
				count++;
				end = intervals[i][1];
			}
		}
		
		return intervals.length - count;
	}

}
