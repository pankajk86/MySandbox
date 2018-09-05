package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MyPeekingIterator {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>();
		a.addAll(Arrays.asList(1, 2, 3));
		
		Iterator<Integer> it = a.iterator();
		PeekingIterator pit = new PeekingIterator(it);
		while(pit.hasNext()) {
			System.out.println(pit.next());
			System.out.println(pit.peek());
		}
	}

}

class PeekingIterator implements Iterator<Integer> {

	private Queue<Integer> q = null;

	public PeekingIterator(Iterator<Integer> iterator) {
		q = new LinkedList<>();
		
		while(iterator.hasNext()) {
			q.add(iterator.next());
		}
	}

	public Integer peek() {
		return q.peek();
	}

	@Override
	public boolean hasNext() {
		return !q.isEmpty();
	}

	@Override
	public Integer next() {
		return q.poll();
	}

}
