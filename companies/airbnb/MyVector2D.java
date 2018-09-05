package airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyVector2D {

	public static void main(String[] args) {
		List<List<Integer>> vec2d = new ArrayList<>();
		List<Integer> l1 = Arrays.asList(1, 2);
		List<Integer> l2 = Arrays.asList(3);
		List<Integer> l3 = Arrays.asList(4, 5, 6);
		
		vec2d.addAll(Arrays.asList(l1, l2, l3));
		
		Vector2D vec = new Vector2D(vec2d);
		
		while(vec.hasNext()) {
			System.out.println(vec.next());
		}
	}

}


class Vector2D implements Iterator<Integer> {
	
	private List<List<Integer>> vec2d = null;
	private int vecIndex = 0, elemIndex = 0;
	
	public Vector2D(List<List<Integer>> vec2d) {
		this.vec2d = vec2d;
	}

	@Override
	public boolean hasNext() {

		if(vecIndex < vec2d.size() && vec2d.get(vecIndex).isEmpty()) {
			while(vec2d.get(vecIndex).isEmpty()) {
				vecIndex++;
				if(vecIndex == vec2d.size())
					return false;
			}
		}
		
		if(vecIndex < vec2d.size() - 1)
			return true;
		else if(vecIndex == vec2d.size() - 1) {
			if(elemIndex < vec2d.get(vecIndex).size())
				return true;
			else return false;
		}
		return false;
	}

	@Override
	public Integer next() {
		Integer result = null;
		List<Integer> vector = vec2d.get(vecIndex);
		
		if(vector != null && !vector.isEmpty()) {
			result = vector.get(elemIndex);
			if(elemIndex == vec2d.get(vecIndex).size() - 1) {
				vecIndex++; elemIndex = 0;
			} else {
				elemIndex++;
			}
		} else {
			vecIndex++; elemIndex = 0;
			if(hasNext()) {
				result = next();
			}
		}
		return result;
	}
	
}