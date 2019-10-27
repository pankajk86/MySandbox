package facebook;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		int[][] intervals = {{1, 5}};
		int[] interval =  {4, 8};
		
		int[][] result2 = insertInterval(intervals, interval);
		for(int[] i: result2) System.out.print("(" + i[0] + " " + i[1] + ") ");
	}

	private static int[][] insertInterval(int[][] intervals, int[] interval) {
		
		List<int[]> list = new ArrayList<>();
		int index = 0;
		
		for(int[] i: intervals) {
			if(i[1] < interval[0]) {
				list.add(i);
				index++;
			} else if(i[0] > interval[1]) {
				list.add(i);
			} else {
				interval[0] = Math.min(interval[0], i[0]);
				interval[1] = Math.max(interval[1], i[1]);
			}
		}
		
		list.add(index, interval);
		
		int[][] result = new int[list.size()][2];
		for(int i = 0; i < list.size(); i++) result[i] = list.get(i);
		
		return result;
	}
}
