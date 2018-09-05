package google;

import java.util.TreeMap;

public class MyCalendarI {

	public static void main(String[] args) {

		MyCalendar calendar = new MyCalendar();
		System.out.println(calendar.book(10, 20));
		System.out.println(calendar.book(15, 25));
		System.out.println(calendar.book(20, 30));
	}

}

class MyCalendar {
	TreeMap<Integer, Integer> calendar;
	
	public MyCalendar() {
		this.calendar = new TreeMap<>();
	}
	
	public boolean book(int start, int end) {
		Integer floorKey = calendar.floorKey(start);
		if(floorKey != null && calendar.get(floorKey) > start) return false;
		
		Integer ceilingKey = calendar.ceilingKey(start);
		if(ceilingKey != null && ceilingKey < end) return false;
		
		calendar.put(start, end);
		return true;
	}
}