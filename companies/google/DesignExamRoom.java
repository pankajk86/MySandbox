package google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DesignExamRoom {

	public static void main(String[] args) {
		ExamRoom er = new ExamRoom(8);
		System.out.print(er.seat() + " ");
		System.out.print(er.seat() + " ");
		System.out.print(er.seat() + " ");
		er.leave(0);
		er.leave(7);
		System.out.print(er.seat() + " ");
		System.out.print(er.seat() + " ");
		System.out.print(er.seat() + " ");
		System.out.print(er.seat() + " ");
		System.out.print(er.seat() + " ");
		System.out.print(er.seat() + " ");
		System.out.println(er.seat());
	}

}

class ExamRoom {
	
	private PriorityQueue<Interval> pq;
	private int n;

	public ExamRoom(int n) {
		this.n = n;
		this.pq = new PriorityQueue<>(new Comparator<Interval>() {
			@Override
			public int compare(Interval a, Interval b) {
				if(a.distance != b.distance) return b.distance - a.distance;
				else return a.start - b.start;
			}
		});
		pq.add(new Interval(-1, n));
	}

	public int seat() {
		int seat = 0;
		Interval curr = pq.poll();
		
		if(curr.start == -1) seat = 0;
		else if(curr.end == n) seat = n - 1;
		else seat = (curr.start + curr.end) / 2;
		
		pq.add(new Interval(curr.start, seat));
		pq.add(new Interval(seat, curr.end));
		
		return seat;
	}

	public void leave(int p) {
		Interval head = null, tail = null;
		List<Interval> intervals = new ArrayList<>(pq);
		
		for(Interval interval: intervals) {
			if(interval.start == p) tail = interval;
			if(interval.end == p) head = interval;
			
			if(head != null && tail != null) break;
		}
		
		pq.remove(head); pq.remove(tail);
		pq.add(new Interval(head.start, tail.end));
	}
	
	class Interval {
		int start, end, distance;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
			
			if(this.start == -1) this.distance = end;
			if(this.end == n) this.distance = n - 1 - start;
			else this.distance = Math.abs(start - end) / 2;
		}
	}
}