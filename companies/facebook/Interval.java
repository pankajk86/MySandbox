package facebook;

public class Interval {
	public int start, end;

	Interval() {
		this.start = 0;
		this.end = 0;
	}

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
	public String toString() {
		return "[" + this.start + ", " + this.end + "]";
	}
}