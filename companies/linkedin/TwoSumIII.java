package linkedin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumIII {
	
	private List<Integer> list = null;
	
	public TwoSumIII() {
		list = new ArrayList<>();
	}
	
	public void add(int n) {
		this.list.add(n);
	}
	
	public boolean find(int value) {
		Collections.sort(this.list);
		int start = 0, end = list.size() - 1;
		
		while(start < end) {
			int current = list.get(start) + list.get(end);
			if(current == value) return true;
			else if(current < value) start++;
			else end--;
		}
		
		return false;
	}
}
